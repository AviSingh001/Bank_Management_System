import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Toogle_Example extends JFrame implements ActionListener{
   JToggleButton t;
    JPanel p;
    Toogle_Example(){

        JLabel l=new JLabel("Hello");
        l.setBounds(50,50,100,100);
        l.setFont(new Font("System",Font.BOLD,22));
        l.setForeground(Color.BLACK);
        add(l);

        t=new JToggleButton("Toggle");
        ImageIcon i2=new ImageIcon("src/icon/t-day.jpg");
        Image image=i2.getImage().getScaledInstance(100,30 , Image.SCALE_DEFAULT);
        t.setFont(new Font("Arial",Font.BOLD,14));
        t.setIcon(new ImageIcon(image));

        ImageIcon i3=new ImageIcon("src/icon/t-night.jpg");
        Image image1=i3.getImage().getScaledInstance(100,30 , Image.SCALE_DEFAULT);
        t.setSelectedIcon(new ImageIcon(image1));

        // t.setFocusPainted(false);
        // t.setBorderPainted(false);
        // t.setBackground(Color.BLACK);
        // t.setForeground(Color.WHITE);
        // t.setOpaque(true);
        // t.setContentAreaFilled(true);
        t.setBounds(100, 100, 100, 30);
        t.addActionListener(this);
        add(t);
 
        ImageIcon i=new ImageIcon("src/icon/morning.jpg");
        Image light=i.getImage().getScaledInstance(200, 300,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(light);
        JLabel l1=new JLabel(i1);
        p=new JPanel();
       // p.setBackground(Color.LIGHT_GRAY);
        p.add((l1));
        p.setBounds(0, 0, 200, 300);
        add(p);

        setSize(200, 300);
        setLayout(null);
        setLocation(60, 100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       try{ 
        if(t.isSelected()){
            p.removeAll();
          //  p.setBackground(Color.DARK_GRAY);
            ImageIcon i=new ImageIcon("src/icon/night.jpg");
            Image dark=i.getImage().getScaledInstance(200, 300,Image.SCALE_DEFAULT);
            ImageIcon i1=new ImageIcon(dark);
            JLabel l1=new JLabel(i1);
            p.add((l1));
            revalidate();
            repaint();
            //JOptionPane.showMessageDialog(null,"hELLO");
        }else{
          //  p.setBackground(Color.LIGHT_GRAY);
            p.removeAll();
            ImageIcon i=new ImageIcon("src/icon/morning.jpg");
            Image light=i.getImage().getScaledInstance(200, 300,Image.SCALE_DEFAULT);
            ImageIcon i1=new ImageIcon(light);
            JLabel l1=new JLabel(i1);
            p.add((l1));
            revalidate();
           repaint();
        }
    }catch(Exception a){
        a.printStackTrace();
    }
}
    public static void main(String[] args) {

        new Toogle_Example();
        
    }
}