package LHC_92200133030.controller;

import LHC_92200133030.models.input_product;
import LHC_92200133030.services.Input_Product_Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/Add_Input_Products")
public class AddInputProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int cost = Integer.parseInt(request.getParameter("cost"));

        input_product ip = new input_product(name , cost);

        Input_Product_Services ips = new Input_Product_Services();

        try {
            ips.add_input_product(ip);
            response.sendRedirect("add_process.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to add input product.");
        }
    }
}
