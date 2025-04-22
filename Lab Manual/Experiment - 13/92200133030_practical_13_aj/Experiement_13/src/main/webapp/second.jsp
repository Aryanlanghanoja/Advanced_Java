<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String firstName = (String) request.getParameter("firstName");
    String lastName = (String) request.getParameter("lastName");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Forwarded Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <style>
        /* Reset and base styling */
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
            padding: 30px;
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

        @media (max-width: 768px) {
            .container {
                width: 95%;
                padding: 20px;
            }

            h2 {
                font-size: 24px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Hello, <%= firstName %> <%= lastName %>! You have been forwarded to this page.</h2>
    </div>
</body>
</html>
