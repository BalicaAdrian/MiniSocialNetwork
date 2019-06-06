import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

                    ///IF IT IS TRUE PASS TO THE LOGIN PAGE
                    request.setAttribute("emailLogin", email);

                    Connection myCon = ConnectionToDataBase.getConnection();
                    PreparedStatement prepstm = myCon.prepareStatement("SELECT user_id FROM  MiniSocialNetDB.USER WHERE EMAIL LIKE ?");
                    prepstm.setString(1, email);
                    ResultSet resSet = prepstm.executeQuery();

                    resSet.next();
                    int userId = resSet.getInt("user_id");

                    prepstm = myCon.prepareStatement("SELECT * FROM  MiniSocialNetDB.USER_PROFILE WHERE user_id = ?");
                    prepstm.setInt(1, userId);
                    resSet = prepstm.executeQuery();

                    userProfile newUserProfile = null;

                    while (resSet.next()) {
                            userId = resSet.getInt("user_id");
                            String name = resSet.getString("name");
                            String surname = resSet.getString("surname");
                            String birthDate = resSet.getString("date_of_birth");
                            String location = resSet.getString("location");
                            String gender = resSet.getString("gender");
                            String description = resSet.getString("description");
                            userProfile temp = new userProfile(userId, name, surname, gender, birthDate, location, description);
                            newUserProfile = userProfile.copyUser(temp);
                    }

                    request.setAttribute("userProfile", newUserProfile);
                    //request.setAttribute("password", password);
                    request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
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
