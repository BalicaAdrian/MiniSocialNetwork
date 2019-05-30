<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 5/18/2019
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/SignUpForm_war_exploded/loginPage" name="loginPage" method="post" >
<div class="container">
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
<br>
    <% if (null != request.getParameter("error")) {
        out.println(request.getParameter("error"));
    }
    %>
    <br>

    <button type="submit">Login</button>

</div>
</form>
</body>
</html>
