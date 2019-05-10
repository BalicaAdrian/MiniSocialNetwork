import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    private String email;
    private String password;
    private int id;
    static int ID=100;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public User(String email, String password) {
        ID++;
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

//    public static void main(String[] args) throws SQLException {
//        User nou= new User("dada@cti-fmi.ro","rada");
//        nou.addToDataBase();
//    }

}
