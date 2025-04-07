package com.aryanlanghanoja.sessionpkg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SCThird")
public class ServletCookieThird extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            out.println("Cookie Details:");
            out.println("--------------------");
            out.println("Name      : " + cookies[i].getName());
            out.println("Value     : " + cookies[i].getValue());
            out.println("Domain    : " + cookies[i].getDomain());
            out.println("Path      : " + cookies[i].getPath());
            out.println("Max Age   : " + cookies[i].getMaxAge());
            out.println("Secure    : " + cookies[i].getSecure());
            out.println("Version   : " + cookies[i].getVersion());
            out.println("Comment   : " + cookies[i].getComment());
            out.println();
        }

    }
}
