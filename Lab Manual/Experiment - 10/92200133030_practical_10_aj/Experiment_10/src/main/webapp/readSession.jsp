<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read Session</title>
</head>
<body>
<%
    // Retrieve session attributes for first and last names.
    String firstName = (String) session.getAttribute("first_name");
    String lastName = (String) session.getAttribute("last_name");

    // Check if session attributes are not null.
    if (firstName != null && lastName != null) {
        out.println("First Name: " + firstName + "<br/>");
        out.println("Last Name: " + lastName + "<br/>");
    } else {
        out.println("<h2>No session data found</h2>");
    }
%>
</body>
</html>
