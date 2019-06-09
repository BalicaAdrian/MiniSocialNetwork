package com.LoginAndSignUp;

import com.ConnectionDatabase.ConnectionToDataBase;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet(name = "ProfilePage", urlPatterns = "/Profilepage")
public class ProfilePage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        if (!ServletFileUpload.isMultipartContent(request)) {
            out.println("Nothing to upload");
            return;
        }

        //preparing files for being uploaded
        FileItemFactory itemfactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(itemfactory);
        userProfile userProfile;
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {

                //getting the email and userProfile object from ProfilePage.jsp
                userProfile = (userProfile)request.getSession().getAttribute("userProfile");
                String email = (String)request.getSession().getAttribute("email");
                String path = "./src/main/webapp/" + email;
                new File(path).mkdir();
                File uploadDir = new File(path);
                File file = File.createTempFile("img", ".jpg", uploadDir);
                item.write(file);
                path = email + "/" + file.getName();

                //updating the user profile path
                //TO DO: if in the folder is another picture, delete that picture or move it to the photo album
                Connection myCon = ConnectionToDataBase.getConnection();
                PreparedStatement prepstm = myCon.prepareStatement("UPDATE  MiniSocialNetDB.USER_PROFILE SET USER_PIC = ? WHERE USER_ID like ?");
                prepstm.setString(1, path);
                prepstm.setInt(2, userProfile.getId());
                prepstm.executeUpdate();
                ConnectionToDataBase.endConnection(myCon);

                //sending the updated object with email to the jsp
                userProfile.setUserPicPath(path);
                request.setAttribute("email", email);
                request.setAttribute("userProfile", userProfile);
                request.getRequestDispatcher("ProfilePage.jsp").forward(request,response);
            }
        } catch (FileUploadException e) {
            out.println("upload fail");
        } catch (Exception ex) {
            out.println("can't save");
        }
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
