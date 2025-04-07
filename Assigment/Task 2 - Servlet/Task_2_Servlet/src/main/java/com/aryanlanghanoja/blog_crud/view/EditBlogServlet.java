package com.aryanlanghanoja.blog_crud.view;

import com.aryanlanghanoja.blog_crud.DAO.BlogDAO;
import com.aryanlanghanoja.blog_crud.model.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editBlog")
public class EditBlogServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String username = request.getParameter("username");

        Blog blog = new Blog(id, title, content, username, null);
        BlogDAO blogDAO = new BlogDAO();

        try {
            blogDAO.updateBlog(blog);
            response.sendRedirect("view_blogs.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to edit blog.");
        }
    }
}

