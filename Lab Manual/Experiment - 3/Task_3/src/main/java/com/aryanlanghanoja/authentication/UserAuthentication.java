package com.aryanlanghanoja.authentication;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class MyConnection {

    public static MyConnection connectionobj;
    Connection connection;

    MyConnection() {

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajt_practicle" , "root" , "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String Validate_User(String First_Name, String Last_Name, String Email,
                                @NotNull HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        createConnection();
        String result = "No User Found";

        try {
            Statement statement = connection.createStatement();
            String query;

            // Build the query based on whether the Email is null or not
            if (Email != null && !Email.isEmpty()) {
                query = "SELECT * FROM task_2 WHERE First_Name = '" + First_Name +
                        "' AND Last_Name = '" + Last_Name + "' AND Email = '" + Email + "'";
            } else {
                query = "SELECT * FROM task_2 WHERE First_Name = '" + First_Name +
                        "' AND Last_Name = '" + Last_Name + "'";
            }

            ResultSet resultSet = statement.executeQuery(query);

            StringBuilder sb = new StringBuilder();

            while (resultSet.next()) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append("First Name: ").append(resultSet.getString("First_Name"))
                        .append("\nMiddle Name: ").append(resultSet.getString("Middle_Name"))
                        .append("\nLast Name: ").append(resultSet.getString("Last_Name"))
                        .append("\nEmail: ").append(resultSet.getString("Email"))
                        .append("\nContact No: ").append(resultSet.getString("Contact_No"))
                        .append("\n");
            }

            if (sb.length() > 0) {
                result = sb.toString();
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}

@WebServlet(urlPatterns = "/Validate_User")
public class UserAuthentication extends HttpServlet {
    MyConnection connectionobj = new MyConnection();

    @Override
    protected void doGet(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String First_Name = req.getParameter("fname");
        String Last_Name = req.getParameter("lname");
        String Email = req.getParameter("email");
        String result = connectionobj.Validate_User(First_Name , Last_Name , Email , req, resp);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>User Validator</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #667eea, #764ba2); height: 100vh; display: flex; justify-content: center; align-items: center; margin: 0; }");
        out.println(".container { background: white; padding: 30px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2); text-align: center; width: 350px; }");
        out.println("h2 { color: #333; margin-bottom: 20px; }");
        out.println("input { padding: 12px; margin: 15px 0; border: 1px solid #ccc; border-radius: 6px; width: calc(100% - 24px); font-size: 16px; outline: none; transition: border 0.3s; }");
        out.println("input:focus { border-color: #667eea; }");
        out.println("button { padding: 12px; border: none; background: #667eea; color: white; border-radius: 6px; cursor: pointer; width: 100%; font-size: 16px; transition: background 0.3s, transform 0.2s; }");
        out.println("button:hover { background: #5567c3; transform: scale(1.05); }");
        out.println(".result { margin-top: 20px; padding: 10px; background: #f9f9f9; border-radius: 6px; font-size: 16px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Client Result</h1>");
        out.println("<h2>Enter Your Details</h2>");
        out.println("<form action='Validate_User' method='post'>");
        out.println("<input type='text' name='fname' placeholder='Enter Your First Name' required>");
        out.println("<input type='text' name='lname' placeholder='Enter Your Last Name' required>");
        out.println("<input type='text' name='email' placeholder='Enter Your Email Address'>");
        out.println("<button type='submit' name='Validate'>Submit</button>");
        out.println("</form>");

        // **Result displayed here below the form**
        out.println("<div class='result'>");
        if (result.equals("No User Found")) {
            out.println("<p style='color: red; font-weight: bold;'>User Not Found</p>");
        } else {
            out.println("<pre style='text-align:left;'>" + result + "</pre>");
        }
        out.println("</div>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
