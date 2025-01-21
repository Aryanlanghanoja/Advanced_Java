package com.aryanlanghanoja.login;

import com.aryanlanghanoja.connection.MyConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/validate")
public class ValidationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("from doGet");
        validate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("from doPost");
        validate(req, resp);
    }
    
    void validate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //fetch all parameters
        String unm = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        PrintWriter out = resp.getWriter();
        MyConnection connect = MyConnection.getInstante();
        String result = connect.Validate_User(unm , pwd) ;

        if(!result.equals("No User Found")){
            out.print("Welcome "+ result);
        }

        else{
            out.print("Invalid Credentials");
        }
    }
}
