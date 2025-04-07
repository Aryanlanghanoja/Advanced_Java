package org.example;

import java.sql.*;
import java.util.Scanner;

public class CRUD {
    private Connection connection;
    private Statement statement;

    CRUD(Connection connection) {
        this.connection = connection;
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Admin: Add User
    public String addUser(String username, String password, String email, String phone, String city, String state, String role) {
        String query = "INSERT INTO task_1 (User_Name, Password, Email_ID, Phone_No, City, State, Role) VALUES ('" +
                username + "', '" + password + "', '" + email + "', '" + phone + "', '" + city + "', '" + state + "', '" + role + "')";

        try {
            int rows = statement.executeUpdate(query);
            if (rows > 0) {
                return "User added successfully.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed to add user.";
    }

    // Admin: View All Users
    public void viewUsers() {
        String query = "SELECT * FROM task_1";
        try {
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("\n================= USER LIST =================");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("User_Name"));
                System.out.println("Email: " + resultSet.getString("Email_ID"));
                System.out.println("Phone: " + resultSet.getString("Phone_No"));
                System.out.println("City: " + resultSet.getString("City"));
                System.out.println("State: " + resultSet.getString("State"));
                System.out.println("Role: " + resultSet.getString("Role"));
                System.out.println("============================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Admin: Update User
    public String updateUser(String username, String email, String phone, String city, String state, String role) {
        String query = "UPDATE task_1 SET Email_ID = '" + email + "', Phone_No = '" + phone + "', City = '" + city +
                "', State = '" + state + "', Role = '" + role + "' WHERE User_Name = '" + username + "'";

        try {
            int rows = statement.executeUpdate(query);
            if (rows > 0) {
                return "User updated successfully.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed to update user.";
    }

    // Admin: Delete User
    public String deleteUser(String username) {
        String query = "DELETE FROM task_1 WHERE User_Name = '" + username + "'";

        try {
            int rows = statement.executeUpdate(query);
            if (rows > 0) {
                return "User deleted successfully.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed to delete user.";
    }

    // User: Login
    public String login(String username, String password) {
        String query = "SELECT role FROM task_1 WHERE User_Name = '" + username + "' AND Password = '" + password + "'";

        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid login credentials.";
    }

    // User: Update their own details
    public String updateProfile(String username, String email, String phone, String city, String state) {
        String query = "UPDATE task_1 SET Email_ID = '" + email + "', Phone_No = '" + phone + "', City = '" + city + "', State = '" + state +
                "' WHERE User_Name = '" + username + "'";

        try {
            int rows = statement.executeUpdate(query);
            if (rows > 0) {
                return "Profile updated successfully.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed to update profile.";
    }
}
