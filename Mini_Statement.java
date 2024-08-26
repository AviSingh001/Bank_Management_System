import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Mini_Statement extends JFrame implements ActionListener{
    String pin;
    JButton button;
    Mini_Statement(String pin){
        this.pin=pin;
    setSize(400,600);
    setLocation(20,20);
    getContentPane().setBackground(new Color(255,204,204));
    setLayout(null);
    
    JLabel l1=new JLabel();
    l1.setBounds(20,120,400,250);
    add(l1);

    JLabel l2=new JLabel("Empyrean Vault");
    l2.setFont(new Font("System",Font.BOLD,15));
    l2.setBounds(150,20,200,20);
    add(l2);

    JLabel l3=new JLabel();
    l3.setBounds(20,80,300,20);
    add(l3);

    JLabel l4=new JLabel();
    l4.setBounds(20,450,300,20);
    add(l4);

    try{
        Connect c=new Connect();
        ResultSet resultSet=c.statement.executeQuery("Select * from login where PIN='"+pin+"'");
        while (resultSet.next()) {
            l3.setText("Card Number: "+resultSet.getString("Card_No").substring(0,4)+"XXXXXXXX"+resultSet.getString("Card_No").substring(12));  
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    try{
        Connect c=new Connect();
        ResultSet resultSet=c.statement.executeQuery("select * from bank where PIN='"+pin+"'");
        int balance=0;
        while(resultSet.next()){
            l1.setText(l1.getText()+"<html>"+resultSet.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");
            
            if(resultSet.getString("Type").equals("Deposit")){
                balance +=Integer.parseInt(resultSet.getString("amount"));
            }else{
                balance -=Integer.parseInt(resultSet.getString("amount"));
            }
        }
        l4.setText("Your Total Balance is Rs."+balance);

    }catch(Exception e){
        e.printStackTrace();
    }
    button=new JButton("Exit");
    button.setBounds(20,500,100,25);
    button.addActionListener(this);
    button.setBackground(Color.BLACK);
    button.setForeground(Color.WHITE);
    add(button);

    setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }
    public static void main(String[] args) {
        new Mini_Statement("");
    }
}