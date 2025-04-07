package com.aryanlanghanoja.blog_crud.view;

import com.aryanlanghanoja.blog_crud.DAO.BlogDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-blog")
public class DeleteBlogServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int blogId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");

        BlogDAO blogDAO = new BlogDAO();
        try {
            blogDAO.deleteBlog(blogId, username);
            // Redirect to view-blogs.jsp with a success message
            response.sendRedirect("view_blogs.jsp?message=Blog%20deleted%20successfully");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("view_blogs.jsp?error=Failed%20to%20delete%20blog");
        }
    }
}
