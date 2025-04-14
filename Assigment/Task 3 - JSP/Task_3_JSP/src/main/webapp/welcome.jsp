<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
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
            max-width: 600px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            padding: 40px;
            text-align: center;
            transition: 0.3s ease;
        }

        .container:hover {
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.3);
        }

        h2 {
            font-size: 30px;
            color: #333;
            font-weight: 600;
        }

        p {
            font-size: 18px;
            color: #555;
            margin-top: 15px;
        }

        .logout-btn {
            margin-top: 25px;
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

        .logout-btn:hover {
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
    <div class="container">
        <%
            String logout = request.getParameter("logout");
            if (logout != null) {
                request.getRequestDispatcher("logout.jsp").forward(request, response);
            }

            Cookie[] cookies = request.getCookies();
            String username = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        username = cookie.getValue();
                        break;
                    }
                }
            }

            if (username == null) {
                response.sendRedirect("login.jsp");
            }
        %>

        <h2>Welcome, <%= (username != null) ? username : "Guest" %>!</h2>
        <p>You have successfully logged in to the system.</p>

        <form method="post" action="welcome.jsp">
            <input type="submit" name="logout" value="Logout" class="logout-btn">
        </form>
    </div>
</body>
</html>
