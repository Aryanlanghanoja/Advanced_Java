package myweb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ServletConfig config = getServletConfig();
        String pageName = config.getInitParameter("pagename");
        ServletContext context = getServletContext();
        String appName = context.getInitParameter("appname");
        out.print(appName+"<br/>");
        out.print(pageName+"<br/>");
        out.print("<form method='post'>");
        out.print("<input type='text' name='txtUname' placeholder='Enter your name'/><br/>");
        out.print("<input type='password' name='txtPwd' placeholder='Enter your password'/><br/>");
        out.print("<input type='submit' name='btnSubmit' value='Login'/><br/>");
        out.print("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String unm = req.getParameter("txtUname");
        String pwd = req.getParameter("txtPwd");
        if(unm.equals(pwd)){
            HttpSession session = req.getSession();
            session.setAttribute("unm",unm);
            resp.sendRedirect("dashboard");
        }else{
            out.print("Invalid credentials<br/>");
            doGet(req,resp);
        }
    }
}