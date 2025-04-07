package org.example;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void validate(@org.jetbrains.annotations.NotNull ResultSet resultSet) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String Full_name = "" ;
        boolean isstopped = false ;
        boolean isvalid = false ;
        String user_name ;
        String password;

        System.out.println("Enter the Username :- ");
        user_name = sc.next();
        
        System.out.println("Enter the Password :- ");
        password = sc.next();

        while(isvalid == false && isstopped == false) {
            while(resultSet.next()) {
                if(Objects.equals(resultSet.getString("username"), user_name) && Objects.equals(resultSet.getString("pwd"), password)) {
                    System.out.println("The User is Exists with the Full Name " + resultSet.getString("fullname"));
                    Full_name = resultSet.getString("fullname");
                }
            }

            if(!Objects.equals(Full_name, "")) {
                System.out.println("Username is :- " + Full_name);
                System.out.println("Login Sucessfull");
                isvalid = true ;
                return;
            }

            else {
                System.out.println("Invalid User");

                int stop = 0 ;
                System.out.println("Enter -1 to Stop else 0 :- ");
                stop = sc.nextInt();

                if(stop == -1) {
                    isstopped = true ;
                    System.out.println("Login System Closed");
                    return ;
                }

                else {
                    System.out.println("Enter the Username :- ");
                    user_name = sc.next();

                    System.out.println("Enter the Password :- ");
                    password = sc.next();
                }
            }
        }
    }
    public static void main( String[] args )
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = +.getConnection("jdbc:mysql://localhost:3306/mu_2425_test" , "root" , "");
            Statement statement = connection.createStatement();
//            String query = "INSERT INTO user_tbl(username, pwd, fullname) VALUES ('ABCDE', 'ABC', 'ABC_1'), ('EFGHI', 'DEF', 'DEF_1')";
//            int i = statement.executeUpdate(query);
//            System.out.println("Affected Rows :- " + i);
            String fetchquery = "SELECT * FROM user_tbl" ;
            ResultSet resultSet = statement.executeQuery(fetchquery);

            validate(resultSet);
//
//            while(resultSet.next()) {
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getString("pwd"));
//                System.out.println(resultSet.getString("fullname"));
//                System.out.println(resultSet.getString("status"));
//                System.out.println("======================================================");
//            }

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

//package org.example;
//
//import java.sql.*;
//        import java.util.Scanner;
//
///**
// * Hello world!
// *
// */
//public class App
//{
//    public static void main( String[] args )
//    {
//        login();
////        System.out.println(validateUser("abc","abc"));
////        System.out.println(validateUser("ab","abc"));
////        System.out.println(validateUser("ac","abc"));
////        System.out.println(validateUser("arzoo","arzoo"));
//    }
//    public static String validateUser(String uname, String pwd){
//        String ret="No such user found";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mu_2425_test","root","");
//            Statement statement = connection.createStatement();
//            String query = "select fullname from user_tbl where username='"+uname+"' and pwd='"+pwd+"'";
//            ResultSet resultSet = statement.executeQuery(query);
//            while(resultSet.next()){
//                ret = resultSet.getString("fullname");
//            }
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return ret;
//    }
//    public static void login(){
//        Scanner sc= new Scanner(System.in);
//        boolean isCancel = false;
//        boolean validUser = false;
//        while(!validUser & !isCancel){
//            System.out.println("Enter username: ");
//            String uname = sc.next();
//            System.out.println("Enter password: ");
//            String pwd = sc.next();
//            String ret = validateUser(uname,pwd);
//            if(ret.equals("No such user found")){
//                System.out.println(ret+" if you want to try again yes/no");
//                String choice = sc.next();
//                if(choice.equals("No")||choice.equals("no")){
//                    isCancel= true;
//                    System.out.println("bye from this");
//                }
//            }else{
//                validUser= true;
//                System.out.println("Welcome, "+ret);
//            }
//        }
//    }
//}
//
