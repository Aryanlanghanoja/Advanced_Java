package org.example;
import java.sql.*;

class MyConnection {

    public static MyConnection connectionobj;
    Connection connection;

    private MyConnection() {

    }

    public static MyConnection getInstance() {
        if (connectionobj == null) {
            connectionobj = new MyConnection();
        }
        return connectionobj;
    }

    public Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajt_task", "root", "");
            System.out.println("Database connected successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
