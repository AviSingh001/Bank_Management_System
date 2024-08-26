import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Transaction extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    main_Transaction(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/atm_machine.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1400,750); 
        add(l3);

        JLabel l1=new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System",Font.BOLD,22));
        l1.setBounds(370,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        b1=new JButton("Deposit");
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(244,292,150,30);
        b1.addActionListener(this);
        l3.add(b1);

        b2=new JButton("Cash Withdrawal");
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(655,292,150,30);
        b2.addActionListener(this);
        l3.add(b2);

        b3=new JButton("Fast Cash");
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(244,330,150,30);
        b3.addActionListener(this);
        l3.add(b3);

        b4=new JButton("Mini Statement");
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setBounds(655,330,150,30);
        b4.addActionListener(this);
        l3.add(b4);

        b5=new JButton("PIN Change");
        b5.setForeground(Color.WHITE);
        b5.setBackground(Color.BLACK);
        b5.setBounds(244,368,150,30);
        b5.addActionListener(this);
        l3.add(b5);

        b6=new JButton("Balance Enquiry");
        b6.setForeground(Color.WHITE);
        b6.setBackground(Color.BLACK);
        b6.setBounds(655,368,150,30);
        b6.addActionListener(this);
        l3.add(b6);

        b7=new JButton("Exit");
        b7.setForeground(Color.WHITE);
        b7.setBackground(Color.BLACK);
        b7.setBounds(655,406,150,30);
        b7.addActionListener(this);
        l3.add(b7);

        // b4=new JButton("Mini Statement");
        // b4.setForeground(Color.WHITE);
        // b4.setBackground(Color.BLACK);
        // b4.setBounds(655,330,150,30);
        // //b1.addActionListener(this);
        // l3.add(b4);


        setLayout(null);
        setSize(1400,800);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
           new deposit(pin);
           setVisible(false);
        }else if(e.getSource()==b2){
            new withdrawal(pin);
            setVisible(false);
        }else if(e.getSource()==b7){
            System.exit(0);
        }else if(e.getSource()==b6){
            new balance_Enquiry(pin);
            setVisible(false);
        }else if(e.getSource()==b3){
            new fast_cash(pin);
            setVisible(false);
        }else if(e.getSource()==b5){
            new Pin_Change(pin);
            setVisible(false);
        }else if(e.getSource()==b4){
            new Mini_Statement(pin);
          //  setVisible(false);
        }
    }

    
    public static void main(String[] args) {
        new main_Transaction("");
    }
}
