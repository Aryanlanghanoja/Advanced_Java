<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="LHC_92200133030.models.category"%>
<%@ page import="LHC_92200133030.services.Category_Services"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Submit CV</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #74EBD5, #ACB6E5);
            color: #333;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        .container {
            background: #fff;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            border-radius: 12px;
            max-width: 700px;
            width: 100%;
            padding: 40px;
            animation: fadeIn 0.8s ease-in-out;
        }
        h2 {
            text-align: center;
            color: #4CAF50;
            font-size: 32px;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            font-weight: 500;
            color: #555;
        }
        input, select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            transition: border 0.3s;
        }
        input:focus, select:focus {
            border-color: #4CAF50;
            outline: none;
        }
        button {
            background: #4CAF50;
            color: #fff;
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
        }
        button:hover {
            background: #45a049;
            transform: scale(1.05);
        }
        button:active {
            transform: scale(0.95);
        }
        a {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            background:  #4CAF50;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s;
            text-decoration: none;
            text-align: center;
            margin-top: 10px;
        }
        a:hover {
            background: #45a049;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
        @media (max-width: 768px) {
            .container {
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
    <h2>Add the Products</h2>
    <form action="Add_Product" method="POST">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" placeholder="Enter the Product Name" required>

        <label for="cost">Cost:</label>
        <input type="text" name="cost" id="cost" placeholder="Enter the Product Cost" required>

        <label for="category">Category :- </label>
        <select name="category" required>
            <option disabled selected>Select Category</option>
                <%
                    Category_Services cs = new Category_Services() ;
                    List<category> categories = cs.getAllCategory();

                    for (category c  : categories) {
                %>

                <option><%=c.getName() %></option>

                <% } %>
         </select>

        <a href="add_categories.jsp" class="add-btn">+ Add Category</a>
        <button type="submit">Add The Product</button>
    </form>
</div>

</body>
</html>
