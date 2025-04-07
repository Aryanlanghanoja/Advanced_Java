package LHC_92200133030.controller;

import LHC_92200133030.models.batch;
import LHC_92200133030.services.Batch_Services;
import LHC_92200133030.services.Product_Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Add_Batch")
public class AddBatch  extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int no_of_product = Integer.parseInt(request.getParameter("no_of_product"));
        String product = request.getParameter("product");

        batch b = new batch(1, product , no_of_product);

        Batch_Services bs = new Batch_Services();

        try {
            bs.addBatch(b);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Failed to add batch.");
        }
    }
}
