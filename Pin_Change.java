import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class Pin_Change extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin_Change(String pin){
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/atm_machine.jpg"));
        Image i2=i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(0,0,1400,750); 
        add(l3);

        JLabel l1=new JLabel("Change Your PIN");
        l1.setFont(new Font("System",Font.BOLD,16));
        l1.setBounds(400,180,400,35);
        l1.setForeground(Color.WHITE);
        l3.add(l1);

        JLabel l2=new JLabel("New PIN: ");
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setBounds(400,220,400,35);
        l2.setForeground(Color.WHITE);
        l3.add(l2);

        p1=new JPasswordField();
        p1.setBounds(480,225,200,25);
        p1.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p1);

        JLabel l4=new JLabel("Re-Enter New PIN: ");
        l4.setFont(new Font("System",Font.BOLD,16));
        l4.setBounds(330,260,400,35);
        l4.setForeground(Color.WHITE);
        l3.add(l4);

        p2=new JPasswordField();
        p2.setBounds(480,265,200,25);
        p2.setFont(new Font("Raleway",Font.BOLD,22));
        l3.add(p2);

        b1=new JButton("Change");
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
            String pin1=p1.getText();
            String pin2=p2.getText();

            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not Match");
                return;
            }
            if(e.getSource()==b1){
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                }
                 if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                Connect c=new Connect();
                String q1="update bank set PIN='"+pin1+"' where PIN='"+pin+"'";
                String q2="update login set PIN='"+pin1+"' where PIN='"+pin+"'"; 
                String q3="update signupthree set PIN='"+pin1+"' where PIN='"+pin+"'";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                new main_Transaction(pin);
                setVisible(false);
            }else if(e.getSource()==b2){
                new main_Transaction(pin);
                setVisible(false);
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Pin_Change("");
    }
}
