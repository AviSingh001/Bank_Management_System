import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class deposit extends JFrame implements ActionListener{
    String pin;
    JTextField txt;
    JButton b1,b2;
    public deposit(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/atm_machine.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1400,750); 
        add(l3);

        JLabel l1=new JLabel("Enter Amount You Want To Deposit");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(400,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        txt=new JTextField();
        txt.setBounds(400,230,270,25);
        txt.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(txt);

        b1=new JButton("Deposit");
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
        try{
        String amount=txt.getText();
        Date date=new Date();
        if(e.getSource()==b1){
            if(txt.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the Amount You Want to Deposit");
            }else{
                Connect c2=new Connect();
                String q1="insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')";
                c2.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Deposit Successfully");
                setVisible(false);
                new main_Transaction(pin);
            }
        }else if(e.getSource()==b2){
            setVisible(false);
            new main_Transaction(pin);
        }
        }
        catch(Exception ae){
            ae.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new deposit("");
    }
}