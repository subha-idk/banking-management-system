package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);


        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);


        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        try {
            Conn conn = new Conn();
            String query = "select * from login where pin = '"+pinnumber+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            String query = "select * from bank where pin = '"+pinnumber+"' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") +"<br><br><html>");
            }
        }catch (Exception e){
            System.out.println("e");
        }

        mini.setBounds(20,140,400,200);



        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == "back"){
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
