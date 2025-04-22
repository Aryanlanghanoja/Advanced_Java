package Practicle_5;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    // Handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Retrieve form data
            String username = request.getParameter("username");
            String email = request.getParameter("email");

            // Validate form data
            if (username == null || username.trim().isEmpty() || email == null || email.trim().isEmpty()) {
                out.println("<html><head><title>Error</title>");
                out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap' rel='stylesheet'>");
                out.println("<style>");
                out.println("body { font-family: 'Poppins', sans-serif; background: #ffdddd; padding: 40px; text-align: center; }");
                out.println("h2 { color: #e74c3c; }");
                out.println("p { font-size: 18px; }");
                out.println("a { text-decoration: none; color: #3498db; font-size: 16px; }");
                out.println("</style></head>");
                out.println("<body>");
                out.println("<h2>Error: Both username and email are required!</h2>");
                out.println("<a href='user.html'>Go Back</a>");
                out.println("</body></html>");
                return;
            }

            // Display user information with consistent theme
            out.println("<html><head><title>User Info</title>");
            out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap' rel='stylesheet'>");
            out.println("<style>");
            out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(to right, #4facfe, #00f2fe); color: #333; min-height: 100vh; display: flex; justify-content: center; align-items: center; }");
            out.println(".container { background: #fff; padding: 40px; border-radius: 12px; box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1); width: 450px; text-align: center; }");
            out.println("h2 { font-size: 28px; color: #2c3e50; }");
            out.println("p { font-size: 18px; line-height: 1.6; color: #555; }");
            out.println("a { display: inline-block; margin-top: 20px; text-decoration: none; color: #3498db; font-weight: 500; transition: 0.3s; }");
            out.println("a:hover { color: #2980b9; }");
            out.println("</style></head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>User Information</h2>");
            out.println("<p><strong>Username:</strong> " + username + "</p>");
            out.println("<p><strong>Email ID:</strong> " + email + "</p>");
            out.println("<p style='color: green;'>Data submitted successfully!</p>");
            out.println("<a href='user.html'>Go Back</a>");
            out.println("</div>");
            out.println("</body></html>");

        } catch (Exception e) {
            // Handle exceptions gracefully
            out.println("<html><head><title>Error</title>");
            out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap' rel='stylesheet'>");
            out.println("<style>");
            out.println("body { font-family: 'Poppins', sans-serif; background: #ffdddd; padding: 40px; text-align: center; }");
            out.println("h2 { color: #e74c3c; }");
            out.println("p { font-size: 18px; }");
            out.println("a { text-decoration: none; color: #3498db; font-size: 16px; }");
            out.println("</style></head>");
            out.println("<body>");
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            out.println("<a href='user.html'>Go Back</a>");
            out.println("</body></html>");
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
