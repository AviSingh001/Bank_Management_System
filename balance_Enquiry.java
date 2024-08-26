import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balance_Enquiry extends JFrame implements ActionListener{
    String pin;
    JLabel l0;
    JButton b1;
    balance_Enquiry(String pin){
            this.pin=pin;
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/atm_machine.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1400,750); 
        add(l3);

        JLabel l1=new JLabel("Your Current Balance is Rs.");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(400,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        l0=new JLabel();
        l0.setFont(new Font("System",Font.BOLD,16));
        l0.setBounds(400,220,400,35);
        l0.setForeground(Color.WHITE);
        l3.add(l0);

        int balance=0;
        try{
            Connect c=new Connect();
            ResultSet resultSet=c.statement.executeQuery("select * from bank where PIN='"+pin+"'");
            while(resultSet.next()){
                if(resultSet.getString("Type").equals("Deposit")){
                    balance +=Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance-=Integer.parseInt(resultSet.getString("amount"));
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        l0.setText(""+balance);

        b1=new JButton("Back");
        b1.setBounds(650,405,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);
        
        setLayout(null);
        setSize(1400,800);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Transaction(pin);
    }
    public static void main(String[] args) {
        new balance_Enquiry("");
    }
}
