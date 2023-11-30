package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel Toptext = new JLabel("Balance Enquiry");
        Toptext.setBounds(270,300,400,20);
        Toptext.setForeground(Color.MAGENTA);
        Toptext.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(Toptext);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Conn conn = new Conn();
        int balance =0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is "+balance+"");
        text.setBounds(170,340,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
