<%@ page import="java.util.List" %>
<%@ page import="LHC_92200133030.models.product" %>
<%@ page import="LHC_92200133030.services.Product_Services" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Blogs</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            width: 80%;
            background: #fff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        .message {
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
        }

        .success {
            background: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }

        .error {
            background: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            font-size: 16px;
        }

        table th, table td {
            padding: 15px;
            border: 1px solid #ccc;
            text-align: center;
        }

        table th {
            background: #007bff;
            color: #fff;
        }

        table tr:hover {
            background: #f1f1f1;
        }

        .button-container {
            margin-top: 20px;
        }

        .add-btn {
            display: inline-block;
            text-decoration: none;
            color: white;
            padding: 12px 20px;
            background: #28a745;
            border-radius: 8px;
            font-size: 16px;
            transition: background 0.3s, transform 0.2s;
        }

        .add-btn:hover {
            background: #218838;
            transform: scale(1.05);
        }

        .add-btn:active {
            transform: scale(0.95);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>All Products</h1>

        <% String message = request.getParameter("message"); %>
        <% String error = request.getParameter("error"); %>

        <% if (message != null) { %>
            <div class="message success"><%= message %></div>
        <% } %>

        <% if (error != null) { %>
            <div class="message error"><%= error %></div>
        <% } %>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                </tr>
            </thead>
            <tbody>
                <% Product_Services ps = new Product_Services();
                   List<product> products = ps.getAllProducts();
                   for (product p : products) { %>
                <tr>
                    <td><%= p.getProduct_name() %></td>
                    <td><%= p.getCategory() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <div class="button-container">
            <a href="add_product.jsp" class="add-btn">Add New Product</a>
        </div>
    </div>
</body>
</html>
