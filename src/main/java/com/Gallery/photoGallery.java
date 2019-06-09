package com.Gallery;

import com.ConnectionDatabase.ConnectionToDataBase;
import com.LoginAndSignUp.userProfile;
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

@WebServlet(name = "PhotoGallery", urlPatterns = "/photoGallery")
public class photoGallery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if (!ServletFileUpload.isMultipartContent(request)) {
            out.println("Nothing to upload");
            return;
        }

        //preparing files for being uploaded
        FileItemFactory itemfactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(itemfactory);
        try {
            List<FileItem> items = upload.parseRequest(request);
            //getting the email and userID from PhotoGallery.jsp
            int userID = (Integer)request.getSession().getAttribute("userID");
            String email = (String)request.getSession().getAttribute("email");

            for (FileItem item : items) {
                String path = "./src/main/webapp/" + email;
                new File(path).mkdir();
                File uploadDir = new File(path);
                File file = File.createTempFile("img", ".jpg", uploadDir);
                item.write(file);
                path = email + "/" + file.getName();

                //writing the picture path, ID and albumID into the database
                Picture photo = new Picture(path, Album.getAlbumIdFromDataBase(userID));
                Picture.writePhotoInDataBase(photo);

            }

            //sending userID with email to the jsp
            String redirectURL ="http://localhost:8080/SignUpForm_war_exploded/PhotoGallery?email=";
            response.sendRedirect(redirectURL + email + "&userID=" + userID);
        } catch (FileUploadException e) {
            out.println("upload fail");
        } catch (Exception ex) {
            out.println("can't save");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
