import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class cheque extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4,bp,lmsg;  
 JTextField t1,t2,t3,t4;
 JButton b1,b2;
 PreparedStatement pst=null;
 ResultSet rs=null;
 Connection cn=null;
 Statement st=null;
 public cheque()
 {
   Container con=getContentPane();
   con.setLayout(null);

  setLayout(new FlowLayout());
  setTitle("CHEQUE");
  setSize(500,500);
  setVisible(true);
   bp=new JLabel("CHEQUE DEPOSIT",new ImageIcon("Money1.gif"),JLabel.CENTER);
   add(bp);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  l1=new JLabel("Account Number :");
  l2=new JLabel("Pay :");
  l3=new JLabel("Cheque No :");
  l4=new JLabel("Amount of Deposit :");
  lmsg=new JLabel(" ");

  t1=new JTextField(20);
  t2=new JTextField(20);  
  t3=new JTextField(20);
  t4=new JTextField(20);

  b1=new JButton("Save",new ImageIcon("save.gif"));
  b1.addActionListener(this);
  b2=new JButton("Exit",new ImageIcon("export.gif"));
  b2.addActionListener(this);

  Panel p=new Panel();
  p.setLayout(new GridLayout(7,2,1,1));
                 
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

  Panel p1=new Panel();
  p1.add(b1);
  p1.add(b2);

  p1.add(lmsg);
  this.getContentPane().add(p1,"center");
  p1.setBackground(Color.PINK);
  p1.setBounds(50,220,370,100);
  con.setBackground(Color.PINK);
  con.add(p);

  add(p1);

  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   cn=DriverManager.getConnection("Jdbc:Odbc:bank");
   JOptionPane.showMessageDialog(this,"Connected Successfully");         st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs=st.executeQuery("select * from cheque");
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
   if(ae.getSource()==b1)   //save button logic
   {
    try
    {
     pst=cn.prepareStatement("insert into cheque values(?,?,?,?)");
     pst.setString(1,t1.getText());
     pst.setString(2,t2.getText());
     pst.setString(3,t3.getText());
     pst.setString(4,t4.getText());
     pst.executeUpdate();
     JOptionPane.showMessageDialog(this,"Details have been added");
    }
  
   catch(Exception e2)
    {
     JOptionPane.showMessageDialog(this,"add is+"+e2);     
    }
   }
   if(ae.getSource()==b2)   //exit button logic
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
  cheque ch=new cheque();
 }
}