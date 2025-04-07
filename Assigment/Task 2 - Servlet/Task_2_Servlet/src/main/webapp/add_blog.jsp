<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Blog</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="container">
    <h1>Add New Blog</h1>

    <form action="add-blog" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="content">Content:</label>
        <textarea id="content" name="content" rows="5" required></textarea>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <button type="submit">Add Blog</button>
    </form>

    <a href="view_blogs.jsp" class="add-btn">Back to Blogs</a>
</div>

</body>
</html>
