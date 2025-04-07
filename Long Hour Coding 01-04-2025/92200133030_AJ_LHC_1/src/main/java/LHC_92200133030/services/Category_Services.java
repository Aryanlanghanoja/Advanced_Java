package LHC_92200133030.services;

import LHC_92200133030.models.category;
import LHC_92200133030.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Category_Services {
    public void addCategory(category category_obj) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String insertQuery = "INSERT INTO categories (category_name) VALUES ('" +
                    category_obj.getName() +  "')";
            stmt.executeUpdate(insertQuery);
            System.out.println("Category added successfully!");

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    // Get All Blogs
    public List<category> getAllCategory() throws SQLException {
        List<category> categories = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM categories");

            while (rs.next()) {
                categories.add(new category(
                        rs.getString("category_name")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return categories;
    }
}
