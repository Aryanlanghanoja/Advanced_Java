package Practicle_4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");

        // Use ServletContext for controller
        ServletContext context = getServletContext();
        context.log("Received data: " + name + ", " + email + ", " + phone + ", " + message);
        // Insert data into DB
        DBTransaction.InsertData(name, email, phone, message);

        // Redirect to success page
        response.sendRedirect("success.jsp");
    }
}
