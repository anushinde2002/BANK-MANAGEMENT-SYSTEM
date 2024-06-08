import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{

   JLabel l1,l2;    
   JTextField t1;
   JPasswordField t2;
   JButton Login,Exit;  
   Connection cn=null;
   Statement st=null;

 public Login()
   {

     Container con=getContentPane();
     con.setLayout(null);

    setVisible(true);
    setSize(700,700);
    setTitle("Login");
    setLayout(new FlowLayout());
    


    l1=new JLabel("UserName",new ImageIcon("hi.gif"),JLabel.CENTER);
    l2=new JLabel("Password",new ImageIcon("pa.gif"),JLabel.CENTER);
 
    t1=new JTextField(30);
    t2=new JPasswordField(30);

    Login=new JButton("Login",new ImageIcon("Login.gif"));
    Exit=new JButton("Exit",new ImageIcon("Exit1.gif"));


   Login.addActionListener(this);
    Exit.addActionListener(this);
 
 
 JLabel L=new JLabel(".",new ImageIcon("l2.gif"),JLabel.LEFT);


    JPanel p1=new JPanel();
    p1.setLayout(new GridLayout(20,30,50,50));
    p1.setBackground(new Color(172,186,221));
   con.setBackground(new Color(172,186,221));
    con.add(p1);

    p1.add(l1);   p1.add(t1);
    p1.add(l2);   p1.add(t2);
     p1.add(Login); p1.add(Exit);
p1.add(L);
    
  try
  {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   cn=DriverManager.getConnection("jdbc:odbc:bank");
  st=cn.createStatement();
  }
  catch(Exception  ex)
  {
    JOptionPane.showMessageDialog(this,"Error is "+ex);
  }
 }
 public void actionPerformed(ActionEvent ae)
 {
  try
  {
    if(ae.getSource()==Login)
   {
     String s1=t1.getText();
     String s2=t2.getText();
     ResultSet rs=st.executeQuery("select * from login where uname='"+s1+"'");
     if(rs.next())
     {
      if(rs.getString(2).equals(s2))                                              //to show another frame
      {                                                                                           
        JOptionPane.showMessageDialog(this,"Welcome to State bank of India");      
        frame f=new frame();
        f.show();
        this.hide();
      }
     else
       JOptionPane.showMessageDialog(this,"Invalid Password");
    }
   else
    JOptionPane.showMessageDialog(this,"Invalid UserName");
    rs.close();
   }
   else
   if(ae.getSource()==Exit)
   {
     cn.close();
     dispose();
   }
  }
  catch(Exception  ex)
  {
    JOptionPane.showMessageDialog(this,"Error is "+ex);
  }

 }
 public static void main(String args[])
 { 
   new Login();
   
 }
}