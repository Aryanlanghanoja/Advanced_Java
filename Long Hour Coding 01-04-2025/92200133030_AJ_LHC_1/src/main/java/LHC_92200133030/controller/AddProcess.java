package LHC_92200133030.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import LHC_92200133030.models.process;
import LHC_92200133030.services.Process_Services;

@WebServlet("/Add_Process")
public class AddProcess  extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        process p = new process(name);

        Process_Services ps = new Process_Services();

        try {
            ps.addProcess(p);
            response.sendRedirect("add_batch.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to add process.");
        }
    }
}
