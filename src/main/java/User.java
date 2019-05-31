import java.sql.*;

public class User {
    private String email;
    private String password;
    private int id;
    //static int ID=600 ;

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }


    public User(String email,String password,int ID) {
            this.id=ID;
            this.email = email;
            this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void addToDataBase() throws SQLException {

     Connection myCon=ConnectionToDataBase.getConnection();
     PreparedStatement insertStmt=myCon.prepareStatement("INSERT INTO MiniSocialNetDB.USER (USER_ID, EMAIL, PASSWORD) VALUES (?,?,?)");
     insertStmt.setString(2,this.email);
     insertStmt.setString(3,this.password);
     insertStmt.setInt(1,this.id);
     insertStmt.executeUpdate();


 }

 public static int getUniqueId() throws SQLException {
     Connection myCon=ConnectionToDataBase.getConnection();
     Statement Stmt=myCon.createStatement();
     String sql =" SELECT * FROM MiniSocialNetDB.USER WHERE USER_ID = (SELECT MAX(USER_ID) FROM MiniSocialNetDB.USER )";
     ResultSet myResult=Stmt.executeQuery(sql);
     myResult.next();

    return myResult.getInt("USER_ID");
 }

     public static String findByEmail(String email) throws SQLException {
         Connection myCon=ConnectionToDataBase.getConnection();
         Statement Stmt=myCon.createStatement();
         String sql =" SELECT EMAIL FROM MiniSocialNetDB.USER";
         boolean gasit=false;
         ResultSet myResult=Stmt.executeQuery(sql);
        while(myResult.next()) {
            if(email.equals(myResult.getString("EMAIL")))
                gasit=true;


            //System.out.println(myResult.getString("EMAIL"));
        }
        if(gasit)
           return "true";
        else
            return "fasle";

     }

     public static String getPasswordFromMail(String email) throws SQLException {

         Connection myCon= ConnectionToDataBase.getConnection();
         PreparedStatement Stmt= myCon.prepareStatement("SELECT PASSWORD FROM MiniSocialNetDB.USER WHERE EMAIL  LIKE ?");
         Stmt.setString(1,email);
         ResultSet myResult=Stmt.executeQuery();
         String password=null;
          if(myResult.next()) {
              password = myResult.getString("PASSWORD");
         }
         return password;


     }



//    public static void main(String[] args) throws SQLException {
//        //User nou= new User("dada@cti-fmi.ro","rada");
//       // System.out.println(getUniqueId());
//       // int ok=0;
//        //findByEmail("adrian@yahoo.com");
//
//        User.findByEmail("alin@gmail.com");
//        System.out.println(User.getPasswordFromMail("alin@gmail.com"));
//
//    }

}
