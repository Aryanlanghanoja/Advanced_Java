package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Connection connection = MyConnection.getInstance().createConnection();
        CRUD crud = new CRUD(connection);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nUser Management System");
            System.out.println("1. Admin - Add User");
            System.out.println("2. Admin - View Users");
            System.out.println("3. Admin - Update User");
            System.out.println("4. Admin - Delete User");
            System.out.println("5. User - Login");
            System.out.println("6. User - Update Profile");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:  // Admin - Add User
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    System.out.print("Role (Admin/User): ");
                    String role = scanner.nextLine();
                    System.out.println(crud.addUser(username, password, email, phone, city, state, role));
                    break;

                case 2:  // Admin - View Users
                    crud.viewUsers();
                    break;

                case 3:  // Admin - Update User
                    System.out.print("Username to update: ");
                    String updateUsername = scanner.nextLine();
                    System.out.print("New Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("New Phone: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("New City: ");
                    String newCity = scanner.nextLine();
                    System.out.print("New State: ");
                    String newState = scanner.nextLine();
                    System.out.print("New Role: ");
                    String newRole = scanner.nextLine();
                    System.out.println(crud.updateUser(updateUsername, newEmail, newPhone, newCity, newState, newRole));
                    break;

                case 4:  // Admin - Delete User
                    System.out.print("Username to delete: ");
                    String deleteUsername = scanner.nextLine();
                    System.out.println(crud.deleteUser(deleteUsername));
                    break;

                case 5:  // User - Login
                    System.out.print("Username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Password: ");
                    String loginPassword = scanner.nextLine();
                    System.out.println(crud.login(loginUsername, loginPassword));
                    break;

                case 6:  // User - Update Profile
                    System.out.print("Username: ");
                    String profileUsername = scanner.nextLine();
                    System.out.println("Updating profile...");
                    // Call update method
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
