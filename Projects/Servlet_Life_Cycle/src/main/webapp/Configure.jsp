<form>
<input type="text" name="txtName" placeholder="Enter any number"/>
<input type="submit" name="btnSubmit" value="Generate"/>
</form>

<%
    if(request.getParameter("btnSubmit")) {
        String name = request.getParameter("txtName");
        application.setAttribute("app_name" , name);
    }

%>