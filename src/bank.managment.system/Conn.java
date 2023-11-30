package bank.managment.system;
import java.sql.*;
import com.mysql.jdbc.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try {
            //Class.forName(com.mysql.jdbc.Driver);//here Driver is register as driver name
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","MyP@ss12");//we are making connection by driver manager we need to write name of our database
            s = c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }


}
