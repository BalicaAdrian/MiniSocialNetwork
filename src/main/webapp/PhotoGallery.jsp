<%--
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
    int userId =  Integer.parseInt(request.getParameter("userID"));


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

<%--<div class="gallery">--%>
<%--    <a target="_blank" href="img_5terre.jpg">--%>
<%--        <img src="img_5terre.jpg" alt="Cinque Terre" width="600" height="400">--%>
<%--    </a>--%>
<%--    <div class="desc">Add a description of the image here</div>--%>
<%--</div>--%>

<%--<div class="gallery">--%>
<%--    <a target="_blank" href="img_forest.jpg">--%>
<%--        <img src="img_forest.jpg" alt="Forest" width="600" height="400">--%>
<%--    </a>--%>
<%--    <div class="desc">Add a description of the image here</div>--%>
<%--</div>--%>

<%--<div class="gallery">--%>
<%--    <a target="_blank" href="img_lights.jpg">--%>
<%--        <img src="img_lights.jpg" alt="Northern Lights" width="600" height="400">--%>
<%--    </a>--%>
<%--    <div class="desc">Add a description of the image here</div>--%>
<%--</div>--%>

<%--<div class="gallery">--%>
<%--    <a target="_blank" href="img_mountains.jpg">--%>
<%--        <img src="img_mountains.jpg" alt="Mountains" width="600" height="400">--%>
<%--    </a>--%>
<%--    <div class="desc">Add a description of the image here</div>--%>
<%--</div>--%>

</body>
</html>
