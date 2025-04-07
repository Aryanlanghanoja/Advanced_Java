package com.aryanlanghanoja.blog_crud.view;

import com.aryanlanghanoja.blog_crud.DAO.BlogDAO;
import com.aryanlanghanoja.blog_crud.model.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addBlog")
public class AddBlogServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String username = request.getParameter("username");

        Blog blog = new Blog(0, title, content, username, null);

        BlogDAO blogDAO = new BlogDAO();

        try {
            blogDAO.addBlog(blog);
            response.sendRedirect("view_blogs.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to add blog.");
        }
    }
}

