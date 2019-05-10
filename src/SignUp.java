import java.io.IOException;
import java.sql.SQLException;

public class SignUp extends javax.servlet.http.HttpServlet {


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().println(request.getParameter("email"));
        response.getWriter().println(request.getParameter("psw"));
        response.getWriter().println(request.getParameter("psw-repeat"));


        User newUser = new User(request.getParameter("email"), request.getParameter("psw"));

        response.getWriter().println(newUser.getEmail() + "din di post");

        response.getWriter().println(request.getParameter("Am ajuns aici"));
        try {
            newUser.addToDataBase();
        } catch (
    SQLException e) {
           e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    public static void main(String[] args) {


    }
}
