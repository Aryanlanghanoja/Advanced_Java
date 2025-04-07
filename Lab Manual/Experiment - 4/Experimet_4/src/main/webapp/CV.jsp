<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        input, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            transition: border 0.3s;
        }
        input:focus, textarea:focus {
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
    <h2>Submit Your CV</h2>
    <form action="ConServlet" method="POST">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" placeholder="Enter your full name" required>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" placeholder="Enter your email address" required>

        <label for="phone">Phone:</label>
        <input type="text" name="phone" id="phone" placeholder="Enter your phone number" required>

        <label for="message">Message:</label>
        <textarea name="message" id="message" rows="4" placeholder="Write your message here..." required></textarea>

        <button type="submit">Submit CV</button>
    </form>
</div>

</body>
</html>
