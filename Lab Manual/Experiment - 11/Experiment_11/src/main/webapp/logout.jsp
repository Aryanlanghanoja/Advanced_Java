<html>
<head>
    <title>Logout</title>
</head>
    <body>
    <%
        session.invalidate();
        response.sendRedirect("index.jsp");
    %>
        <h1>Logout Successful.</h1>
        <br> <br>
        <a href="index.jsp">Login</a>
    </body>
</html>