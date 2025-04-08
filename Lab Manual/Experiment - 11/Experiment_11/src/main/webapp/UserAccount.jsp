<html>
    <head>
        <title>User Account</title>
    </head>
    <body>
    <%
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
    %>
    <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
    <br> <br>
    <a href="logout.jsp">Logout</a>
    </body>
</html>