import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Signup extends JFrame implements ActionListener {
    JTextField textName,textfName,textEmail,textAdd,textState,textCity,textPincode;
    JDateChooser dateChooser;
    JRadioButton r1,r2,r3,m1,m2,m3;
    JButton next;
    Random ran=new Random();
    long first4=(ran.nextLong()%9000L)+10000L;
    String first=" "+Math.abs(first4);
    Signup(){
    super("APPLICATION FORM");
    
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("src/icon/logo.jpeg"));
     Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(25, 10, 100, 100);
     add(image);
     
     JLabel label1=new JLabel("APPLICATION FORM NO: "+first4);
     label1.setFont(new Font("Raleway",Font.BOLD,38));
     label1.setBounds(160,20,600,40);
     add(label1);

     JLabel label2=new JLabel("Page 1");
     label2.setFont(new Font("Raleway",Font.BOLD, 23));
     label2.setBounds(330, 70, 600,30);
     add(label2);

     JLabel label3=new JLabel("Personal Details");
     label3.setFont(new Font("Raleway",Font.BOLD, 23));
     label3.setBounds(290, 100, 600,30);
     add(label3);

     JLabel labelName=new JLabel("Name :");
     labelName.setFont(new Font("Raleway",Font.BOLD,20));
     labelName.setBounds(100,130,100,30);
     add(labelName);
     
     textName=new JTextField();
     textName.setFont(new Font("Raleway",Font.BOLD,14));
     textName.setBounds(300,130,400,30);
     add(textName);

     JLabel labelfName=new JLabel("Father's Name :");
     labelfName.setFont(new Font("Raleway",Font.BOLD,20));
     labelfName.setBounds(100,180,200,30);
     add(labelfName);
     
     textfName=new JTextField();
     textfName.setFont(new Font("Raleway",Font.BOLD,14));
     textfName.setBounds(300,180,400,30);
     add(textfName);

     JLabel DOB=new JLabel("Date of Birth :");
     DOB.setFont(new Font("Raleway",Font.BOLD,20));
     DOB.setBounds(100,230,200,30);
     add(DOB);
     
     dateChooser=new JDateChooser();
     dateChooser.setForeground(new Color(105,105,105));
     dateChooser.setBounds(300,230,400,30);
     add(dateChooser);

     JLabel labelG=new JLabel("Gender :");
     labelG.setFont(new Font("Raleway",Font.BOLD,20));
     labelG.setBounds(100,280,100,30);
     add(labelG);
     
     r1=new JRadioButton("Male");
     r1.setFont(new Font("Raleway", Font.BOLD, 14));
     r1.setBackground(new Color(222,255,228));
     r1.setBounds(300, 280,60, 30);
     add(r1);

     r2=new JRadioButton("Female");
     r2.setFont(new Font("Raleway", Font.BOLD, 14));
     r2.setBackground(new Color(222,255,228));
     r2.setBounds(380, 280,100, 30);
     add(r2);
     
     r3=new JRadioButton("Other");
     r3.setFont(new Font("Raleway", Font.BOLD, 14));
     r3.setBackground(new Color(222,255,228));
     r3.setBounds(500, 280,100, 30);
     add(r3);

     ButtonGroup gp1=new ButtonGroup();
     gp1.add(r1);
     gp1.add(r2);
     gp1.add(r3);

     JLabel labelEmail=new JLabel("Email Address :");
     labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
     labelEmail.setBounds(100,330,200,30);
     add(labelEmail);
     
     textEmail=new JTextField();
     textEmail.setFont(new Font("Raleway",Font.BOLD,14));
     textEmail.setBounds(300,330,400,30);
     add(textEmail);

     JLabel labelMs=new JLabel("Martial Status :");
     labelMs.setFont(new Font("Raleway",Font.BOLD,20));
     labelMs.setBounds(100,380,200,30);
     add(labelMs);

     m1=new JRadioButton("Married");
     m1.setFont(new Font("Raleway", Font.BOLD, 14));
     m1.setBackground(new Color(222,255,228));
     m1.setBounds(300, 380,100, 30);
     add(m1);

     m2=new JRadioButton("Unmarried");
     m2.setFont(new Font("Raleway", Font.BOLD, 14));
     m2.setBackground(new Color(222,255,228));
     m2.setBounds(410, 380,120, 30);
     add(m2);
     
     m3=new JRadioButton("Other");
     m3.setFont(new Font("Raleway", Font.BOLD, 14));
     m3.setBackground(new Color(222,255,228));
     m3.setBounds(550, 380,100, 30);
     add(m3);

     ButtonGroup gp2=new ButtonGroup();
     gp2.add(m1);
     gp2.add(m2);
     gp2.add(m3);
    
     JLabel labelAdd=new JLabel("Address :");
     labelAdd.setFont(new Font("Raleway",Font.BOLD,20));
     labelAdd.setBounds(100,430,200,30);
     add(labelAdd);
     
     textAdd=new JTextField();
     textAdd.setFont(new Font("Raleway",Font.BOLD,14));
     textAdd.setBounds(300,430,400,30);
     add(textAdd);

     JLabel labelState=new JLabel("State :");
     labelState.setFont(new Font("Raleway",Font.BOLD,20));
     labelState.setBounds(100,480,200,30);
     add(labelState);
     
     textState=new JTextField();
     textState.setFont(new Font("Raleway",Font.BOLD,14));
     textState.setBounds(300,480,400,30);
     add(textState);

     JLabel labelCity=new JLabel("City :");
     labelCity.setFont(new Font("Raleway",Font.BOLD,20));
     labelCity.setBounds(100,530,200,30);
     add(labelCity);
     
     textCity=new JTextField();
     textCity.setFont(new Font("Raleway",Font.BOLD,14));
     textCity.setBounds(300,530,400,30);
     add(textCity);

     JLabel labelPincode=new JLabel("Pincode :");
     labelPincode.setFont(new Font("Raleway",Font.BOLD,20));
     labelPincode.setBounds(100,580,200,30);
     add(labelPincode);
     
     textPincode=new JTextField();
     textPincode.setFont(new Font("Raleway",Font.BOLD,14));
     textPincode.setBounds(300,580,400,30);
     add(textPincode);

     next=new JButton("Next->>");
     next.setFont(new Font("Raleway",Font.BOLD,14));
     next.setForeground(Color.WHITE);
     next.setBackground(Color.BLACK);
     next.setBounds(600,640,100,30);
     next.addActionListener(this);
     add(next);

     getContentPane().setBackground(new Color(222,255,228));
     setLayout(null);
     setSize(850, 800);
    setLocation(360, 40);
    setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String FormNo=first;
        String Name=textName.getText();
        String FName=textfName.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String Gender=null;
        if(r1.isSelected()){
            Gender="Male";
        }else if(r2.isSelected()){
            Gender="Female";
        }else if(r3.isSelected()){
            Gender="Other";
        }
        String Email=textEmail.getText();
        String marital=null;
        if(m1.isSelected()){
            marital="Married";
        }else if(m2.isSelected()){
            marital="Unmarried";
        }else if(m3.isSelected()){
            marital="Other";
        }
        String Add=textAdd.getText();
        String State=textState.getText();
        String City=textCity.getText();
        String Pincode=textPincode.getText();

  try{
  if(textName.getText().equals("")){
         JOptionPane.showMessageDialog(null,"Fill All The Fields");
  }else{
        Connect con1=new Connect();
   String q="insert into Signup values('"+FormNo+"','"+Name+"','"+FName+"','"+dob+"','"+Gender+"','"+Email+"','"+marital+"','"+Add+"','"+State+"','"+City+"','"+Pincode+"')";
      con1.statement.executeUpdate(q);
         new Signup2(first);
      setVisible(false);
            }

        }catch(Exception E){
           E.printStackTrace();
       }
 }
    public static void main(String[] args) {
        new Signup();
    }
}
