import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class accountmaster extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4,l5,bp,lmsg;
  JLabel limg;
 JTextField t1,t2,t3,t4,t5;
 JButton b1,b2,b3,b4,b5,b6;
 PreparedStatement pst=null;
 ResultSet rs=null;
 Connection cn=null;
 Statement st=null;
     boolean adding=false;

 public accountmaster()
 {
   Container con=getContentPane();
   con.setLayout(null);
  
  //jf=new JFrame("Account Master");
  setLayout(new FlowLayout());
  setTitle("ACCOUNT MASTER FORM");
  setSize(500,500);
  setVisible(true);
//  setBackground(Color.PINK);
   bp=new JLabel("ACCOUNT MASTER",new ImageIcon("Money1.gif"),JLabel.CENTER);
   add(bp);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  l1=new JLabel("Account Number :");
  l2=new JLabel("Customer Name :");
  l3=new JLabel("Date of Open :");
  l4=new JLabel("Current Balance :");
  l5=new JLabel("Account Type :");
  //l6=new JLabel("Status :");
  lmsg=new JLabel(" ");

  t1=new JTextField(20);
  t2=new JTextField(20);  
  t3=new JTextField(20);
  t4=new JTextField(20);
  t5=new JTextField(20);
  //t6=new JTextField(20);

  b1=new JButton("New",new ImageIcon("new.gif"));
  b1.addActionListener(this);
  b2=new JButton("Save",new ImageIcon("save.gif"));
  b2.addActionListener(this);
  b3=new JButton("Modify",new ImageIcon("paste.gif"));
  b3.addActionListener(this);
  b4=new JButton("Exit",new ImageIcon("export.gif"));
  b4.addActionListener(this);
  b5=new JButton("Next",new ImageIcon("refresh.gif"));
  b5.addActionListener(this);
  b6=new JButton("Previous",new ImageIcon("refresh.gif"));
  b6.addActionListener(this);
  
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
  p.add(l5);
  p.add(t5);
  //p.add(l6);
  //p.add(t6);
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
  limg=new JLabel(" ",new ImageIcon("leaf.gif"),JLabel.RIGHT);
  add(limg);
  try
  {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   cn=DriverManager.getConnection("Jdbc:Odbc:bank");
   JOptionPane.showMessageDialog(this,"Connected Successfully");      st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs=st.executeQuery("select * from account_master");
   rs.next();
  }
  catch(Exception e)
  {
   System.out.println(" "+e);
  }
 }
/*         addWindowListener(
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
 }*/
 public void getData()
 {
  try
  {
   t1.setText(rs.getString(1));
   t2.setText(rs.getString(2));
   t3.setText(rs.getString(3));
   t4.setText(rs.getString(4));
   t5.setText(rs.getString(5));
   //t6.setText(rs.getString(6));
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
   if(ae.getSource()==b1)    //new button logic
   {
    t1.setText(" ");
    t2.setText(" ");
    t3.setText(" ");
    t4.setText(" ");
    t5.setText(" ");
    //t6.setText(" ");
	t1.requestFocus();
	adding=true;

   }
   if(ae.getSource()==b2)   //save button logic
   {
    try
    {
     pst=cn.prepareStatement("insert into account_master values(?,?,?,?,?)");
     pst.setString(1,t1.getText());
     pst.setString(2,t2.getText());
     pst.setString(3,t3.getText());
     pst.setString(4,t4.getText());
     pst.setString(5,t5.getText());
     //pst.setString(6,t6.getText());
     pst.executeUpdate();
     JOptionPane.showMessageDialog(this,"Details have been added");
    }
    catch(Exception e2)
    {
     JOptionPane.showMessageDialog(this,"add is+"+e2);     
    }
   }
   if(ae.getSource()==b3)  //update button logic
   {
      
   pst=cn.prepareStatement("update account_master set         cname=?,dateofopen=?,curbal=?,actype=? where acno=?");
    pst.setString(1,t2.getText());
    pst.setString(2,t3.getText());
    pst.setString(3,t4.getText());
    pst.setString(4,t5.getText());
    pst.setString(5,t1.getText());
    //pst.setString(6,t1.getText());
    pst.executeUpdate();
    JOptionPane.showMessageDialog(this,"Record Updated");

   }
   if(ae.getSource()==b4)   //exit button logic
   {
    //System.exit(0);
    frame f=new frame();
    this.hide();                                                                         
    f.show();                          
   }
   if(ae.getSource()==b5)   //next button logic
   {
    rs.next();
    if(!rs.isAfterLast())
    getData();
   }
   if(ae.getSource()==b6)   //previous button logic
   {
    rs.previous();
    if(!rs.isBeforeFirst());
//	rs.first();
//	showRec();
    getData();
   } 
  }
  catch(Exception e)
  {
   JOptionPane.showMessageDialog(this,"error is="+e);   
  }
 }
 public static void main(String args[])
 {
  accountmaster am=new accountmaster();
 }
    void showRec() 
    {
        try
       {              
             t1.setText(rs.getString(1));
             t2.setText(rs.getString(2));
             t3.setText(rs.getString(3));
             t4.setText(rs.getString(4));
//             t5.setText(rs.getString(5));
             
       }
      catch(SQLException ex)
      {
           JOptionPane.showMessageDialog(this,"Error is"+ex);
      }
   }

}















/*                 if(adding)
                 {
	      rs.moveToInsertRow();
	      rs.updateInt(1,Integer.parseInt(t1.getText()));
 	      rs.updateString(2,t2.getText());
 	      rs.updateString(3,t3.getText());
 	      rs.updateInt(4,Integer.parseInt(t4.getText()));
 	      rs.updateString(5,t5.getText());

	      rs.insertRow();
 	      JOptionPane.showMessageDialog(this,"Record is added");
	 } 
  }*/

   /*        rs.updateInt(1,Integer.parseInt(t1.getText()));
 	 rs.updateString(2,t2.getText());
 	 rs.updateString(3,t3.getText());
 	 rs.updateString(4,t4.getText());
 	 rs.updateString(5,t5.getText());
 	
                 rs.updateRow();
	JOptionPane.showMessageDialog(this,"Record is Updated");
*/