<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GST Calculator</title>
</head>
<body>
    <h2>GST Calculator!</h2>
    <form action="Result.jsp" method="POST">
        <input type="number" name="txtFirstNum" required placeholder="Enter first number" />
        <input type="number" name="txtSecondNum" required placeholder="Enter second number" />

        <select name="operation">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
            <option value="%">%</option>
        </select>

        <input type="submit" value="Calculate" name="btnSubmit" />
    </form>
</body>
</html>
