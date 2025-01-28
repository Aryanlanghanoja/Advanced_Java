package com.aryanlanghanoja.navigation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Servlet-First")
public class ServletOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Visit(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Visit(req, resp);
    }

    void Visit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        PrintWriter out = resp.getWriter();
        out.println("From Servlet One");
//        resp.sendRedirect("Servlet-Second");
        RequestDispatcher rs = req.getRequestDispatcher("Servlet-Second");
//        rs.forward(req,resp);
        rs.include(req , resp);
        out.println("From Servlet One After Call");
    }
}
