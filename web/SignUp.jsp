<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 5/8/2019
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        //var checkPass=function(){


        function checkPass(){
            if(document.getElementById("pass").value == document.getElementById("pass-repeat").value){
                document.getElementById("message").style.color="green";
                document.getElementById("message").innerHTML="Matching";


                return true;
            }
            else{
                document.getElementById("message").style.color="red";
                document.getElementById("message").innerHTML="Passwords don't matching";

                return false;
            }
        }
        function validateMail(){
            var x= document.forms["SignUpForm"]["email"].value;
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            if(re.test(x)==false){


                alert("This is not a good email !");
                return re.test(x);}
            else return true;
        }




        function validateForm(){
            var z= validateMail() && checkPass();
            return z;}
    </script>

    <title>SignUp</title>
</head>
<body>

<form  action="/SignUpForm_war_exploded/Signup" name="SignUpForm" method="post" onsubmit="return validateForm();"  style="border:1px solid #ccc">
    <div class="container">
        <h1>Sign Up</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>


        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" id="pass" placeholder="Enter Password" name="psw" onkeyup="checkPass()" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" id="pass-repeat" placeholder="Repeat Password" name="psw-repeat" onkeyup="checkPass()"  required>
        <span id="message"></span>
        <label>
            <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
        </label>
        <br>
        <% if (null != request.getParameter("error")) {
            out.println(request.getParameter("error"));
        }
        %>

        <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>


        <button type="button" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">Sign Up</button>

    </div>
</form>
</body>
</html>
