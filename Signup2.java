import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Signup2 extends JFrame implements ActionListener{
    String formno;
    JComboBox cb1,cb2,cb3,cb4,cb5;
    JTextField txtPan,txtAadhar;
    JRadioButton r1,r2,r3,r4;
    JButton next;
    Signup2(String formno){
        super("APPLICATION FORM");
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/logo.jpeg"));
     Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(25, 10, 100, 100);
     add(image);

     this.formno=formno;

     JLabel l1=new JLabel("Page 2");
     l1.setFont(new Font("Raleway",Font.BOLD,22));
     l1.setBounds(300,30,600,40);
     add(l1);

     JLabel l2=new JLabel("Additional Details");
     l2.setFont(new Font("Raleway",Font.BOLD,22));
     l2.setBounds(300,60,600,40);
     add(l2);

     JLabel l3=new JLabel("Religion");
     l3.setFont(new Font("Raleway",Font.BOLD,18));
     l3.setBounds(100,120,100,30);
     add(l3);

     String religion[]={"Hindu","Muslim","Sikh","Christian","Other"};
     cb1=new JComboBox<>(religion);
     cb1.setBackground(new Color(252,208,76));
     cb1.setFont(new Font("Raleway",Font.BOLD,14));
     cb1.setBounds(350, 120, 320, 30);
     add(cb1);
     
     JLabel l4=new JLabel("Category : ");
     l4.setFont(new Font("Raleway",Font.BOLD,18));
     l4.setBounds(100,170,100,30);
     add(l4);

     String category[]={"General","OBC","SC","ST","Other"};
     cb2=new JComboBox<>(category);
     cb2.setBackground(new Color(252,208,76));
     cb2.setFont(new Font("Raleway",Font.BOLD,14));
     cb2.setBounds(350, 170, 320, 30);
     add(cb2);

     JLabel l5=new JLabel("Income : ");
     l5.setFont(new Font("Raleway",Font.BOLD,18));
     l5.setBounds(100,220,100,30);
     add(l5);

     String income[]={"Null","<1,50,000","<2,50,000","<5,00,000","<10,00,000",">10,00,000"};
     cb3=new JComboBox<>(income);
     cb3.setBackground(new Color(252,208,76));
     cb3.setFont(new Font("Raleway",Font.BOLD,14));
     cb3.setBounds(350, 220, 320, 30);
     add(cb3);

     JLabel l6=new JLabel("Educational : ");
     l6.setFont(new Font("Raleway",Font.BOLD,18));
     l6.setBounds(100,270,140,30);
     add(l6);

     String educational[]={"Non-Graduate","Graduate","Post Graduate","Doctrate","Other"};
     cb4=new JComboBox<>(educational);
     cb4.setBackground(new Color(252,208,76));
     cb4.setFont(new Font("Raleway",Font.BOLD,14));
     cb4.setBounds(350, 270, 320, 30);
     add(cb4);

     JLabel l7=new JLabel("Occupation : ");
     l7.setFont(new Font("Raleway",Font.BOLD,18));
     l7.setBounds(100,320,160,30);
     add(l7);

     String occupation[]={"Salaried","Self-Employed","Business","Student","Retired","Other"};
     cb5=new JComboBox<>(occupation);
     cb5.setBackground(new Color(252,208,76));
     cb5.setFont(new Font("Raleway",Font.BOLD,14));
     cb5.setBounds(350, 320, 320, 30);
     add(cb5);

     JLabel l8=new JLabel("PAN Number : ");
     l8.setFont(new Font("Raleway",Font.BOLD,18));
     l8.setBounds(100,370,190,30);
     add(l8);

     txtPan =new JTextField();
     txtPan.setFont(new Font("Raleway",Font.BOLD,18));
     txtPan.setBounds(350,370,320,30);
     add(txtPan);
 
     JLabel l9=new JLabel("Aadhaar Number : ");
     l9.setFont(new Font("Raleway",Font.BOLD,18));
     l9.setBounds(100,420,190,30);
     add(l9);

     txtAadhar =new JTextField();
     txtAadhar.setFont(new Font("Raleway",Font.BOLD,18));
     txtAadhar.setBounds(350,420,320,30);
     add(txtAadhar);

     JLabel l10=new JLabel("Senior Citizen : ");
     l10.setFont(new Font("Raleway",Font.BOLD,18));
     l10.setBounds(100,470,190,30);
     add(l10);

     r1=new JRadioButton("Yes");
     r1.setFont(new Font("Raleway",Font.BOLD,14));
     r1.setBounds(350,470,100,30);
     r1.setBackground(new Color(252,208,76));
     add(r1);

     r2=new JRadioButton("No");
     r2.setFont(new Font("Raleway",Font.BOLD,14));
     r2.setBounds(470,470,50,30);
     r2.setBackground(new Color(252,208,76));
     add(r2);

     JLabel l11=new JLabel("Existing Account : ");
     l11.setFont(new Font("Raleway",Font.BOLD,18));
     l11.setBounds(100,520,190,30);
     add(l11);

     r3=new JRadioButton("Yes");
     r3.setFont(new Font("Raleway",Font.BOLD,14));
     r3.setBounds(350,520,100,30);
     r3.setBackground(new Color(252,208,76));
     add(r3);

     r4=new JRadioButton("No");
     r4.setFont(new Font("Raleway",Font.BOLD,14));
     r4.setBounds(470,520,50,30);
     r4.setBackground(new Color(252,208,76));
     add(r4);

     JLabel l12=new JLabel("Form No : ");
     l12.setFont(new Font("Raleway",Font.BOLD,18));
     l12.setBounds(620,10,100,30);
     add(l12);

     JLabel l13=new JLabel(formno);
     l13.setFont(new Font("Raleway",Font.BOLD,18));
     l13.setBounds(730,10,60,30);
     add(l13);

     next=new JButton("Next");
     next.setFont(new Font("Raleway",Font.BOLD,14));
     next.setBackground(Color.WHITE);
     next.setBounds(570,600,100,30);
     next.addActionListener(this);
     add(next);
     
     setLayout(null);
     setSize(850,750);
     setLocation(350,80);
     getContentPane().setBackground(new Color(252,208,76));
     setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel=(String)cb1.getSelectedItem();
        String cate=(String)cb2.getSelectedItem();
        String inc=(String)cb3.getSelectedItem();
        String edu=(String)cb4.getSelectedItem();
        String occ=(String)cb5.getSelectedItem();
        String pan=txtPan.getText();
        String aadhar=txtAadhar.getText();

        String scitizen=null;
        if(r1.isSelected()){
            scitizen="Yes";
        }else if(r2.isSelected()){
            scitizen="No";
        }

        String eaccount=null;
        if(r1.isSelected()){
            eaccount="Yes";
        }else if(r2.isSelected()){
            eaccount="No";
        }
try{
            if(txtPan.getText().equals("")||txtAadhar.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the Fields");
            }else{
        Connect c1=new Connect();
        String q1="insert into Signuptwo values('"+formno+"','"+rel+"','"+cate+"','"+inc+"','"+edu+"','"+occ+"', '"+pan+"','"+aadhar+"', '"+scitizen+"','"+eaccount+"')";
        c1.statement.executeUpdate(q1);
        new Signup3(formno);
        setVisible(false);   
    } }catch(Exception a){
            a.printStackTrace();
        }
 }
    public static void main(String[] args) {
        new Signup2("");
    }
}
