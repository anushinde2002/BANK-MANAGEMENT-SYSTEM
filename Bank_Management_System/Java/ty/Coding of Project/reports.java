import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class reports extends JFrame implements ActionListener
{
   JLabel limg;
  JLabel l1; JTextField t1;
  JButton b1,b2;
  JTable tbl;
  JScrollPane jsp;
  Vector heads,data;
  Connection cn;
  Statement st;
  ResultSet rs;

  public reports()
  {
   setVisible(true); 
   setSize(400,500); 
   setTitle("reports");
   setLayout(new BorderLayout());

   l1=new JLabel("TableName");
   t1=new JTextField(50);
   b1=new JButton("Show",new ImageIcon("B1.gif"));
   b2=new JButton("Quit",new ImageIcon("B.gif"));
   b1.addActionListener(this);
   b2.addActionListener(this);

  JPanel p1=new JPanel();
  p1.add(l1);
  p1.add(t1);
  p1.add(b1);
  p1.add(b2);
  add(p1,BorderLayout.NORTH);  

  limg=new JLabel(" ",new ImageIcon("print.gif"),JLabel.RIGHT);
 add(limg);

  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   cn=DriverManager.getConnection("jdbc:odbc:bank");
   st=cn.createStatement();
  }
  catch(Exception ex)
  {
   JOptionPane.showMessageDialog(this,"Error is "+ex);
  }
 }

  public void actionPerformed(ActionEvent ae)
  {
   try
   {
     if(ae.getSource()==b2)
     {
      frame f=new frame();
      this.hide();
      f.show();
     }
     else
      if(ae.getSource()==b1)
      {
       if(t1.getText().trim().length()==0)
       {
        JOptionPane.showMessageDialog(this,"Enter TableName");
        return;
       }
        String tname=t1.getText().trim();
        rs=st.executeQuery("select * from "+tname);
        ResultSetMetaData rsm=rs.getMetaData();
        int cols=rsm.getColumnCount();
        data=new Vector();
        heads=new Vector();
        for(int i=1;i<=cols;i++)
        heads.add(rsm.getColumnLabel(i));

       while(rs.next())
       {
         Vector r=new Vector();
         for(int i=1;i<=cols;i++)
         r.add(rs.getString(i));
         
         data.add(r);
       }
       tbl=new JTable(data,heads);

       if(jsp!=null) 
       remove(jsp);

       jsp=new JScrollPane(tbl,20,30);
      add(jsp);

      validate();
      invalidate();
      doLayout();
     }
   }
   catch(Exception ex)
   {
    JOptionPane.showMessageDialog(this,"Error is "+ex);
   } 
  }
  public static void main(String args[])
  {
   new reports();
  }
}