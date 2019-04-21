import java.io.IOException;

public class SignUp extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().println(request.getParameter("email"));
        response.getWriter().println(request.getParameter("psw"));
        response.getWriter().println(request.getParameter("psw-repeat"));



    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
