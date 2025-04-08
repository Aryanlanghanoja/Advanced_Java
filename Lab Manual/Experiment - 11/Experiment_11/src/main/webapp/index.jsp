<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    if (request.getAttribute("message") != null) {
        out.println("<p>" + request.getAttribute("message") + "</p><br><br>");
    }
%>
<form action="LoginServlet" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>