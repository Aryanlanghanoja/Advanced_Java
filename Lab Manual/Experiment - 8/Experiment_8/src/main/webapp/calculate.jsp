<%@ page import="java.io.*, java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Method declarations should be inside declaration tag --%>
<%!
    String compare(int a, int b) {
        if (a > b) {
            return "Number 1 is greater than Number 2";
        } else if (a < b) {
            return "Number 1 is less than Number 2";
        } else {
            return "Number 1 is equal to Number 2";
        }
    }
%>

<%
    String num1Str = request.getParameter("num1");
    String num2Str = request.getParameter("num2");

    int num1 = Integer.parseInt(num1Str);
    int num2 = Integer.parseInt(num2Str);

    String comparisonResult = compare(num1, num2);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Experiment - 8 Result</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
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
            margin-bottom: 20px;
            font-weight: 600;
        }

        .result {
            margin-top: 20px;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            background: #f4f4f4;
            transition: 0.3s ease;
        }

        .result:hover {
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
        }

        .result h3 {
            color: #333;
            font-size: 24px;
            margin-bottom: 10px;
            font-weight: 500;
        }

        .result p {
            font-size: 20px;
            color: #007BFF;
            font-weight: 400;
        }

        @media (max-width: 768px) {
            .container {
                width: 95%;
                padding: 20px;
            }
        }
    </style>
</head>

<body>
<div class="container">
    <h2>Calculation Result</h2>
    <div class="result">
        <h3><b>Comparison Outcome</b></h3>
        <p>Number - 1 : <strong><%= num1 %></strong></p>
        <p>Number - 2 : <strong><%= num2 %></strong></p>
        <p>Result: <strong><%= comparisonResult %></strong></p>
    </div>
</div>
</body>
</html>
