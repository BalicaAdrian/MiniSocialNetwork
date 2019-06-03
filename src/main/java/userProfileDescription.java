import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userProfileDescription" ,urlPatterns = "/userProfileDescription")
public class userProfileDescription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(request.getParameter("Gender"));
        response.getWriter().println(request.getParameter("Location"));
        response.getWriter().print(request.getParameter("day"));  response.getWriter().print(" ");
        response.getWriter().print(request.getParameter("month")); response.getWriter().print(" ");
        response.getWriter().print(request.getParameter("year")); response.getWriter().print(" ");


        ///GET THE VALUE FROM USER PROFILE DESCRIPTION FOR SIGN UP EMAIL
        response.getWriter().println("email:");
        String email =(String)request.getSession().getAttribute("Email");
        response.getWriter().println(email);

//        String redirectURL ="http://localhost:8080/SignUpForm_war_exploded";
//        response.sendRedirect(redirectURL);

    }
}
