<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Cookie</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(to right, #6dd5fa, #2980b9);
            height: 100vh;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .container {
            background-color: #fff;
            padding: 35px 30px;
            border-radius: 15px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        h2 {
            color: #27ae60;
            margin-bottom: 15px;
        }

        p {
            font-size: 17px;
            color: #333;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            border-radius: 8px;
            transition: background 0.3s ease;
        }

        a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Cookie Value</h2>
        <%
            Cookie[] cookies = request.getCookies();
            String userName = null;
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")) {
                        userName = c.getValue();
                        break;
                    }
                }
            }

            if (userName != null) {
        %>
            <p>Welcome back, <strong><%= userName %></strong>!</p>
        <% } else { %>
            <p>No cookie found. Please <a href="createCookie.jsp">create one</a>.</p>
        <% } %>
        <a href="createCookie.jsp">Back to Create</a>
    </div>
</body>
</html>
