<%@ page import="java.util.List" %>
<%@ page import="com.Gallery.Picture" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.Gallery.Album" %><%--
  Created by IntelliJ IDEA.
  User: Doru
  Date: 6/8/2019
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        div.gallery {
            margin: 5px;
            border: 1px solid #ccc;
            float: left;
            width: 180px;
        }

        div.gallery:hover {
            border: 1px solid #777;
        }

        div.gallery img {
            width: 100%;
            height: auto;
        }

        div.desc {
            padding: 15px;
            text-align: center;
        }
    </style>
</head>
<body>

<h1>Wellcome to Gallery!</h1>
<%
    //GET THE VALUE FROM SIGNUPJSP EMAIL
    String email = request.getParameter("email");
    int userId = Integer.parseInt(request.getParameter("userID"));


    //CREATEE A PARAMETER FOR SERVLET
    request.getSession().setAttribute("email", email);
    request.getSession().setAttribute("userID", userId);
%>


<form action="/SignUpForm_war_exploded/photoGallery" name="PhotoGallery" method="post"
      enctype="multipart/form-data">
    Upload picture:
    <input type="file" name="file" id="file" multiple><br>
    <input type="submit">
</form>
<div>
    <%

        List<String> Photos;
        Photos = Picture.GetPathsOfAlbumPhotos(Album.getAlbumIdFromDataBase(userId));
        int i = 0;
        for (String aux : Photos) {

            out.print("<img src=" + '"' + aux + '"' + " width=\"410\" height=\"310\"" + "/>");
            out.print(" ");
            i++;
            if (i == 3) {
                out.print("<br> <br>");
                i = 0;
            }

        }

    %>

</div>

</body>
</html>