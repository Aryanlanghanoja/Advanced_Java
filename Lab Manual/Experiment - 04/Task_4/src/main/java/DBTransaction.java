import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTransaction {

    private static final String URL = "jdbc:mysql://localhost:3306/ajt_practicle";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Method to get database connection
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver"); // Load MySQL driver
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to insert data into the database
    public static void InsertData(String name, String email, String phone, String message) {
        String query = "INSERT INTO user (name, email, phone, message) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, message);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " row(s) inserted.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
