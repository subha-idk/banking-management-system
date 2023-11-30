package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Transection extends JFrame implements ActionListener {
    JButton withdrawl, fastcash , pinchange, deposite, ministatement, balanceenquiry, exit;
    String pinnumber;
    Transection(String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel txt = new JLabel("Please Select your Transaction");
        txt.setBounds(200,300,700,35);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(txt);

        deposite = new JButton("Deposite");
        deposite.setBounds(170,415,150,30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
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
            System.exit(0);
        } else if (ae.getSource() == deposite) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource() == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Transection("");
    }

}
