<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Blog</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Edit Blog</h1>
        <form action="EditBlogServlet" method="POST">
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="<%= request.getParameter("title") %>"required>

            <label for="content">Content:</label>
            <textarea id="content" name="content" value="<%= request.getParameter("content") %>" required></textarea>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%= request.getParameter("username") %>" required>

            <button type="submit">Update</button>
        </form>
        <a href="view_blogs.jsp">Back to Blogs</a>
    </div>
</body>
</html>
