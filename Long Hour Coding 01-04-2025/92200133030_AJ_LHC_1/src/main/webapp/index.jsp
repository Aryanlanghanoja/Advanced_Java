<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Managemet</title>
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
            text-align: center;
            animation: fadeIn 0.8s ease-in-out;
        }
        h1 {
            color: #4CAF50;
            font-size: 36px;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #555;
            margin-bottom: 30px;
        }
        a {
            display: inline-block;
            text-decoration: none;
            color: #fff;
            background: #4CAF50;
            padding: 12px 30px;
            border-radius: 8px;
            font-size: 16px;
            transition: background 0.3s, transform 0.2s;
        }
        a:hover {
            background: #45a049;
            transform: scale(1.05);
        }
        a:active {
            transform: scale(0.95);
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
            h1 {
                font-size: 28px;
            }
            a {
                padding: 10px 20px;
                font-size: 14px;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Welcome to the Submission of Aryan Langhanoja (92200133030) of Advanced Java Long Hour Coding!</h1>
    <p><b>Q1</b> Create form by which product will be add in different category and at different stage of
        manufacturing.(stages and categories will be dynamic as per company need)</p>
    <a href="Q1.jsp">Go to Q1</a>

    <p><b>Q2</b> ForeachbatchofmanufacturingprocesstherewillbeNprocesses,<br>
    ineachprocesstherewillbemultipleinproductsandoneoutproduct.<br>
    Optionsneededlikeinhouseoroutsource.Vendor/Employeename,<br>
    perunitcost,expectedoutproductcount.Onoutputallowusertoadd<br>
    multiplereceive.Implementthisformtoperformoperation.</p>
    <a href="Q2.jsp">Go to Q2</a>

    <p><b>Q5</b>Generatebatchwisecostreport,indetailprocesswise.</p>
    <a href="Q5.jsp">Go to Q5</a>
</div>

</body>
</html>
