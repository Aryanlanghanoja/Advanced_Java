package myweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("unm","");
        session.setMaxInactiveInterval(0);
        session.invalidate();
//        resp.setIntHeader("refresh",5);
        resp.sendRedirect("login");

    }
}