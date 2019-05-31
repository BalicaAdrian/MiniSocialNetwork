import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDataBase {
    private  static String url="jdbc:mysql://35.240.82.6:3306/";
    private static  String user="BalicaAdrian";
    private static  String password="000000";
    private static Connection con;

    public static Connection getConnection(){
        Connection con=null;
        try {
            con = DriverManager.getConnection(url,user,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (con!= null) {
            System.out.println("Connected to database");
        } else {
            System.out.println("Cannot connect to database");
        }
        return con;
    }
}
