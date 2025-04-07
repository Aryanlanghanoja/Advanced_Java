<%@ page import="java.util.List" %>
<%@ page import="com.aryanlanghanoja.blog_crud.model.Blog" %>
<%@ page import="com.aryanlanghanoja.blog_crud.DAO.BlogDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View Blogs</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="container">
    <h1>All Blogs</h1>

    <!-- Display Messages -->
    <%
        String message = request.getParameter("message");
        String error = request.getParameter("error");
    %>

    <% if (message != null) { %>
        <div class="message success"><%= message %></div>
    <% } %>

    <% if (error != null) { %>
        <div class="message error"><%= error %></div>
    <% } %>

    <!-- Blog Table -->
    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Content</th>
            <th>Author</th>
            <th>Published At</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            BlogDAO blogDAO = new BlogDAO();
            List<Blog> blogs = blogDAO.getAllBlogs();

            for (Blog blog : blogs) {
        %>
        <tr>
            <td><%= blog.getTitle() %></td>
            <td><%= blog.getContent() %></td>
            <td><%= blog.getUsername() %></td>
            <td><%= blog.getPublishedAt() %></td>
            <td>
                <div class="button-container">
                    <a href="edit-blog.jsp?id=<%= blog.getId() %>" class="edit-btn">Edit</a>
                    <a href="delete-blog?id=<%= blog.getId() %>&username=<%= blog.getUsername() %>"
                       class="delete-btn"
                       onclick="return confirm('Are you sure you want to delete this blog?')">Delete</a>
                </div>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <div class="button-container">
        <a href="add-blog.jsp" class="add-btn">Add New Blog</a>
    </div>
</div>

</body>
</html>
