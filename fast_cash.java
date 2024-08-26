import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class fast_cash extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    fast_cash(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/atm_machine.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1400,750); 
        add(l3);

        JLabel l1=new JLabel("Please Select Withdrawal Amount");
        l1.setFont(new Font("System",Font.BOLD,22));
        l1.setBounds(370,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        b1=new JButton("Rs.100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(244,292,150,30);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("Rs.500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(655,292,150,30);
        b2.addActionListener(this);
        l3.add(b2);

        b3=new JButton("Rs.1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(244,330,150,30);
        b3.addActionListener(this);
        l3.add(b3);

        b4=new JButton("Rs.2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setBounds(655,330,150,30);
        b4.addActionListener(this);
        l3.add(b4);

        b5=new JButton("Rs.5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        b5.setBounds(244,368,150,30);
        b5.addActionListener(this);
        l3.add(b5);

        b6=new JButton("Rs.10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.BLACK);
        b6.setBounds(655,368,150,30);
        b6.addActionListener(this);
        l3.add(b6);

        b7=new JButton("Back");
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.BLACK);
        b7.setBounds(655,406,150,30);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1400,800);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b7){
            new main_Transaction(pin);
            setVisible(false);
        }else{
            String amount=((JButton)e.getSource()).getText().substring(3);
            Connect c=new Connect();
            Date date=new Date();
            try{
                ResultSet resultSet=c.statement.executeQuery("select * from bank where PIN='"+pin+"'");
                int balance=0;
                while(resultSet.next()){
                    if(resultSet.getString("Type").equals("Deposit")){
                        balance +=Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance -=Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if(e.getSource()!=b7&& balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

              c.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
           }catch(Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new main_Transaction(pin);
        }


    }
    public static void main(String[] args) {
        new fast_cash("");
    }
}