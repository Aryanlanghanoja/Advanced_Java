package LHC_92200133030.services;

import LHC_92200133030.models.product;
import LHC_92200133030.utils.DBConnection ;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Product_Services {

    // Add Blog
    public void addProduct(product product_obj) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String insertQuery = "INSERT INTO product (name, category , cost) VALUES ('" +
                    product_obj.getProduct_name() + "', '" + product_obj.getCategory() + "', '" + product_obj.getCost() + "')";
            stmt.executeUpdate(insertQuery);
            System.out.println("Product added successfully!");

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    // Get All Blogs
    public List<product> getAllProducts() throws SQLException {
        List<product> products = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM product");

            while (rs.next()) {
                products.add(new product(
//                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("cost")
//                        rs.getString("stage")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return products;
    }


}
