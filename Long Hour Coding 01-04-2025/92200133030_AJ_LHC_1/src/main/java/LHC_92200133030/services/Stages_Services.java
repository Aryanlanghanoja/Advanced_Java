package LHC_92200133030.services;

import LHC_92200133030.models.stage;
import LHC_92200133030.utils.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Stages_Services {
    public void addStage(stage stage_obj) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String insertQuery = "INSERT INTO stage (stage_name) VALUES ('" +
                    stage_obj.getStage_name() +  "')";
            stmt.executeUpdate(insertQuery);
            System.out.println("Stages added successfully!");

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    // Get All Blogs
    public List<stage> getAllStage() throws SQLException {
        List<stage> stages = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM stage");

            while (rs.next()) {
                stages.add(new stage(
                        rs.getInt("id"),
                        rs.getString("stage_name")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return stages;
    }
}

