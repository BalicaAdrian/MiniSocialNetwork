import java.io.IOException;
import java.sql.SQLException;


public class SignUp extends javax.servlet.http.HttpServlet {


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.getWriter().println(request.getParameter("email"));
//        response.getWriter().println(request.getParameter("psw"));
//        response.getWriter().println(request.getParameter("psw-repeat"));


       // response.getWriter().println(request.getParameter("Am ajuns aici"));


      String gasit=null;
        try {
           gasit=User.findByEmail(request.getParameter("email"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(gasit.equals("true")){
            response.getWriter().println("Emailul EXISTA!");
            String redirectURL ="http://localhost:8080/SignUpForm_war_exploded/SignUp?error=User already exist!";
            response.sendRedirect(redirectURL);
        }
        else {
            try {
                User newUser = new User(request.getParameter("email"), request.getParameter("psw"),User.getUniqueId()+1);
                newUser.addToDataBase();

                userProfile newUserProfile= new userProfile(newUser);
                newUserProfile.createProfileUserInDataBase(request.getParameter("userName"),request.getParameter("userSurname"));

                ///SEND PARAMETER TO USERPROFILE DESCRIPTION + REDIRECT

                request.setAttribute("idOfPerson", newUser.getId());
                String name = request.getParameter("userName");
                request.setAttribute("userName", name);
                String surname = request.getParameter("userSurname");
                request.setAttribute("userSurname", surname);
                request.setAttribute("email", request.getParameter("email"));

                request.getRequestDispatcher("UserProfileDescription.jsp").forward(request, response);

              // String redirectURL ="http://localhost:8080/SignUpForm_war_exploded/UserProfileDescription";
              //  response.sendRedirect(redirectURL);
                } catch (
                   SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
