<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Arithmetic Operations</title>

    <!-- Import Poppins Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <style>
        /* General Styling */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif; /* Applying Poppins font */
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

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: 500;
            color: #555;
            text-align: left;
            font-size: 16px;
        }

        input, select, button {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 16px;
            transition: 0.3s;
            font-family: 'Poppins', sans-serif;  /* Poppins for form elements */
        }

        input:focus, select:focus {
            outline: none;
            border-color: #4CAF50;
            box-shadow: 0 0 8px #4CAF50;
        }

        button {
            background: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 18px;
            font-weight: 500;
            transition: 0.3s;
        }

        button:hover {
            background: #45a049;
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

        .error {
            color: red;
            font-weight: bold;
        }

        /* Responsive Styling */
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
    <h2>Arithmetic Operations</h2>

    <!-- Form for arithmetic operations -->
    <form method="post" action="index.jsp">
        <label>Enter First Number:</label>
        <input type="number" name="num1" required>

        <label>Enter Second Number:</label>
        <input type="number" name="num2" required>

        <label>Select Operation:</label>
        <select name="operation">
            <option value="add">Addition (+)</option>
            <option value="subtract">Subtraction (-)</option>
            <option value="multiply">Multiplication (*)</option>
            <option value="divide">Division (/)</option>
        </select>

        <button type="submit">Calculate</button>
    </form>

    <%
        // Handling form submission
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operation = request.getParameter("operation");

        if (num1Str != null && num2Str != null && operation != null) {
            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;
                String message = "";

                switch (operation) {
                    case "add":
                        result = num1 + num2;
                        message = "Addition";
                        break;
                    case "subtract":
                        result = num1 - num2;
                        message = "Subtraction";
                        break;
                    case "multiply":
                        result = num1 * num2;
                        message = "Multiplication";
                        break;
                    case "divide":
                        if (num2 != 0) {
                            result = num1 / num2;
                            message = "Division";
                        } else {
                            message = "Division by zero is not allowed!";
                        }
                        break;
                    default:
                        message = "Invalid Operation";
                }
    %>
        <div class="result">
            <h3>Operation: <%= message %></h3>
            <p>Result: <strong><%= result %></strong></p>
        </div>
    <%
            } catch (NumberFormatException e) {
    %>
        <div class="result error">
            <p>Invalid input. Please enter valid numbers.</p>
        </div>
    <%
            }
        }
    %>
</div>

</body>
</html>
