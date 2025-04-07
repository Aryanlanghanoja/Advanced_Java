<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>

<form method="post">
    <input type="date" name="txtDate">
    <input type="submit" value="Submit" name="btnSubmit">
</form>

<%
    if(request.getParameter("btnSubmit") != null) {
        String date = request.getParameter("txtDate");  // Get user input
        int birthyear = Integer.parseInt(date.substring(0, 4)); // Extract year from date

        // Get the current year correctly
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String currentYearStr = sdf.format(new Date()); // Format current date as string
        int curryear = Integer.parseInt(currentYearStr); // Convert to integer

        // Display the calculated age
        out.println("Your age is: " + (curryear - birthyear));
    }
%>
