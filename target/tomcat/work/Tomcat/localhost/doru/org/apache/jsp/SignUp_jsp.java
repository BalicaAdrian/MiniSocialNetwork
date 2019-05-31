/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-05-31 18:33:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <script>\n");
      out.write("        //var checkPass=function(){\n");
      out.write("\n");
      out.write("\n");
      out.write("        function checkPass(){\n");
      out.write("            if(document.getElementById(\"pass\").value == document.getElementById(\"pass-repeat\").value){\n");
      out.write("                document.getElementById(\"message\").style.color=\"green\";\n");
      out.write("                document.getElementById(\"message\").innerHTML=\"Matching\";\n");
      out.write("\n");
      out.write("\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("            else{\n");
      out.write("                document.getElementById(\"message\").style.color=\"red\";\n");
      out.write("                document.getElementById(\"message\").innerHTML=\"Passwords don't matching\";\n");
      out.write("\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        function validateMail(){\n");
      out.write("            var x= document.forms[\"SignUpForm\"][\"email\"].value;\n");
      out.write("            var re = /^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/;\n");
      out.write("            if(re.test(x)==false){\n");
      out.write("\n");
      out.write("\n");
      out.write("                alert(\"This is not a good email !\");\n");
      out.write("                return re.test(x);}\n");
      out.write("            else return true;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        function validateForm(){\n");
      out.write("            var z= validateMail() && checkPass();\n");
      out.write("            return z;}\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <title>SignUp</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<form  action=\"/SignUpForm_war_exploded/Signup\" name=\"SignUpForm\" method=\"post\" onsubmit=\"return validateForm();\"  style=\"border:1px solid #ccc\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Sign Up</h1>\n");
      out.write("        <p>Please fill in this form to create an account.</p>\n");
      out.write("        <hr>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <label for=\"email\"><b>Email</b></label>\n");
      out.write("        <input type=\"text\" placeholder=\"Enter Email\" name=\"email\" required>\n");
      out.write("\n");
      out.write("        <label for=\"psw\"><b>Password</b></label>\n");
      out.write("        <input type=\"password\" id=\"pass\" placeholder=\"Enter Password\" name=\"psw\" onkeyup=\"checkPass()\" required>\n");
      out.write("\n");
      out.write("        <label for=\"psw-repeat\"><b>Repeat Password</b></label>\n");
      out.write("        <input type=\"password\" id=\"pass-repeat\" placeholder=\"Repeat Password\" name=\"psw-repeat\" onkeyup=\"checkPass()\"  required>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <label for=\"userName\"><b>Name</b></label>\n");
      out.write("        <input type=\"text\" placeholder=\"Enter name\" name=\"userName\" required>\n");
      out.write("\n");
      out.write("        <label for=\"userSurname\"><b>Surname</b></label>\n");
      out.write("        <input type=\"text\" placeholder=\"Enter surname\" name=\"userSurname\" required>\n");
      out.write("\n");
      out.write("        <span id=\"message\"></span>\n");
      out.write("        <label>\n");
      out.write("            <input type=\"checkbox\" checked=\"checked\" name=\"remember\" style=\"margin-bottom:15px\"> Remember me\n");
      out.write("        </label>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        ");
 if (null != request.getParameter("error")) {
            out.println(request.getParameter("error"));
        }
        
      out.write("\n");
      out.write("\n");
      out.write("        <p>By creating an account you agree to our <a href=\"#\" style=\"color:dodgerblue\">Terms & Privacy</a>.</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <button type=\"button\" class=\"cancelbtn\">Cancel</button>\n");
      out.write("        <button type=\"submit\" class=\"signupbtn\">Sign Up</button>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
