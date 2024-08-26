import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class login extends JFrame implements ActionListener{
   JLabel label1,label2,label3;
   JTextField textField2;
   JPasswordField passwordField3;
   JButton b1,b2,b3;
     login(){
       super("Bank Management System");

       label2=new JLabel("Card Number:");
       label2.setForeground(Color.WHITE);
       label2.setFont(new Font("Ralway",Font.BOLD, 16));
       label2.setBounds(480,190,350,30);
       add(label2);

       textField2=new JTextField(15);
       textField2.setBounds(600,190,230,30);
       textField2.setFont(new Font("Arial",Font.BOLD, 14));
       textField2.setForeground(Color.BLACK);
       add(textField2);

       label3=new JLabel("Pin :");
       label3.setForeground(Color.WHITE);
       label3.setFont(new Font("Ralway",Font.BOLD, 16));
       label3.setBounds(480,250,350,30);
       add(label3);

       passwordField3=new JPasswordField();
       passwordField3.setForeground(Color.BLACK);
       passwordField3.setFont(new Font("Arial",Font.BOLD, 14));
       passwordField3.setBounds(600,250,230,30);
       add(passwordField3);

       b1=new JButton("Sign In");
       b1.setFont(new Font("Arial",Font.BOLD,14));
       b1.setForeground(Color.WHITE);
       b1.setBackground(Color.BLACK);
       b1.setBounds(500, 320, 100, 30);
       b1.addActionListener(this);
       add(b1);

       b2=new JButton("Clear");
       b2.setFont(new Font("Arial",Font.BOLD,14));
       b2.setForeground(Color.WHITE);
       b2.setBackground(Color.BLACK);
       b2.setBounds(700, 320, 100, 30);
       b2.addActionListener(this);
       add(b2);

       b3=new JButton("Sign Up");
       b3.setFont(new Font("Arial",Font.BOLD,14));
       b3.setForeground(Color.WHITE);
       b3.setBackground(Color.BLACK);
       b3.setBounds(550, 370, 200, 30);
       b3.addActionListener(this);
       add(b3);
      
       ImageIcon iii1=new ImageIcon(ClassLoader.getSystemResource("src/icon/7.png"));
       Image iii2=iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
       ImageIcon iii3=new ImageIcon(iii2);
       JLabel iiimage=new JLabel(iii3);
       iiimage.setBounds(0,0,850,480);
       add(iiimage);

       setLayout(null);
       setLocation(450, 200);
       setSize(850, 480);
       //setUndecorated(true);
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
         }catch(Exception E){
          E.printStackTrace();
         }
        }
        public static void main(String[] args) {
            new login();
    
        }
      }
      
