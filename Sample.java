import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Sample extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton b1,b2,b3;
    JToggleButton t;
    JPanel p;
    Sample(){
        super("Bank Management System");

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/Source.jpg"));
       Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(350, 10, 100, 100);
       add(image);

       ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("src/icon/T.jpg"));
       Image ii2=ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon ii3=new ImageIcon(ii2);
       JLabel iimage=new JLabel(ii3);
       iimage.setBounds(630, 150, 100, 100);
       add(iimage);

       label1=new JLabel("Welcome to ATM");
       label1.setForeground(Color.WHITE);
       label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
       label1.setBounds(230, 125, 450, 40);
       add(label1);

       label2=new JLabel("Card Number:");
       label2.setForeground(Color.WHITE);
       label2.setFont(new Font("Ralway",Font.BOLD, 28));
       label2.setBounds(150,190,375,30);
       add(label2);

       textField2=new JTextField(15);
       textField2.setBounds(370,190,230,30);
       textField2.setFont(new Font("Arial",Font.BOLD, 14));
       textField2.setForeground(Color.BLACK);
       add(textField2);

       label3=new JLabel("Pin Number:");
       label3.setForeground(Color.WHITE);
       label3.setFont(new Font("Ralway",Font.BOLD, 28));
       label3.setBounds(150,250,375,30);
       add(label3);

       passwordField3=new JPasswordField();
       passwordField3.setForeground(Color.BLACK);
       passwordField3.setFont(new Font("Arial",Font.BOLD, 14));
       passwordField3.setBounds(370,250,230,30);
       add(passwordField3);

       b1=new JButton("Sign In");
       b1.setFont(new Font("Arial",Font.BOLD,14));
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(300, 300, 100, 30);
       b1.addActionListener(this);
       add(b1);

       b2=new JButton("Clear");
       b2.setFont(new Font("Arial",Font.BOLD,14));
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(450, 300, 100, 30);
       b2.addActionListener(this);
       add(b2);

       b3=new JButton("Sign Up");
       b3.setFont(new Font("Arial",Font.BOLD,14));
       b3.setForeground(Color.WHITE);
       b3.setBackground(Color.BLACK);
       b3.setBounds(300, 350, 250, 30);
       b3.addActionListener(this);
       add(b3);
      
       ImageIcon iii1=new ImageIcon("src/icon/morning.jpg");
       Image iii2=iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
       ImageIcon iii3=new ImageIcon(iii2);
       JLabel iiimage=new JLabel(iii3);
       //iiimage.setBounds(0,0,850,480);

       p=new JPanel();
       p.setBounds(0, 0, 850, 480);
       p.add((iiimage));
       add(p);

       t=new JToggleButton("Toggle");
       t.setBounds(580,100,100,40);
       t.setForeground(Color.WHITE);
       t.setBackground(Color.BLACK);
       t.addActionListener(this);
       add(t);

       setLayout(null);
       setLocation(450, 200);
       setSize(850, 480);
      // setUndecorated(true);
       setVisible(true);
     }
     @Override
     public void actionPerformed(ActionEvent e) {
         try{
           if(e.getSource()==b1){
              Connect c4=new Connect();
              String cn=textField2.getText();
              char[] p=passwordField3.getPassword();
              String pin=new String(p);
              String q="select * from login where Card_No='"+cn+"' and PIN='"+pin+"'";
              ResultSet resultSet=c4.statement.executeQuery(q);
              if(resultSet.next()){
                setVisible(false);
                new main_Transaction(pin);
              }else{
                JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
              }

            }else if(e.getSource()==b2){
            textField2.setText("");
            passwordField3.setText("");

           }else if(e.getSource()==b3){
            new Signup();
            setVisible(false);
           }
           if(t.isSelected()){
            p.removeAll();
            ImageIcon iii1=new ImageIcon("src/icon/night.jpg");
            Image dark=iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
            ImageIcon iii3=new ImageIcon(dark);
            JLabel iiimage=new JLabel(iii3);
            p.add((iiimage));
            revalidate();
            repaint();
        }else{
            p.removeAll();
            ImageIcon iii1=new ImageIcon("src/icon/morning.jpg");
            Image light=iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
            ImageIcon iii3=new ImageIcon(light);
            JLabel iiimage=new JLabel(iii3);
            p.add((iiimage));
            revalidate();
            repaint();
        }
         }catch(Exception E){
          E.printStackTrace();
         }
    }
    public static void main(String[] args) {
        new Sample();
    }
}
