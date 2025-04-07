package LHC_92200133030.services;

import LHC_92200133030.models.batch;
import LHC_92200133030.utils.DBConnection;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Batch_Services {
    public void addBatch(@NotNull batch batch_obj) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String insertQuery = "INSERT INTO batch (no_of_products , product_name , batch_name) VALUES ('" +
                    batch_obj.getNo_of_product() + "' , '" + batch_obj.getProduct_name() +  "' , '" + batch_obj.getBatch_name() + "')";
            stmt.executeUpdate(insertQuery);
            System.out.println("Batch added successfully!");

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    // Get All Blogs
    public  List<batch> getAllBatch() throws SQLException {
        List<batch> batches = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM batch");

            while (rs.next()) {
                batches.add(new batch(
                        Integer.parseInt(rs.getString("batch_id")),
                        rs.getString("product_name"),
                        Integer.parseInt(rs.getString("no_of_products"))

                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return batches;
    }
}
