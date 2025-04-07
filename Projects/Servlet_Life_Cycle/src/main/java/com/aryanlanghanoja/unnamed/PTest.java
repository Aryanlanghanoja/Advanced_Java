package com.aryanlanghanoja.unnamed;

import java.sql.*;
import java.util.Scanner;

public class PTest {

    public static void ExecuteQuery(String Query, Statement statement) {
        try {
            ResultSet resultSet = statement.executeQuery(Query);

            while(resultSet.next()) {
                System.out.println("User Name :- " + resultSet.getString("username"));
                System.out.println("Password :- " + resultSet.getString("pwd"));
                System.out.println("Full Name :- " + resultSet.getString("fullname"));
                System.out.println("Status :- " +resultSet.getInt("status"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ByUsername(String UserName , Statement statement) {
        String Query = "SELECT * FROM User_tbl WHERE username = '" + UserName + "';";
        ExecuteQuery(Query , statement);
    }

    public static void ByFullname(String Fullname , Statement statement) {
        String Query = "SELECT * FROM User_tbl WHERE fullname = '" + Fullname + "';";
        ExecuteQuery(Query , statement);
    }

    public static void ByBoth(String Fullname , String Username ,  Statement statement) {
        String Query = "SELECT * FROM User_tbl WHERE fullname = '" + Fullname + "' and username = '" + Username + "';";
        ExecuteQuery(Query , statement);
    }

    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/mu_2425_test";
        String User = "root";
        String Password = "";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, User, Password);

            Scanner scanner = new Scanner(System.in);
            String Username = null;
            String Fullname = null;


            System.out.println("Enter the User Name :- ");
            Username = scanner.nextLine();

            System.out.println("Enter the Fullname :- ");
            Fullname = scanner.nextLine();


            String Query = "SELECT * FROM User_tbl WHERE username = ?";
            Statement statement = connection.createStatement();
//            preparedStatement.setString(1 , "aryanpatel");
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()) {
//                System.out.println("User Name :- " + resultSet.getString("username"));
//                System.out.println("Password :- " + resultSet.getString("pwd"));
//                System.out.println("Full Name :- " + resultSet.getString("fullname"));
//                System.out.println("Status :- " +resultSet.getInt("status"));
//            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
