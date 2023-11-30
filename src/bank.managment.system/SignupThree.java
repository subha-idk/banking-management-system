package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit , cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        JLabel acdetails = new JLabel("Page 3: Account Details");
        acdetails.setBounds(280,40,400,40);
        acdetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(acdetails);

        JLabel type = new JLabel("Account Type");
        type.setBounds(100,140,200,30);
        type.setFont(new Font("Raleway",Font.BOLD,22));
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setBounds(100,180,170,20);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(Color.WHITE);
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350,180,250,20);
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(Color.WHITE);
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100,220,170,20);
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(Color.WHITE);
        add(r3);
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,220,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setBounds(100,300,200,30);
        card.setFont(new Font("Raleway",Font.BOLD,22));
        add(card);
        JLabel no = new JLabel("XXXX-XXXX-XXXX-4184");
        no.setBounds(330,300,400,30);
        no.setFont(new Font("Raleway",Font.BOLD,22));
        add(no);
        JLabel cardtails = new JLabel("Your 16 Digit Card Number");
        cardtails.setBounds(100,320,400,30);
        cardtails.setFont(new Font("Raleway",Font.BOLD,12));
        add(cardtails);

        JLabel pin = new JLabel("Pin Number");
        pin.setBounds(100,380,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);
        JLabel pinno = new JLabel("XXXX");
        pinno.setBounds(330,380,400,30);
        pinno.setFont(new Font("Raleway",Font.BOLD,22));
        add(pinno);
        JLabel pindetails = new JLabel("Your 4 Digit Passworld");
        pindetails.setBounds(100,400,400,30);
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setBounds(100,450,400,30);
        services.setFont(new Font("Raleway",Font.BOLD,22));
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declared that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,700,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(700,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(500,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);



        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accounttype = null;
            if(r1.isSelected()){
                accounttype = "Savings Account";
            }else if(r2.isSelected()){
                accounttype = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accounttype = "Current Account";
            }else if(r4.isSelected()){
                accounttype = "Recurring Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card ";
            }  if (c2.isSelected()) {
                facility = facility + " Internet Banking ";
            }  if (c3.isSelected()) {
                facility = facility + " Mobile Banking ";
            }  if(c4.isSelected()){
                facility = facility + " Email & sms Alert ";
            }  if (c5.isSelected()) {
                facility = facility + " Cheque Book ";
            }  if (c6.isSelected()) {
                facility = facility + " E-Statement ";
            }
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 =  "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"CardNumber: "+ cardnumber +"\n Pin: "+ pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }

            } catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Login();
        }


    }
    public static void main(String[] args) {
         new SignupThree("");

    }
}
