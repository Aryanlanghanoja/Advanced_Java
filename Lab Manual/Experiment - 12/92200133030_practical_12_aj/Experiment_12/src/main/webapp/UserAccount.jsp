<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Account</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #74EBD5, #ACB6E5);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: #ffffff;
            width: 90%;
            max-width: 500px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            padding: 40px;
            text-align: center;
            transition: 0.3s ease;
        }

        .container:hover {
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.3);
        }

        h1 {
            font-size: 28px;
            color: #333;
            font-weight: 800;
            margin-bottom: 20px;
        }

        h1 {
            font-size: 20px;
            color: #333;
            font-weight: 400;
            margin-bottom: 20px;
        }

        .logout-link {
            margin-top: 20px;
            padding: 12px 20px;
            background-color: #4CAF50;
            border: none;
            border-radius: 8px;
            color: white;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            transition: 0.3s;
            text-decoration: none;
            display: inline-block;
        }

        .logout-link:hover {
            background-color: #45a049;
        }

        @media (max-width: 768px) {
            .container {
                width: 95%;
                padding: 25px;
            }
        }
    </style>
</head>
<body>
    <%
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
    %>
    <div class="container">
        <h1>Welcome, <%= session.getAttribute("username") %>!</h1>
        <p>Last Login Time is , <%= session.getAttribute("lastlogintime") %></p>
        <a href="logout.jsp" class="logout-link">Logout</a>
    </div>
</body>
</html>
