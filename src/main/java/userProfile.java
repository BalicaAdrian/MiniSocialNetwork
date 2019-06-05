import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userProfile {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private String dateOfBirth;
    private String location;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    userProfile(User newUserProfile) {
        this.id = newUserProfile.getId();


    }
    static public void updateDataProfile(String gender, String dateOfBirth, String location, String description, int id) throws SQLException {


        Connection myCon= ConnectionToDataBase.getConnection();
        PreparedStatement insertStmt=myCon.prepareStatement("UPDATE  MiniSocialNetDB.USER_PROFILE SET LOCATION=?, DATE_OF_BIRTH=?, GENDER=?, DESCRIPTION=? WHERE USER_ID like ?");
        insertStmt.setString(1,location);
        insertStmt.setString(2, dateOfBirth);
        insertStmt.setString(3, gender);
        insertStmt.setString(4,description);
        insertStmt.setString(5, String.valueOf(id));
        insertStmt.executeUpdate();


    }

    public void createProfileUserInDataBase(String name, String surname) throws SQLException {

        this.name = name;
        this.surname = surname;



        Connection myCon = ConnectionToDataBase.getConnection();
        PreparedStatement insertStmt = myCon.prepareStatement("INSERT INTO MiniSocialNetDB.USER_PROFILE (USER_ID, NAME, SURNAME) VALUES (?,?,?)");

        insertStmt.setInt(1, this.id);
        insertStmt.setString(2, this.name);
        insertStmt.setString(3, this.surname);


        insertStmt.executeUpdate();


    }

}
