package com.LoginAndSignUp;

import com.ConnectionDatabase.ConnectionToDataBase;

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


        //request parameter from com.LoginAndSignUp.loginPage.jsp
        String email = request.getParameter("email");
        String password = request.getParameter("psw");

        //the existence of email is checked
        String checkedLoginEmail = null;

        try {
            checkedLoginEmail= User.findByEmail(request.getParameter("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(checkedLoginEmail.equals("true")){
            try {
                if((User.getPasswordFromMail(email).equals(password))){

                    //if it is true pass to the profilePage.jsp
                    request.setAttribute("email", email);

                    //requesting the unique id paired with the email
                    Connection myCon = ConnectionToDataBase.getConnection();
                    PreparedStatement prepstm = myCon.prepareStatement("SELECT user_id FROM  MiniSocialNetDB.USER WHERE EMAIL LIKE ?");
                    prepstm.setString(1, email);
                    ResultSet resSet = prepstm.executeQuery();

                    resSet.next();
                    int userId = resSet.getInt("user_id");

                    //requesting all the data from the user_profile table
                    prepstm = myCon.prepareStatement("SELECT * FROM  MiniSocialNetDB.USER_PROFILE WHERE user_id = ?");
                    prepstm.setInt(1, userId);
                    resSet = prepstm.executeQuery();

                    //creating and sending the com.LoginAndSignUp.userProfile object to the com.LoginAndSignUp.ProfilePage.jsp
                    userProfile newUserProfile = null;

                    while (resSet.next()) {
                            userId = resSet.getInt("user_id");
                            String name = resSet.getString("name");
                            String surname = resSet.getString("surname");
                            String birthDate = resSet.getString("date_of_birth");
                            String location = resSet.getString("location");
                            String gender = resSet.getString("gender");
                            String description = resSet.getString("description");
                            String profilePicturePath = resSet.getString("user_pic");
                            userProfile temp = new userProfile(userId, name, surname, gender, birthDate, location, description);
                            newUserProfile = userProfile.copyUser(temp);
                            newUserProfile.setUserPicPath(profilePicturePath);
                    }

                    request.setAttribute("userProfile", newUserProfile);
                    ConnectionToDataBase.endConnection(myCon);
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
