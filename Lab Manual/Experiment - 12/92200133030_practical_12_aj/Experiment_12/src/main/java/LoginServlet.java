import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username =? AND password =?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                // Get current timestamp
                LocalDateTime now = LocalDateTime.now();
                // Optional: format the timestamp
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedNow = now.format(formatter);

                session.setAttribute("lastlogintime", formattedNow);
                response.sendRedirect("UserAccount.jsp");
            } else {
                request.setAttribute("message", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request,
                        response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}