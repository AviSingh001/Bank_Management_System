import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class withdrawal extends JFrame implements ActionListener{
    String pin;
    JTextField txt;
    JButton b1,b2;
    withdrawal(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/atm_machine.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1400,750); 
        add(l3);

        JLabel l1=new JLabel("Maximum Withdrawal is RS 10,000");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(400,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        JLabel l0=new JLabel("Please Enter Your Amount");
        l0.setFont(new Font("System",Font.BOLD,16));
        l0.setBounds(400,220,400,35);
        l0.setForeground(Color.WHITE);
        l3.add(l0);

        txt=new JTextField();
        txt.setBounds(400,260,200,25);
        txt.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(txt);

        b1=new JButton("Withdrawal");
        b1.setBounds(650,370,150,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("Back");
        b2.setBounds(650,405,150,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1400,800);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
        try{
            String amount=txt.getText();
            Date date=new Date();
            if(txt.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the Amount You Want to Withdrawal");
            }else{
                Connect con=new Connect();
                ResultSet resultSet=con.statement.executeQuery("select * from bank where PIN='"+pin+"'");
                int balance=0;
                while(resultSet.next()){
                    if(resultSet.getString("Type").equals("Deposit")){
                        balance +=Integer.parseInt(resultSet.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if(balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                con.statement.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                    setVisible(false);
                    new main_Transaction(pin);

            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }else if(e.getSource()==b2){
        setVisible(false);
        new main_Transaction(pin);
    }
    }
    public static void main(String[] args) {
        new withdrawal("");
    }
}
