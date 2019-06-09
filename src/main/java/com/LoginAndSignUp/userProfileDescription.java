package com.LoginAndSignUp;

import com.ConnectionDatabase.ConnectionToDataBase;
import com.Gallery.Album;
import com.LoginAndSignUp.userProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;


@WebServlet(name = "userProfileDescription" ,urlPatterns = "/userProfileDescription")
public class userProfileDescription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getting parameters from UserProfileDescription.jsp
        String gender = request.getParameter("Gender");
        String dateofbirth = request.getParameter("day") + "-" + request.getParameter("month") + "-" + request.getParameter("year");
        String location = request.getParameter("Location");
        String description = request.getParameter("comment");
        int id = (Integer)request.getSession().getAttribute("ID");
        String name = (String)request.getSession().getAttribute("userName");
        String surname = (String)request.getSession().getAttribute("userSurname");
        userProfile newUserProfile = new userProfile(id, name, surname, gender, dateofbirth, location, description);

        try {
            Album newAlbum = new Album(id);
            Album.writeAlbumInDataBase(newAlbum);

            userProfile.updateDataProfile(gender,dateofbirth,location,description, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Random rand = new Random();
        int random = rand.nextInt(7);
        random++;
        String path = "default_pictures/" + random + ".jpg";

        //setting the path of the random profile picture into the database
        Connection myCon = ConnectionToDataBase.getConnection();
        try {

            PreparedStatement insertStmt=myCon.prepareStatement("UPDATE  MiniSocialNetDB.USER_PROFILE SET USER_PIC = ? WHERE USER_ID like ?");
            insertStmt.setString(1, path);
            insertStmt.setInt(2, id);
            insertStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ConnectionToDataBase.endConnection(myCon);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //sending the parameters to com.LoginAndSignUp.ProfilePage.jsp
        newUserProfile.setUserPicPath(path);
        request.setAttribute("userProfile", newUserProfile);
        String email = (String)request.getSession().getAttribute("Email");
        request.setAttribute("email", email);

        request.getRequestDispatcher("ProfilePage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
