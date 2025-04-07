package LHC_92200133030.services;

import LHC_92200133030.models.input_product;
import LHC_92200133030.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Input_Product_Services {

    public void add_input_product(input_product input_product_obj) throws SQLException {
    Connection conn = null;
    Statement stmt = null;

    try {
        conn = DBConnection.getConnection();
        stmt = conn.createStatement();

        String insertQuery = "INSERT INTO in_product (in_product_name , cost) VALUES ('" +
                input_product_obj.getProduct_name() + "' , '" + input_product_obj.getCost() +  "')";
        stmt.execute(insertQuery);
        System.out.println("Input Product added successfully!");

    } finally {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
}

    // Get All Blogs
    public List<input_product> get_input_product() throws SQLException {
        List<input_product> input_products = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM in_product");

            while (rs.next()) {
                input_products.add(new input_product(
                    rs.getString("name"),
                    Integer.parseInt(rs.getString("cost"))
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return input_products;
    }
}
