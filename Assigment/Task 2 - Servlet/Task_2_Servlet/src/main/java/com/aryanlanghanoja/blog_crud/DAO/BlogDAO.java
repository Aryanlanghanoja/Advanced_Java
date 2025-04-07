package com.aryanlanghanoja.blog_crud.DAO;

import com.aryanlanghanoja.blog_crud.model.Blog;
import com.aryanlanghanoja.blog_crud.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {

    // ✅ Add Blog
    public void addBlog(Blog blog) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            // Check if user exists before adding blog
            String userCheckQuery = "SELECT COUNT(*) FROM users WHERE username = '" + blog.getUsername() + "'";
            ResultSet rs = stmt.executeQuery(userCheckQuery);

            if (rs.next() && rs.getInt(1) > 0) {
                // Insert the blog only if the user exists
                String insertQuery = "INSERT INTO blogs (title, content, username) VALUES ('" +
                        blog.getTitle() + "', '" + blog.getContent() + "', '" + blog.getUsername() + "')";
                stmt.executeUpdate(insertQuery);
                System.out.println("Blog added successfully!");
            } else {
                System.out.println("User does not exist. Cannot add blog.");
            }
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    // ✅ Get All Blogs
    public List<Blog> getAllBlogs() throws SQLException {
        List<Blog> blogs = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM blogs");

            while (rs.next()) {
                blogs.add(new Blog(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("username"),
                        rs.getTimestamp("published_at")
                ));
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
        return blogs;
    }

    // ✅ Update Blog
    public void updateBlog(Blog blog) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            String query = "UPDATE blogs SET title = '" + blog.getTitle() + "', content = '" + blog.getContent() +
                    "' WHERE id = " + blog.getId() + " AND username = '" + blog.getUsername() + "'";

            stmt.executeUpdate(query);
            System.out.println("Blog updated successfully!");
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    // ✅ New: Delete Blog
    public void deleteBlog(int blogId, String username) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();

            // Ensure only the owner of the blog can delete it
            String query = "DELETE FROM blogs WHERE id = " + blogId + " AND username = '" + username + "'";

            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Blog deleted successfully!");
            } else {
                System.out.println("No blog found or you don't have permission to delete it.");
            }
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
}
