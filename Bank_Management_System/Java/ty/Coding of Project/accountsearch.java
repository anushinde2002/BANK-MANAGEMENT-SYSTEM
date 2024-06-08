import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class accountsearch extends JFrame implements ActionListener
{
  JLabel limg;
 JLabel l1,l2,l3,l4,lmsg;
 JTextField t1,t2,t3,t4;
 JButton b1,b2;
 PreparedStatement pst=null;
 ResultSet rs=null;
 Connection cn=null;
 Statement st=null;
 public accountsearch()
 {
   Container con=getContentPane();
   con.setLayout(null);

  setLayout(new FlowLayout());
  setTitle("ACCOUNT SEARCH");
  setSize(500,500);
  setVisible(true);
//  setForeground(Color.PINK);

  l1=new JLabel("Enter account no. :");
  l2=new JLabel("Customer name :");
  l3=new JLabel("Type of account :");
  l4=new JLabel("current balance :");
  lmsg=new JLabel(" ");

  t1=new JTextField(20);
  t2=new JTextField(20);  
  t3=new JTextField(20);
  t4=new JTextField(20);

  b1=new JButton("Search",new ImageIcon("Search.gif"));
  b1.addActionListener(this);
  b2=new JButton("Exit",new ImageIcon("export.gif"));
  b2.addActionListener(this);
 
  Panel p=new Panel();
  p.setLayout(new GridLayout(7,2,1,1));
//  Panel p=new Panel(new GridLayout(4,2));
  p.add(l1);
  p.add(t1);
  p.add(l2);
  p.add(t2);
  p.add(l3);
  p.add(t3);
  p.add(l4);
  p.add(t4);
  p.setBackground(Color.PINK);
  p.setBounds(100,120,250,100);
  con.add(p);
  
//  add(p);  
  Panel p1=new Panel();
  p1.add(b1);
  p1.add(b2);
  p1.add(lmsg);
  this.getContentPane().add(p1,"center");
  p1.setBackground(Color.PINK);
  p1.setBounds(50,220,370,100);
  con.add(p1);

  Panel p2=new Panel(new GridLayout(2,2));
  p2.add(p1);
  p2.setBackground(Color.PINK);
  con.setBackground(Color.PINK);

  add(p2);
  add(p);
  limg=new JLabel(" ",new ImageIcon("as1.gif"),JLabel.RIGHT);
  add(limg);

  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   cn=DriverManager.getConnection("Jdbc:Odbc:bank");
   JOptionPane.showMessageDialog(this,"Connected Successfully");
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs=st.executeQuery("select * from account_master order by acno");
   rs.next();
  }
  catch(Exception e)
  {
   System.out.println(" "+e);
  }
         addWindowListener(
         new WindowAdapter()
         {
            public void windowClosing(WindowEvent we)
            {
	try
	{
	    if(cn!=null)   cn.close();
	}
	catch(Exception ex)
	{
	    //JOptionPane.showMessageDialog(this,"Error is"+ex);
	    System.out.println("Error is"+ex);
 	}
	dispose();
           }          
        }
       );

 }
/* public void getData()
 {
  try
  {
   t1.setText(rs.getString(1));
   t2.setText(rs.getString(2));
   t3.setText(rs.getString(3));
   t4.setText(rs.getString(4));
  }
  catch(Exception e)
  {
   JOptionPane.showMessageDialog(this,"error");
  }
 }*/
 public void actionPerformed(ActionEvent ae)
 {
  try
  {
   if(ae.getSource()==b1)
   {
                String cno=JOptionPane.showInputDialog(this,"Enter Account No.");
	rs.first();
	do
                {
	    String cno1=rs.getString(1);
	     if(cno.equals(cno1))
	     {
	          t1.setText(cno);
	          t2.setText(rs.getString(2));
	          t3.setText(rs.getString(5));
	          t4.setText(rs.getString(4));
	          
	          break;
	     }
                }
	while(rs.next());
	if(rs.isAfterLast())
	{
	   JOptionPane.showMessageDialog(this,"Record not found");   //for showing last rec
   	    rs.last();
	    showRec();
                }
            }

/*    t1.setText(" ");
    t2.setText(" ");
    t3.setText(" ");
    t4.setText(" ");
   }*/
   else
   if(ae.getSource()==b2)
   {
    //System.exit(0);
    frame f=new frame();
    this.hide();                                                                         
    f.show();                          
   }
  }
  catch(Exception e)
  {
   JOptionPane.showMessageDialog(this,"error is="+e);   
  }
 }
 public static void main(String args[])
 {
  accountsearch as=new accountsearch();
 }
    void showRec() 
    {
        try
       {              
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
             t3.setText(rs.getString(3));
             t4.setText(rs.getString(4));
             
       }
      catch(SQLException ex)
      {
           JOptionPane.showMessageDialog(this,"Error is"+ex);
      }
   }

}