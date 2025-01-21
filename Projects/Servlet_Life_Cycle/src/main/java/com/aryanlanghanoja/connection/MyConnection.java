package com.aryanlanghanoja.connection;

import java.sql.*;

public class MyConnection {

    public static MyConnection connectionobj;
    Connection connection;

    private MyConnection() {

    }

    public static MyConnection getInstante() {
        if(connectionobj == null) {
            connectionobj = new MyConnection();
        }

        return connectionobj;
    }

    public void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mu_2425_test" , "root" , "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String Validate_User (String User_Name , String Password) {
        createConnection();
        String result = "No User Found" ;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user_tbl WHERE username = '" + User_Name + "'and pwd = '" + Password + "'");

            if (resultSet.next()) {
                result = resultSet.getString("fullname");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result ;
    }
}

//package com.allysoftsolutions.connection;
//
//import java.sql.*;
//
//public class MyConn {
//    public MyConn connObj;
//    Connection connection;
//    private MyConn(){
//
//    }
//    public MyConn getInstance(){
//        if(connObj==null)
//            connObj = new MyConn();
//        return connObj;
//    }
//    public void createConnction(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mu_2425_test","root","");
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public String validateUser(String unm, String pwd){
//        String result = "No user found";
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from user_tbl where username = '"+unm+"' and pwd='"+pwd+"'");
//            if(rs.next()){
//                result = rs.getString("fullname");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//}
