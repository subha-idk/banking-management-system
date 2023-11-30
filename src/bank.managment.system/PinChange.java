package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JTextField Pintext, Repintext;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,285,400,20);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        JLabel pintext = new JLabel("New PIN");
        pintext.setBounds(165,320,100,25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(pintext);

        Pintext = new JTextField();
        Pintext.setBounds(330,320,180,20);
        Pintext.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(Pintext);

        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setBounds(165,360,180,25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(repintext);

        Repintext = new JTextField();
        Repintext.setBounds(330,360,180,20);
        Repintext.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(Repintext);

        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change){
            try {
                String pin = Pintext.getText();
                String repin = Repintext.getText();
                if(!pin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }if(pin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter PIN");
                    return;
                }if(repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter NEW PIN");
                    return;
                }
                JOptionPane.showMessageDialog(null,"enter pin "+repin);
                Conn c = new Conn();
                String qurey1 = "update bank set pin ='"+repin+"' where pin = '"+pinnumber+"' ";
                String qurey2 = "update login set pin = '"+repin+"' where pin = '"+pinnumber+"'";
                String qurey3 = "update signupthree set pin = '"+repin+"' where pin = '"+pinnumber+"'";

                c.s.executeUpdate(qurey1);
                c.s.executeUpdate(qurey2);
                c.s.executeUpdate(qurey3);

                JOptionPane.showMessageDialog(null,"PIN Change successfully");
                setVisible(false);
                new Transection(repin).setVisible(true);


            }catch (Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource() == back){
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
