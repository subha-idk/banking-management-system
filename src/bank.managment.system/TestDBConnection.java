package bank.managment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        //"jdbc:mysql://hostname:port/database";
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "MyP@ss12";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connection successful!");
            // Close the connection when done.
            connection.close();
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}

