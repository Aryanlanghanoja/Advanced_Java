package LHC_92200133030.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import LHC_92200133030.models.product;
import LHC_92200133030.services.Product_Services;

@WebServlet("/Add_Product")
public class AddProduct extends  HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        int cost = Integer.parseInt(request.getParameter("cost"));

        product p = new product(name,category,cost);

        Product_Services ps = new Product_Services();

        try {
            ps.addProduct(p);
            response.sendRedirect("view_products.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to add product.");
        }
    }

}
