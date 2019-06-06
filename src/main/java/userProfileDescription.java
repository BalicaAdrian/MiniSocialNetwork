import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;



@WebServlet(name = "userProfileDescription" ,urlPatterns = "/userProfileDescription")
public class userProfileDescription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         TEST IF THE VALUE OF PARAMETERS WORKS
//        response.getWriter().println(request.getParameter("Gender"));
//        response.getWriter().println(request.getParameter("Location"));
//        response.getWriter().print(request.getParameter("day"));  response.getWriter().print(" ");
//        response.getWriter().print(request.getParameter("month")); response.getWriter().print(" ");
//        response.getWriter().print(request.getParameter("year")); response.getWriter().print(" ");


        ///GET THE VALUE FROM USER PROFILE DESCRIPTION FOR SIGN UP EMAIL
//        response.getWriter().println("email:");
//        String email =(String)request.getSession().getAttribute("Email");
//        response.getWriter().println(email);
//
//        response.getWriter().print( "nume: ");
//        response.getWriter().println((String)request.getSession().getAttribute("userName"));
//
//        response.getWriter().print( "prenume: ");
//        response.getWriter().println((String)request.getSession().getAttribute("userSurname"));

        /// SET THE VALUE TO UPDATE A USER SPECIFICATION

        //String name=(String)request.getSession().getAttribute("userName");
        //String surname=(String)request.getSession().getAttribute("userSurname");
        String gender=request.getParameter("Gender");
        String dateofbirth=request.getParameter("day")+"-"+request.getParameter("month")+"-"+request.getParameter("year");
        String location=request.getParameter("Location");
        String description=request.getParameter("comment");
        int id=(Integer)request.getSession().getAttribute("ID");


       // response.getWriter().println(id);

        try {
            userProfile.updateDataProfile(gender,dateofbirth,location,description, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }



        // userProfile newUser= new userProfile(name,surname,gender,dateofbirth,location,description);

        String redirectURL ="http://localhost:8080/SignUpForm_war_exploded";
        //response.sendRedirect("redirectURL");

    }
}
