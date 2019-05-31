import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginPage")
public class loginPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(request.getParameter("email"));
        response.getWriter().println(request.getParameter("psw"));



        //transmitere parametru catre jsp Profile
        String email = request.getParameter("email");
        String password=request.getParameter("psw");


       // request.setAttribute("emailLogin", email);

        // request.getRequestDispatcher("Profile.jsp").forward(request, response);

        //the existence email checked
        String checkedLoginEmail=null;

        try {
            checkedLoginEmail=User.findByEmail(request.getParameter("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(checkedLoginEmail.equals("true")){
            try {
                if((User.getPasswordFromMail(email).equals(password))){
                    //String redirectURL ="http://localhost:8080/SignUpForm_war_exploded/Profile";
                    //response.sendRedirect(redirectURL);
                    request.setAttribute("emailLogin", email);
                    request.setAttribute("password", password);
                    request.getRequestDispatcher("Profile.jsp").forward(request, response);
                }
                else{
                    String redirectURL ="http://localhost:8080/SignUpForm_war_exploded/LoginPage?error=Email or password incorrect";
                    response.sendRedirect(redirectURL);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else {
            String redirectURL ="http://localhost:8080/SignUpForm_war_exploded/LoginPage?error=Email or password incorrect";
            response.sendRedirect(redirectURL);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
