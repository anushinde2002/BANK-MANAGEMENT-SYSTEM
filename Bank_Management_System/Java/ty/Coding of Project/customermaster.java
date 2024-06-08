import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class customermaster extends JFrame implements ActionListener
{
 JLabel limg;
 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,lmsg;
 JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
 JButton b1,b2,b3,b4,b5,b6;
 PreparedStatement pst=null;
 ResultSet rs=null;
 Connection cn=null;
 Statement st=null;
 public customermaster()
 {
   Container con=getContentPane();
   con.setLayout(null);

  setLayout(new FlowLayout());
  setTitle("CUSTOMER MASTER FORM");
  setSize(600,500);
  setVisible(true);
//  setForeground(Color.PINK);
  l1=new JLabel("Customer code :");
  l2=new JLabel("Customer name :");
  l3=new JLabel("Date of birth :");
  l4=new JLabel("Gender :");
  l5=new JLabel("Age :");
  l6=new JLabel("Permanant adderess :");
  l7=new JLabel("Local adderess :");
  l8=new JLabel("Ref. name :");
  l9=new JLabel("Nominee name :");
//  l10=new JLabel("Phone :");
  lmsg=new JLabel(" ");

  t1=new JTextField(20);
  t2=new JTextField(20);  
  t3=new JTextField(20);
  t4=new JTextField(20);
  t5=new JTextField(20);
  t6=new JTextField(20);
  t7=new JTextField(20);
  t8=new JTextField(20);
  t9=new JTextField(20);
//  t10=new JTextField(20);

  b1=new JButton("Addnew",new ImageIcon("new.gif"));
  b1.addActionListener(this);
  b2=new JButton("Save",new ImageIcon("save.gif"));
  b2.addActionListener(this);
  b3=new JButton("Update",new ImageIcon("paste.gif"));
  b3.addActionListener(this);
  b4=new JButton("Exit",new ImageIcon("export.gif"));
  b4.addActionListener(this);
  b5=new JButton("Find",new ImageIcon("find.gif"));
  b5.addActionListener(this);
  b6=new JButton("Delete",new ImageIcon("delete.gif"));
  b6.addActionListener(this);
  
  Panel p=new Panel();
  //p.setLayout(new GridLayout(7,2,1,1));
  p.setLayout(new GridLayout(10,2));

  p.add(l1);
  p.add(t1);
  p.add(l2);
  p.add(t2);
  p.add(l3);
  p.add(t3);
  p.add(l4);
  p.add(t4);
  p.add(l5);
  p.add(t5);
  p.add(l6);
  p.add(t6);
  p.add(l7);
  p.add(t7);
  p.add(l8);
  p.add(t8);
  p.add(l9);
  p.add(t9);
//  p.add(l10);
//  p.add(t10);
  p.setBackground(Color.PINK);
  p.setBounds(100,120,250,100);
  con.add(p);
  
  Panel p1=new Panel();
  p1.add(b1);
  p1.add(b2);
  p1.add(b3);
  p1.add(b4);
  p1.add(lmsg);
  this.getContentPane().add(p1,"center");
  p1.setBackground(Color.PINK);
  p1.setBounds(50,220,370,100);
  con.add(p1);

  Panel p3=new Panel();
  p3.add(b5);
  p3.add(b6);
  p3.setBackground(Color.PINK);
  
  Panel p2=new Panel(new GridLayout(2,2));
  p2.add(p1);
  p2.add(p3);
  p2.setBackground(Color.PINK);
  con.setBackground(Color.PINK);

  add(p);
  add(p2);

  limg=new JLabel(" ",new ImageIcon("flower.gif"),JLabel.RIGHT);
 add(limg);
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   cn=DriverManager.getConnection("Jdbc:Odbc:bank");
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs=st.executeQuery("select * from customer_master");
   rs.next();
  }
  catch(Exception e)
  {
   System.out.println(" "+e);
  }
 }
 public void getData()
 {
  try
  {
   t1.setText(rs.getString(1));
   t2.setText(rs.getString(2));
   t3.setText(rs.getString(3));
   t4.setText(rs.getString(4));
   t5.setText(rs.getString(5));
   t6.setText(rs.getString(6));
   t7.setText(rs.getString(7));
   t8.setText(rs.getString(8));
   t9.setText(rs.getString(9));
//   t10.setText(rs.getString(10));
  }
  catch(Exception e)
  {
   JOptionPane.showMessageDialog(this,"error");
  }
 }
 public void actionPerformed(ActionEvent ae)
 {
  try
  {
   if(ae.getSource()==b1)
   {
    t1.setText(" ");
    t2.setText(" ");
    t3.setText(" ");
    t4.setText(" ");
    t5.setText(" ");
    t6.setText(" ");
    t7.setText(" ");
    t8.setText(" ");
    t9.setText(" ");
  //  t10.setText(" ");
   }
   if(ae.getSource()==b2)
   {
    try
    {
     pst=cn.prepareStatement("insert into customer_master values(?,?,?,?,?,?,?,?,?)");
     pst.setString(1,t1.getText());
     pst.setString(2,t2.getText());
     pst.setString(3,t3.getText());
     pst.setString(4,t4.getText());
     pst.setString(5,t5.getText());
     pst.setString(6,t6.getText());
     pst.setString(7,t7.getText());
     pst.setString(8,t8.getText());
     pst.setString(9,t9.getText());
//     pst.setString(10,t10.getText());
     pst.executeUpdate();
    JOptionPane.showMessageDialog(this,"Details have been added");
    }
    catch(Exception e2)
    {
     JOptionPane.showMessageDialog(this,"add is+"+e2);     
    }
   }
   if(ae.getSource()==b3)
   {
    pst=cn.prepareStatement("update customer_master set         customer_name=?,DOB=?,gender=?,age=?,peradd=?,locadd=?,refname=?,phone=?        where customer_code=?");
    pst.setString(1,t2.getText());
    pst.setString(2,t3.getText());
    pst.setString(3,t4.getText());
    pst.setString(4,t5.getText());
    pst.setString(5,t6.getText());
    pst.setString(6,t7.getText());
    pst.setString(7,t8.getText());
    pst.setString(8,t9.getText());
    pst.setString(9,t1.getText());
    //pst.setString(10,t1.getText());
    pst.executeUpdate();
    JOptionPane.showMessageDialog(this,"Record Updated");
   }
   if(ae.getSource()==b4)
   {
    //System.exit(0);
    frame f=new frame();
    this.hide();                                                                         
    f.show();                          
   }
   if(ae.getSource()==b5)
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
         t3.setText(rs.getString(3));
         t4.setText(rs.getString(4));
         t5.setText(rs.getString(5));
         t6.setText(rs.getString(6));
         t7.setText(rs.getString(7));
         t8.setText(rs.getString(8));
         t9.setText(rs.getString(9));
         break;
         }
        }
        while(rs.next());
        if(rs.isAfterLast())
        {
         JOptionPane.showMessageDialog(this,"Record not found");   //for showing last rec
         rs.last();
         if(!rs.isAfterLast())
         getData();
         }
       }
   if(ae.getSource()==b6)
   {
    pst=cn.prepareStatement("delete from customer_master where customer_code=?");
    pst.setString(1,t1.getText());
    pst.executeUpdate();
    JOptionPane.showMessageDialog(this,"Record has been deleted");
         if(rs.isAfterLast())
        {
         JOptionPane.showMessageDialog(this,"Record not found");   //for showing last rec
         rs.last();
         if(!rs.isAfterLast())
         getData();
         }

   }
   //this.hide();
   
  }
  catch(Exception e)
  {
   JOptionPane.showMessageDialog(this,"error is="+e);   
  }
 }
 public static void main(String args[])
 {
  customermaster cm=new customermaster();
 }
}