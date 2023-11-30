package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton Rs100, Rs500, Rs1000, Rs2000, Rs5000, Rs10000, exit;
    String pinnumber;
    FastCash(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel txt = new JLabel("SELECT WITHDRAWAL AMOUNT");
        txt.setBounds(200,300,700,35);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(txt);

        Rs100 = new JButton("100");
        Rs100.setBounds(170,415,150,30);
        Rs100.addActionListener(this);
        image.add(Rs100);

        Rs500 = new JButton("500");
        Rs500.setBounds(355,415,150,30);
        Rs500.addActionListener(this);
        image.add(Rs500);

        Rs1000 = new JButton("1000");
        Rs1000.setBounds(170,450,150,30);
        Rs1000.addActionListener(this);
        image.add(Rs1000);

        Rs2000 = new JButton("2000");
        Rs2000.setBounds(355,450,150,30);
        Rs2000.addActionListener(this);
        image.add(Rs2000);

        Rs5000 = new JButton("5000");
        Rs5000.setBounds(170,485,150,30);
        Rs5000.addActionListener(this);
        image.add(Rs5000);

        Rs10000 = new JButton("10000");
        Rs10000.setBounds(355,485,150,30);
        Rs10000.addActionListener(this);
        image.add(Rs10000);

        exit = new JButton("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText();
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Rs "+amount+" is Successfully withdrawal");
                setVisible(false);
                new Transection(pinnumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
