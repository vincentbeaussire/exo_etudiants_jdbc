package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            connection = ConnectionUtils.getSQLConnection();

            // Récupèration des données utilisateurs

//            connection = ConnectionUtils.getSQLConnection();
//            System.out.println("On vient de se connecter à la BDD");
//            System.out.println("Veuillez saisir votre prénom");
//            String firstName = scanner.nextLine();
//            System.out.println("Veuillez saisir votre nom");
//            String lastName = scanner.nextLine();
//            System.out.println("Veuillez saisir votre numéro de classe");
//            int numClass = scanner.nextInt();
//            scanner.nextLine(); // Toujours ajouter après un int
//            System.out.println("Veuillez saisir la date du diplôme");
//            String graduationDate = scanner.nextLine();
//
//            String request = "INSERT INTO students (first_name, last_name, num_class, graduation_date) VALUES (?, ?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(request);
//            preparedStatement.setString(1, firstName);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setInt(3, numClass);
//            preparedStatement.setString(4, graduationDate);
//            preparedStatement.execute();


            // Afficher la totalité des étudiants

            String request2 = "SELECT * FROM students";

            PreparedStatement statement = connection.prepareStatement(request2);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Nom : " + resultSet.getString("first_name"));
                System.out.println("Prénom : " + resultSet.getString("last_name"));
                System.out.println("Numéro de classe : " + resultSet.getInt("num_class"));
                System.out.println("Date de diplôme : " + resultSet.getString("graduation_date"));
                scanner.nextLine();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
