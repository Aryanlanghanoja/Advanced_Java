package com.aryanlanghanoja.myservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns =  "/Servlet_Three")
public class Servlet_Three extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init Method from Servlet 3 Called");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig Method from Servlet 3 Called");
        return null;
    }

//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("service Method from Servlet 3 Called");
//        PrintWriter out = servletResponse.getWriter();
//        out.println("From Service from Servlet 3 Called");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet Method from Servlet 3 Called");
        PrintWriter out = resp.getWriter();
        out.println("From doGet from Servlet 3 Called");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo Method from Servlet 3 Called");
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("destroy Method  from Servlet 3 Called Servlet_Three");
    }
}
