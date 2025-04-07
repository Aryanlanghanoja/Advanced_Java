package org.example;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void Insert(Statement statement) {
        Scanner scanner = new Scanner(System.in);
        int no_of_rows;

        System.out.print("Enter The Number of Rows You Have to Insert :- ");
        no_of_rows = scanner.nextInt();
        scanner.nextLine();

        String[][] data = new String[no_of_rows][7];
        String[] attribute = {"First Name", "Surname" , "Email Id"};

        for (int i = 0; i < no_of_rows; i++) {
            System.out.println("Enter the Details for User - " + (i + 1));
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter the " + attribute[j] + " :- ");
                data[i][j] = scanner.nextLine();
            }
            System.out.println("_______________________________________________________________________________");
        }

        StringBuilder insertQuery = new StringBuilder("INSERT INTO User_Table (First_Name, Surname, Email_Id) VALUES ");

        for (int i = 0; i < no_of_rows; i++) {
            insertQuery.append("('").append(data[i][0]).append("', '").append(data[i][1]).append("', '").append(data[i][2]).append("')");

            if (i < no_of_rows - 1) {
                insertQuery.append(", ");
            }
        }

        insertQuery.append(";");

        try {
            statement.executeUpdate(insertQuery.toString());
            System.out.println("Data Inserted Successfully!\n");
            Display(statement);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public static void Display(Statement statement) throws SQLException {
        String fetch_query = "SELECT * FROM User_Table";
        ResultSet resultSet = statement.executeQuery(fetch_query);

        while(resultSet.next()) {
            System.out.println("First Name:- " + resultSet.getString(1));
            System.out.println("Surname:- " + resultSet.getString(2));
            System.out.println("Email ID:- " + resultSet.getString(3));
            System.out.println("-----------------------------");
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajt_practicle" , "root" , "");
            Statement statement = connection.createStatement();
            Insert(statement);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}