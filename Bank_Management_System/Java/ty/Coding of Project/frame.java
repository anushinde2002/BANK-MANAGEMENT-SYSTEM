import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet.*;
import javax.swing.*;

class frame extends Frame implements ActionListener
{
 Menu menu1,menu2,menu3,menu4;
 MenuBar menubar1/*,menubar2,menubar3,menubar4*/;
 MenuItem menuitem1,menuitem2,menuitem3,menuitem4;
 MenuItem menuitem11,menuitem22,menuitem33; 
 MenuItem menuitem44,menuitem55,menuitem66/*,menuitem111*/;
 MenuItem menuitem222,menuitem1111;/*,menuitem2222,menuitem3333;
 MenuItem menuitem4444,menuitem5555,menuitem6666,menuitem7777;*/

 JLabel l1,l2,l3;
 Label label;
// frame(String title)
 frame()
 {
  //super(title);
 setVisible(true);
 setSize(1000,1000);
 setLayout(new FlowLayout());
 setTitle("State Bank Of India...");
 setBackground(new Color(205,84,154));
  label=new Label();
  Font f1=new Font("Algerian",Font.BOLD,400);



//  setForeground(Color.ORANGE);   
  setLayout(new GridLayout(4,4));
  add(label);
  menubar1=new MenuBar();
//  menubar2=new MenuBar();
//  menubar3=new MenuBar();
//  menubar4=new MenuBar();
  menu1=new Menu("Master");
  menu2=new Menu("Transaction");
  menu3=new Menu("Find");
  menu4=new Menu("Report");

  menuitem1=new MenuItem("a/c master");
  menu1.add(menuitem1);
  menuitem1.addActionListener(this);

  menuitem2=new MenuItem("chequebook master");
  menu1.add(menuitem2);
  menuitem2.addActionListener(this);

  menuitem3=new MenuItem("customer master");
  menu1.add(menuitem3);
  menuitem3.addActionListener(this);

  menuitem4=new MenuItem("Exit");
  menu1.add(menuitem4);
  menuitem4.addActionListener(this);

  menubar1.add(menu1);
  setMenuBar(menubar1);

  menuitem11=new MenuItem("Account Opening");
  menu2.add(menuitem11);
  menuitem11.addActionListener(this);

  menuitem22=new MenuItem("Deposit");
  menu2.add(menuitem22);
  menuitem22.addActionListener(this);

  menuitem33=new MenuItem("Withdrawal");
  menu2.add(menuitem33);
  menuitem33.addActionListener(this);

  menuitem44=new MenuItem("Chequebook");
  menu2.add(menuitem44);
  menuitem44.addActionListener(this);

  menuitem55=new MenuItem("Loan a/c Opening");
  menu2.add(menuitem55);
  menuitem55.addActionListener(this);

  menuitem66=new MenuItem("a/c closing");
  menu2.add(menuitem66);
  menuitem66.addActionListener(this);

  menubar1.add(menu2);
  setMenuBar(menubar1);

/*  menuitem111=new MenuItem("Top Depositer");
  menu3.add(menuitem111);
  menuitem111.addActionListener(this);*/

  menuitem222=new MenuItem("Account search");
  menu3.add(menuitem222);
  menuitem222.addActionListener(this);

  menubar1.add(menu3);
  setMenuBar(menubar1);

  menuitem1111=new MenuItem("Show Reports");
  menu4.add(menuitem1111);
  menuitem1111.addActionListener(this);

/*  menuitem2222=new MenuItem("Withdrawal");
  menu4.add(menuitem2222);
  menuitem2222.addActionListener(this);

  menuitem3333=new MenuItem("Deposit");
  menu4.add(menuitem3333);
  menuitem3333.addActionListener(this);

  menuitem4444=new MenuItem("Loan");
  menu4.add(menuitem4444);
  menuitem4444.addActionListener(this);

  menuitem5555=new MenuItem("Installment");
  menu4.add(menuitem5555);
  menuitem5555.addActionListener(this);

  menuitem6666=new MenuItem("Customer list");
  menu4.add(menuitem6666);
  menuitem6666.addActionListener(this);

  menuitem7777=new MenuItem("a/c closing");
  menu4.add(menuitem7777);
  menuitem7777.addActionListener(this);
*/
  menubar1.add(menu4);
  setMenuBar(menubar1);

  l1=new JLabel(" ",new ImageIcon("w.gif"),JLabel.CENTER);
  l2=new JLabel(" ",new ImageIcon("w1.gif"),JLabel.CENTER);
  l3=new JLabel(" ",new ImageIcon("Ex.gif"),JLabel.LEFT);
 add(l1);
 add(l1);
 add(l2);
 add(l3);

  addWindowListener(new WindowAdapter()
  {
   public void windowClosing(WindowEvent e)
   {
    setVisible(false);
   }
  }
 );
 }
 public void actionPerformed(ActionEvent event)
 {
  if(event.getSource()==menuitem1)
  {
   accountmaster a=new accountmaster();                  //linking to the frame of account master form
   this.hide();                                                                         //to hide current frame
   a.show();                                                                           //to show frame of account master
   label.setText("You choose item 1");
  }
  else if(event.getSource()==menuitem2)
  {
   chequebookmaster cbm=new chequebookmaster();
   this.hide();
   cbm.show();
   label.setText("You choose item 2");
  }
  else if(event.getSource()==menuitem3)
  {
   customermaster cm=new customermaster();
   this.hide();
   cm.show();
   label.setText("You choose item 3");
  }
  else if(event.getSource()==menuitem4)
  {
   System.exit(0);
   label.setText("You choose item 4");
  }
  else if(event.getSource()==menuitem11)
  {
   accountopening ao=new accountopening();
   this.hide();
   ao.show();
   label.setText("You choose item 11");
  }
  else if(event.getSource()==menuitem22)
  {
   savingdeposit sd=new savingdeposit();
   this.hide();
   sd.show();
   label.setText("You choose item 22");
  }
  else if(event.getSource()==menuitem33)
  {
   withdrawal wi=new withdrawal();
   this.hide();
   wi.show();
   label.setText("You choose item 33");
  }
  else if(event.getSource()==menuitem44)
  {
   chequebook cb=new chequebook();
   this.hide();
   cb.show();
   label.setText("You choose item 44");
  }
  else if(event.getSource()==menuitem55)
  {
   loanopening lo=new loanopening();
   this.hide();
   lo.show();
   label.setText("You choose item 55");
  }
/*  else if(event.getSource()==menuitem66)
  {
   a/c closing ac=new a/c closing();
   this.hide();
   ac.show();
   label.setText("You choose item 66");
  }*/
  else if(event.getSource()==menuitem222)
  {
   accountsearch as=new accountsearch();
   this.hide();
   as.show();
   label.setText("You choose item 222");
  }
  else if(event.getSource()==menuitem1111)
  {
   reports rs=new reports();
   this.hide();
   rs.show();
   label.setText("You choose item 222");
  }

 }
/*public void paint(Graphics g)
{
g.setFont(new Font("Algerian",Font.BOLD,50));
g.drawString("State Bank of India, Ahnednagar.",70,400);
 g.setColor(Color.yellow);

}*/
public static void main(String args[])
{
 frame f=new frame();
}
}

























/*
  ImageIcon img=new ImageIcon("w.gif");
 JLabel limg=new JLabel(img);*/