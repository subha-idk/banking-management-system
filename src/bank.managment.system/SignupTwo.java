package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    public String formno;
    JRadioButton Syes, Sno ,ACyes, ACno;
    JTextField panTextField, aadharTextField;
    JButton next;
    JComboBox<String> CBoxcategory,CBoxincome,CBoxoccupation,CBoxeducation ,CBoxreligion ;
    SignupTwo(String formno){
        setTitle("Signup");
        setLayout(null);
        this.formno = formno;

        JLabel page2 = new JLabel("Page 2: Additional Details");
        page2.setFont(new Font("Ralewat",Font.BOLD,26));
        page2.setBounds(250,30,400,30);
        add(page2);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,28));
        religion.setBounds(100,130,200,30);
        add(religion);

        String valReligion[] ={"Hindu","Muslim","Sikh","christian","other"};
        CBoxreligion = new JComboBox<>(valReligion);
        CBoxreligion.setBounds(350,130,400,30);
        add(CBoxreligion);





        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,28));
        category.setBounds(100,180,200,30);
        add(category);
        String valCategory[] ={"General","OBC","SC","ST","others"};
        CBoxcategory = new JComboBox<>(valCategory);
        CBoxcategory.setBounds(350,180,400,30);
        add(CBoxcategory);

        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,28));
        income.setBounds(100,230,200,30);
        add(income);
        String valIncome[] ={"Null","<1,50,00","<2,50,00","<5,00,00","upto 10,00,000"};
        CBoxincome = new JComboBox<>(valIncome);
        CBoxincome.setBounds(350,230,400,30);
        add(CBoxincome);

        JLabel education = new JLabel("Education ");
        education.setFont(new Font("Raleway",Font.BOLD,28));
        education.setBounds(100,280,400,30);
        add(education);
        JLabel qualification = new JLabel("Qualification");
        qualification.setFont(new Font("Raleway",Font.BOLD,28));
        qualification.setBounds(100,310,400,30);
        add(qualification);
        JLabel colon = new JLabel(":");
        colon.setFont(new Font("Raleway",Font.BOLD,28));
        colon.setBounds(320,295,400,30);
        add(colon);
        String valEducation[] ={"Non-Graduation","<Graduation","<Post-Graduation","<Doctrate","Others"};
        CBoxeducation  = new JComboBox<>(valEducation);
        CBoxeducation.setBounds(350,290,400,30);
        add(CBoxeducation);

        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD,28));
        occupation.setBounds(100,350,200,30);
        add(occupation);
        String valOccupation[] ={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        CBoxoccupation = new JComboBox<>(valOccupation);
        CBoxoccupation .setBounds(350,350,400,30);
        add(CBoxoccupation );

        JLabel pan = new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway",Font.BOLD,28));
        pan.setBounds(100,400,300,30);
        add(pan);
        panTextField = new JTextField();
        panTextField.setBounds(350,400,400,30);
        panTextField.setFont(new Font("Raleway",Font.BOLD,28));
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar NO :");
        aadhar.setFont(new Font("Raleway",Font.BOLD,28));
        aadhar.setBounds(100,450,400,30);
        add(aadhar);
        aadharTextField = new JTextField();
        aadharTextField.setBounds(350,450,400,30);
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,28));
        add(aadharTextField);

        JLabel Scitizen = new JLabel("Senior Citizen :");
        Scitizen.setFont(new Font("Raleway",Font.BOLD,28));
        Scitizen.setBounds(100,500,400,30);
        add(Scitizen);
        Syes = new JRadioButton("Yes");
        Syes.setBounds(450,500,100,30);
        Syes.setFont(new Font("Raleway",Font.BOLD,28));
        Syes.setBackground(Color.WHITE);
        add(Syes);
        Sno = new JRadioButton("NO");
        Sno.setBounds(650,500,100,30);
        Sno.setFont(new Font("Raleway",Font.BOLD,28));
        Sno.setBackground(Color.WHITE);
        add(Sno);

        JLabel existingAC = new JLabel("Existing Account :");
        existingAC.setFont(new Font("Raleway",Font.BOLD,28));
        existingAC.setBounds(100,550,400,30);
        add(existingAC);
        ACyes = new JRadioButton("Yes");
        ACyes.setBounds(450,550,100,30);
        ACyes.setFont(new Font("Raleway",Font.BOLD,28));
        ACyes.setBackground(Color.WHITE);
        add(ACyes);
        ACno = new JRadioButton("NO");
        ACno.setBounds(650,550,100,30);
        ACno.setFont(new Font("Raleway",Font.BOLD,28));
        ACno.setBackground(Color.WHITE);
        add(ACno);

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) CBoxreligion.getSelectedItem();
        String scategory = (String) CBoxcategory.getSelectedItem();
        String sincome = (String) CBoxincome.getSelectedItem();
        String seducation = (String) CBoxeducation.getSelectedItem();
        String soccupation = (String) CBoxoccupation.getSelectedItem();

        String Senior = null;
        if(Syes.isSelected()){
            Senior = "YES";

        }else if (Sno.isSelected()){
            Senior = "NO";
        }
        String ExistingAC = null;
        if(ACyes.isSelected()){
            ExistingAC = "YES";
        }else if(ACno.isSelected()){
            ExistingAC = "NO";
        }
        String Aadhar = aadharTextField.getText();
        String Pan = panTextField.getText();
        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo VALUES('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+Pan+"','"+Aadhar+"','"+Senior+"','"+ExistingAC+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno);
            setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        new SignupTwo("");

    }
}
