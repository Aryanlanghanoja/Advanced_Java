package com.allysoftsolutions.extra;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/mycalc")
public class MyCalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<form method='post'>");
        out.println("<input type='number' placeholder='Enter first number' name='numO'/><br/>");
        out.println("<input type='number' placeholder='Enter second number' name='numT'/><br/>");
        out.println("<select name='operation'><option value='+'>+</option><option value='-'>-</option><option value='*'>*</option><option value='/'>/</option><option value='%'>%</option></select><br/>");
        out.println("<input type='submit' value='Calculate' name='btnCalc'/>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        doGet(req,resp);
        PrintWriter out = resp.getWriter();
        int numF = Integer.parseInt(req.getParameter("numO"));
        int numS = Integer.parseInt(req.getParameter("numT"));
        String op = req.getParameter("operation");
        switch(op){
            case "+":out.println("sum = "+(numF+numS));break;
            case "-":out.println("sub = "+(numF-numS));break;
            case "*":out.println("mul = "+(numF*numS));break;
            case "/":out.println("div = "+(numF/numS));break;
            case "%":out.println("mod = "+(numF%numS));break;
            default: out.println("Invalid operation");break;
        }
    }
}
