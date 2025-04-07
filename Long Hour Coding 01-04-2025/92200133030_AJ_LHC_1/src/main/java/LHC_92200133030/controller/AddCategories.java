package LHC_92200133030.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import LHC_92200133030.models.category;
import LHC_92200133030.services.Category_Services;

@WebServlet("/Add_Category")
public class AddCategories extends  HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        category c = new category(name);

        Category_Services cs = new Category_Services();

        try {
            cs.addCategory(c);
            response.sendRedirect("add_product.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to add category.");
        }
    }

}
