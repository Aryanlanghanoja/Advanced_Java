package com.aryanlanghanoja.myservlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns =  "/Servlet_One")
public class Servlet_One implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init Method Called");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig Method Called");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service Method Called");
        PrintWriter out = servletResponse.getWriter();
        out.println("From Service Called");

    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo Method Called");
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("destroy Method Called");
    }
}
