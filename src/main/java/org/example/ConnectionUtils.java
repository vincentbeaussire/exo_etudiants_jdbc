package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getSQLConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_jdbc";
        String userName = "root";
        String password = "test";

        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;


//        try {
//            if (connection != null) {
//                System.out.println("Connexion fonctionnelle.");
//            } else {
//                System.out.println("Connexion échouée");
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
