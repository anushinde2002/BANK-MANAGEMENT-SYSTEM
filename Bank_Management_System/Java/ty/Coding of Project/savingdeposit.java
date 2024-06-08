import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class savingdeposit extends JFrame implements ActionListener,ItemListener
{
  JLabel limg;
 JLabel l1,l2,l3,l4,l5,l6,l7,l8,lmsg;
 JTextField t1,t2,t3,t4,t5,t6,t7,t8;
 JCheckBox c1,c2;
// CheckboxGroup cg1;
 JButton b1,b2,b3,b4,b5,b6;
 PreparedStatement pst=null;
 ResultSet rs=null;
 Connection cn=null;
 Statement st=null;
 public savingdeposit()
 {
   Container con=getContentPane();
   con.setLayout(null);

  setLayout(new FlowLayout());
  setVisible(true);
  setSize(550,500);
  setTitle("SAVING DEPOSIT FORM");
//  cg1=new CheckboxGroup();
//  setBackground(Color.PINK);

  l1=new JLabel("Enter account no. :");
  l2=new JLabel("Name :");
  l3=new JLabel("Enter amount :");
  l4=new JLabel("Cheque no. :");
  l5=new JLabel("Date :");
  l6=new JLabel("Account type :");
  l7=new JLabel("Branch :");
  l8=new JLabel("Current balance :");
  lmsg=new JLabel(" ");

  t1=new JTextField(20);
  t2=new JTextField(20);  
  t3=new JTextField(20);
  t4=new JTextField(20);
  t5=new JTextField(20);
  t6=new JTextField(20);
  t7=new JTextField(20);
  t8=new JTextField(20);

  b1=new JButton("Addnew",new ImageIcon("new.gif"));
  b1.addActionListener(this);
  b2=new JButton("Save",new ImageIcon("save.gif"));
  b2.addActionListener(this);
  b3=new JButton("Update",new ImageIcon("paste.gif"));
  b3.addActionListener(this);
  b4=new JButton("Exit",new ImageIcon("export.gif"));
  b4.addActionListener(this);
  b5=new JButton("Previous",new ImageIcon("refresh.gif"));
  b5.addActionListener(this);
  b6=new JButton("Next",new ImageIcon("refresh.gif"));
  b6.addActionListener(this);

//  CheckboxGroup cg1=new CheckboxGroup();
  c1=new JCheckBox("Cash");//,cg1,false);
  c1.addItemListener(this);
  c2=new JCheckBox("Cheque");//,cg1,false);
  c2.addItemListener(this);
 
//  cg1.add(c1);
//  cg1.add(c2);
  
//  Panel p=new Panel();
//  p.setLayout(new GridLayout(7,2,1,1));
  Panel p=new Panel(new GridLayout(10,2));
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
  p.add(c1);
  p.add(c2);
  p.setBackground(Color.PINK);
  p.setBounds(100,120,250,100);
  con.add(p);

//  add(p);    

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
  c1.setBackground(Color.PINK);
  c2.setBackground(Color.PINK);
  con.setBackground(Color.PINK);

  add(p);
  limg=new JLabel(" ",new ImageIcon("sd.gif"),JLabel.RIGHT);
  add(limg);

  add(p2);

  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   cn=DriverManager.getConnection("Jdbc:Odbc:bank");
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs=st.executeQuery("select * from deposit");
   rs.next();
  }
  catch(Exception e)
  {
   System.out.println(" "+e);
  }
 ItemListener iteml = new ItemListener()
 {
      public void itemStateChanged(ItemEvent ie) 
{
        int state = ie.getStateChange();
        if (state == ItemEvent.SELECTED)
 {	
         cheque c=new cheque();
	c.show();
        }
      }
    };
c2.addItemListener(iteml);
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
   }
   if(ae.getSource()==b2)
   {
    try
    {
     pst=cn.prepareStatement("insert into deposit values(?,?,?,?,?,?,?,?)");
     pst.setString(1,t1.getText());
     pst.setString(2,t2.getText());
     pst.setString(3,t3.getText());
     pst.setString(4,t4.getText());
     pst.setString(5,t5.getText());
     pst.setString(6,t6.getText());
     pst.setString(7,t7.getText());
     pst.setString(8,t8.getText());
    JOptionPane.showMessageDialog(this,"Details have been added");
     pst.executeUpdate();
    }
    catch(Exception e2)
    {
     JOptionPane.showMessageDialog(this,"add is+"+e2);     
    }
   }
   if(ae.getSource()==b3)
   {
    pst=cn.prepareStatement("update deposit set ddate=?,cname=?,acctype=?,amt=?,branch=?,chqno=?,curbal=? where acno=?");
    pst.setString(1,t1.getText());
    pst.setString(2,t2.getText());
    pst.setString(3,t3.getText());
    pst.setString(4,t4.getText());
    pst.setString(5,t5.getText());
    pst.setString(6,t6.getText());
    pst.setString(7,t7.getText());
    pst.setString(8,t8.getText());
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
    rs.next();
    if(!rs.isAfterLast())
    getData();
   }
   if(ae.getSource()==b6)
   {
    rs.previous();
    if(!rs.isBeforeFirst());
    getData();
   }
   //this.hide();
}
  catch(Exception e)
  {
   JOptionPane.showMessageDialog(this,"error is="+e);   
  }
 }
public void itemStateChanged(ItemEvent ie)
{
/*
 if(c1.getState())
 c1.setState(true);
 else
 if(c2.getState())
 c2.setState(true);
*/
 }
 public static void main(String args[])
 {
  savingdeposit sd=new savingdeposit();
 }
}