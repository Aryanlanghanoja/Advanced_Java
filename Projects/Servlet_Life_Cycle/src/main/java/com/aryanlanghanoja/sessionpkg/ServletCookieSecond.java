package com.aryanlanghanoja.sessionpkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SCSecond")
public class ServletCookieSecond  extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String val = req.getParameter("txtData");
        out.println("Value Passsed :- " + val);
        Cookie cookie = new Cookie("Data" , val);
        resp.addCookie(cookie);
    }
}
