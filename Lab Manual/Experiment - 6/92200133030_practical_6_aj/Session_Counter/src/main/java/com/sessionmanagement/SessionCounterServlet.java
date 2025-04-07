package com.sessionmanagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionCounterServlet")
public class SessionCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(60);
        SessionCounterListener.Counter counter = (SessionCounterListener.Counter) session.getAttribute("counter");

        counter.increment();

        out.println("<html><head><title>Session Counter</title></head><body>");
        out.println("<h2>Session Counter Example</h2>");
        out.println("<p>Total Sessions: " + SessionCounterListener.getActiveSessions() + "</p>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Page Counter for this session: " + counter.getCount() + "</p>");

        out.println("<form action='SessionCounterServlet' method='POST'>");
        out.println("<input type='submit' name='action' value='Add Session'>  ");
        out.println("<input type='submit' name='action' value='Remove Current Session'>");
        out.println("</form>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            if (action.equals("Add Session")) {
                Cookie[] cookies = req.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("JSESSIONID")) {
                        cookie.setMaxAge(0);
                        resp.addCookie(cookie);
                        resp.sendRedirect(req.getContextPath() + "/SessionCounterServlet");
                    }
                }
            } else if (action.equals("Remove Current Session")) {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    session.setMaxInactiveInterval(60);
                    session.invalidate();
                }
                resp.sendRedirect(req.getContextPath() + "/SessionCounterServlet");
                return;
            }
        }

        doGet(req, resp);
    }
}

