<%@ page import="javax.servlet.http.Cookie" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
    String username = request.getParameter("username");
    if(username != null && !username.trim().isEmpty()) {
        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(userCookie);
    }
    response.sendRedirect("viewCookie.jsp");
%>
