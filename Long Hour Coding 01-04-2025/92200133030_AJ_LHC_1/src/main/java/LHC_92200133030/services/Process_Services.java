package LHC_92200133030.services;

//import LHC_92200133030.models.batch;
//import LHC_92200133030.models.category;
import LHC_92200133030.models.process;
import LHC_92200133030.utils.DBConnection;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Process_Services {
    public void addProcess(@NotNull process process_obj) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String insertQuery = "INSERT INTO process (name) VALUES ('" +
                    process_obj.getProcess_name() + "')";
            stmt.executeUpdate(insertQuery);
            System.out.println("Process added successfully!");

        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    // Get All Blogs
    public List<process> getAllProcess() throws SQLException {
        List<process> categories = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM process");

            while (rs.next()) {
                categories.add(new process(
                        rs.getString("name")
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
