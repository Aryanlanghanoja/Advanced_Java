package com.aryanlanghanoja.blog_crud.view;

import com.aryanlanghanoja.blog_crud.DAO.BlogDAO;
import com.aryanlanghanoja.blog_crud.model.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/viewBlogs")
public class ViewBlogsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BlogDAO blogDAO = new BlogDAO();

        try {
            List<Blog> blogs = blogDAO.getAllBlogs();
            request.setAttribute("blogs", blogs);
            request.getRequestDispatcher("view_blogs.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to load blogs.");
        }
    }
}
