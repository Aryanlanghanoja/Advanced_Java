<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Set session attributes for first and last names.
    session.setAttribute("first_name", request.getParameter("first_name"));
    session.setAttribute("last_name", request.getParameter("last_name"));
%>
<html>
<head>
    <title>Set Session</title>
</head>
<body>
    <h1>Session created successfully</h1>
    <a href="readSession.jsp">Read session</a>
</body>
</html>