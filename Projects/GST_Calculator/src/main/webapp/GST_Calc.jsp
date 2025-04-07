<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GST Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
        }
        .container {
            background: white;
            padding: 70px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
            text-align: left;
            margin: 50px;
        }
        h1 {
            color: #333;
        }
        label {
            font-weight: bold;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 5px 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[readonly] {
            background: #eee;
        }
        input[type="submit"] {
            width: 100%;
            background: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <h1>GST Calculator</h1>
    <div class="container">
        <%
            double amnt = 0, gstPer = 0;
            double igst = 0, sgst = 0, cgst = 0, total = 0;

            String btnCalc = request.getParameter("btnCalc");
            if (btnCalc != null) {
                try {
                    amnt = Double.parseDouble(request.getParameter("txtAmt"));
                    gstPer = Double.parseDouble(request.getParameter("txtGstPer"));

                    igst = (amnt * gstPer) / 100;
                    sgst = igst / 2;
                    cgst = igst / 2;
                    total = amnt + igst;
                } catch (Exception e) {
                    out.println("<p style='color:red;'>Invalid input. Please enter valid numbers.</p>");
                }
            }
        %>

        <form method="post">
            <label>Enter Amount:</label>
            <input type="number" name="txtAmt" placeholder="Enter Amount" required /><br/>

            <label>Enter GST %:</label>
            <input type="number" name="txtGstPer" placeholder="Enter GST %" required /><br/>

            <label>IGST:</label>
            <input type="number" name="txtIGST" value="<%= igst %>" readonly /><br/>

            <label>SGST:</label>
            <input type="number" name="txtSGST" value="<%= sgst %>" readonly /><br/>

            <label>CGST:</label>
            <input type="number" name="txtCGST" value="<%= cgst %>" readonly /><br/>

            <label>Total Amount:</label>
            <input type="number" name="txtTotal" value="<%= total %>" readonly /><br/>

            <input type="submit" name="btnCalc" value="Calculate" />
        </form>
    </div>
</body>
</html>
