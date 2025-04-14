package org.example;

import java.sql.*;

public class App {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajt_practicle" , "root" , "");
            Statement statement = connection.createStatement();
            String Fetchquery = "SELECT * FROM Student_Table";
            ResultSet resultSet = statement.executeQuery(Fetchquery);

            while(resultSet.next()) {
                System.out.println("Student Name :- " + resultSet.getString(1));
                System.out.println("Enrollment Number :- " + resultSet.getString(2));
                System.out.println("Semester :- " + resultSet.getString(3));
                System.out.println("Class :- " + resultSet.getString(4));
                System.out.println("Batch :- " + resultSet.getString(5));
                System.out.println("Email ID :- " + resultSet.getString(6));
                System.out.println("Password :- " + resultSet.getString(7));
                System.out.println("__________________________________________________________");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
