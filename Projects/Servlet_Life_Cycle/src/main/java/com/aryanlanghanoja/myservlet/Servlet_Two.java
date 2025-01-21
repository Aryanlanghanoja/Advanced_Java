package com.aryanlanghanoja.myservlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns =  "/Servlet_Two")
public class Servlet_Two extends GenericServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init Method from Servlet 2 Called");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig Method from Servlet 2 Called");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service Method from Servlet 2 Called");
        PrintWriter out = servletResponse.getWriter();
        out.println("From Service from Servlet 2 Called");

    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo Method from Servlet 2 Called");
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("destroy Method  from Servlet 2 Called");
    }
}
