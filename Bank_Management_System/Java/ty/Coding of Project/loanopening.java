import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class loanopening extends JFrame implements ActionListener,ItemListener
{
 JLabel limg;
 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,lmsg;
 JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
 JButton b1,b2,b3,b4,b5,b6;
// JRadioButton r1,r2;
// CheckboxGroup cg1;
 Choice c1;
 PreparedStatement pst=null;
 ResultSet rs=null;
 Connection cn=null;
 Statement st=null;
 public loanopening()
 {
   Container con=getContentPane();
   con.setLayout(null);

  setLayout(new FlowLayout());
  setTitle("LOAN OPENING FORM");
  setSize(1000,1000);
  setVisible(true);
//  setForeground(Color.PINK);
  l1=new JLabel("Loan no. :");
  l2=new JLabel("Customer name :");
  l3=new JLabel("Date of issue :");
  l4=new JLabel("Rate of intrest :");
  l5=new JLabel("Amount :");
  l6=new JLabel("Maturity Date :");
  l7=new JLabel("A/c no :");
  l8=new JLabel("Type of loan :");
  c1=new Choice();
  c1.add("Home loan");
  c1.add("Personal loan");
  c1.add("Educational loan");
  c1.add("Vehical loan");
  l9=new JLabel("Total installment :");
  l10=new JLabel("Type of security :");
  l11=new JLabel("Reason of loan :");
  l12=new JLabel("Ref. name :");
  l13=new JLabel("Ref acc no. :");	
  l14=new JLabel("Ref address :");
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
  t10=new JTextField(20);
  t11=new JTextField(20);
  t12=new JTextField(20);
  t13=new JTextField(20);
//  t14=new JTextField(20);  

  b1=new JButton("New",new ImageIcon("new.gif"));
  b1.addActionListener(this);
  b2=new JButton("Modify",new ImageIcon("paste.gif"));
  b2.addActionListener(this);
  b3=new JButton("Save",new ImageIcon("save.gif"));
  b3.addActionListener(this);
  b4=new JButton("Exit",new ImageIcon("export.gif"));
  b4.addActionListener(this);
  b5=new JButton("Find",new ImageIcon("find.gif"));
  b5.addActionListener(this);
  b6=new JButton("Delete",new ImageIcon("delete.gif"));
  b6.addActionListener(this);
/*  r1=new JRadioButton("Male",false);
  r1.addItemListener(this);
  r2=new JRadioButton("Female",false);
  r2.addItemListener(this);
*/ 
//  Panel p=new Panel();
//  p.setLayout(new GridLayout(7,2,1,1));
  Panel p=new Panel(new GridLayout(8,4));
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
  p.add(c1);
  c1.addItemListener(this);
  p.add(l9);
  p.add(t8);
  p.add(l10);
  p.add(t9);
  p.add(l11);
  p.add(t10);
  p.add(l12);
  p.add(t11);
  p.add(l13);
  p.add(t12);
  p.add(l14);
  p.add(t13);
/*  p.add(r1);
  p.add(r2);*/
  p.setBackground(Color.PINK);
  p.setBounds(100,120,250,100);
  con.add(p);

  add(p);  
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

  limg=new JLabel(" ",new ImageIcon("cd2.gif"),JLabel.RIGHT);
  add(limg);

  add(p2);
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   cn=DriverManager.getConnection("Jdbc:Odbc:bank");
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs=st.executeQuery("select * from loan_opening");
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
   t10.setText(rs.getString(10));
   t11.setText(rs.getString(11));
   t12.setText(rs.getString(12));
   t13.setText(rs.getString(13));
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
    t10.setText(" ");
    t11.setText(" ");
    t12.setText(" ");
    t13.setText(" ");
   }
   if(ae.getSource()==b2)
   {
    try
    {
     pst=cn.prepareStatement("insert into loan_opening values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
     pst.setString(1,t1.getText());
     pst.setString(2,t2.getText());
     pst.setString(3,t3.getText());
     pst.setString(4,t4.getText());
     pst.setString(5,t5.getText());
     pst.setString(6,t6.getText());
     pst.setString(7,t7.getText());
     pst.setString(8,t8.getText());
     pst.setString(9,t9.getText());
     pst.setString(10,t10.getText());
     pst.setString(11,t11.getText());
     pst.setString(12,t12.getText());
     pst.setString(13,t13.getText());
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
    pst=cn.prepareStatement("update loan_opening set customer_name=?,dateofissue=?,rateofint=?,amt=?,maturitydt=?,acno=?,totalinstallment=?,typeofsecurity=?,reasonofloan=? where loan_no=?");
    pst.setString(1,t1.getText());
    pst.setString(2,t2.getText());
    pst.setString(3,t3.getText());
    pst.setString(4,t4.getText());
    pst.setString(5,t5.getText());
    pst.setString(6,t6.getText());
    pst.setString(7,t7.getText());
    pst.setString(8,t8.getText());
    pst.setString(9,t9.getText());
    pst.setString(10,t10.getText());
    pst.setString(11,t11.getText());
    pst.setString(12,t12.getText());
    pst.setString(13,t13.getText());
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
      String cno=JOptionPane.showInputDialog(this,"Enter Loan No.");
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
         t10.setText(rs.getString(10));
         t11.setText(rs.getString(11));
         t12.setText(rs.getString(12));
         t13.setText(rs.getString(13));
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
    pst=cn.prepareStatement("delete from loan_opening where loan_no=?");
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
public void itemStateChanged(ItemEvent ie)
{
 }
 public static void main(String args[])
 {
  loanopening lo=new loanopening();
 }
}