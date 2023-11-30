package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fathernameTextField, emailTextField, addressTextFied, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male,female ,married,unmarried;
    JDateChooser dateChooser;


     SignupOne(){
         setTitle("SIGNUP");
         setLayout(null);
         Random ran = new Random();
         random = Math.abs((ran.nextLong()%9000L)+1000L);

         JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
         formno.setFont(new Font("Rale way",Font.BOLD,38));
         formno.setBounds(140,20,800,40);
         add(formno);

         JLabel personaDetails = new JLabel("Page 1: Personal Details");
         personaDetails.setForeground(Color.BLUE);
         personaDetails.setFont(new Font("Rale way",Font.BOLD,22));
         personaDetails.setBounds(290,70,400,40);
         add(personaDetails);

         JLabel name = new JLabel("Name :");
         name.setFont(new Font("Raleway",Font.BOLD,28));
         name.setBounds(100,140,200,30);
         add(name);

         nameTextField = new JTextField();
         nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
         nameTextField.setBounds(350,140,400,30);
         add(nameTextField);

         JLabel fathername = new JLabel("Father Name :");
         fathername.setFont(new Font("Raleway",Font.BOLD,28));
         fathername.setBounds(100,190,400,30);
         add(fathername);



         fathernameTextField = new JTextField();
         fathernameTextField.setFont(new Font("Raleway",Font.BOLD,14));
         fathernameTextField.setBounds(350,190,400,30);
         add(fathernameTextField);

         JLabel dob = new JLabel("Date of Birth :");
         dob.setFont(new Font("Raleway",Font.BOLD,28));
         dob.setBounds(100,240,250,30);
         add(dob);

         dateChooser = new JDateChooser();
         dateChooser.setBounds(350,240,400,30);
         dateChooser.setFont(new Font("Raleway",Font.BOLD,18));
         add(dateChooser);

         JLabel Gender = new JLabel("Gender :");
         Gender.setFont(new Font("Raleway",Font.BOLD,28));
         Gender.setBounds(100,300,150,30);
         add(Gender);

         male = new JRadioButton("Male");
         male.setBounds(350,300,100,30);
         male.setFont(new Font("Raleway",Font.BOLD,18));
         male.setBackground(Color.WHITE);
         add(male);

         female = new JRadioButton("Female");
         female.setBounds(550,300,100,30);
         female.setFont(new Font("Raleway",Font.BOLD,18));
         female.setBackground(Color.WHITE);
         add(female);

         ButtonGroup gendergroup = new ButtonGroup();
         gendergroup.add(male);
         gendergroup.add(female);


         JLabel email = new JLabel("Email :");
         email.setFont(new Font("Raleway", Font.BOLD,28));
         email.setBounds(100,360,150,30);
         add(email);

         emailTextField = new JTextField();
         emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
         emailTextField.setBounds(350,360,400,30);
         add(emailTextField);

         JLabel marital = new JLabel("Marital :");
         marital.setFont(new Font("Raleway",Font.BOLD,28));
         marital.setBounds(100,420,150,30);
         add(marital);

         married = new JRadioButton("Married");
         married.setBounds(350,420,150,30);
         married.setFont(new Font("Raleway",Font.BOLD,18));
         married.setBackground(Color.WHITE);
         add(married);

         unmarried = new JRadioButton("Unmarried");
         unmarried.setBounds(550,420,150,30);
         unmarried.setFont(new Font("Raleway",Font.BOLD,18));
         unmarried.setBackground(Color.WHITE);
         add(unmarried);

         ButtonGroup maritalgroup = new ButtonGroup();
         maritalgroup.add(married);
         maritalgroup.add(unmarried);

         JLabel address = new JLabel("Address");
         address.setFont(new Font("Raleway",Font.BOLD,28));
         address.setBounds(100,480,150,30);
         add(address);

         addressTextFied = new JTextField();
         addressTextFied.setFont(new Font("Raleway",Font.BOLD,14));
         addressTextFied.setBounds(350,480,400,30);
         add(addressTextFied);

         JLabel city = new JLabel("City :");
         city.setFont(new Font("Raleway",Font.BOLD,28));
         city.setBounds(100,540,100,30);
         add(city);

         cityTextField = new JTextField();
         cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
         cityTextField.setBounds(350,540,400,30);
         add(cityTextField);

         JLabel state = new JLabel("State :");
         state.setFont(new Font("Raleway",Font.BOLD,28));
         state.setBounds(100,600,150,30);
         add(state);

         stateTextField = new JTextField();
         stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
         stateTextField.setBounds(350,600,400,30);
         add(stateTextField);

         JLabel pin = new JLabel("PIN :");
         pin.setFont(new Font("Raleway",Font.BOLD,28));
         pin.setBounds(100,660,100,30);
         add(pin);

         pinTextField = new JTextField();
         pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
         pinTextField.setBounds(350,660,400,30);
         add(pinTextField);

         next = new JButton("Next");
         next.setForeground(Color.WHITE);
         next.setBackground(Color.BLACK );
         next.setFont(new Font("Raleway",Font.BOLD,14));
         next.setBounds(660,700,80,30);
         next.addActionListener(this);
         add(next);




         getContentPane().setBackground(Color.white);
         setSize(850,800);
         setVisible(true);
         setLocation(350,10);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }

     public void actionPerformed(ActionEvent ae){
         String formno = ""+ random;
         String name = nameTextField.getText();
         String fname = fathernameTextField.getText();
         String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
         String gen = null;
         if(male.isSelected()){
             gen = "Male";
         } else if (female.isSelected()) {
             gen = "Female";
         }
         String email = emailTextField.getText();
         String marital_status = null;
         if(married.isSelected()){
             marital_status = "Married";
         } else if (unmarried.isSelected()) {
             marital_status = "Unmarried";
         }
         String address = addressTextFied.getText();
         String city = cityTextField.getText();
         String state = stateTextField.getText();
         String pin = pinTextField.getText();

         try{
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null,"Please fill Name");
             } else{
                 Conn c = new Conn();
                 String query = "INSERT INTO signup VALUES('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gen+"','"+email+"','"+marital_status+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignupTwo(formno).setVisible(true);;


             }


         }catch (Exception e){
             System.out.println(e);
         }
     }

    public static void main(String[] args) {
        new SignupOne();

    }
}
