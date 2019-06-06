import java.sql.*;

public class userProfile {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private String dateOfBirth;
    private String location;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

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

    public userProfile(User newUserProfile) {
        this.id = newUserProfile.getId();
    }

    public static userProfile copyUser(userProfile newUser) {
        int id = newUser.getId();
        String dateOfBirth = newUser.getDateOfBirth();
        String description = newUser.getDescription();
        String gender = newUser.getGender();
        String location = newUser.getLocation();
        String name = newUser.getName();
        String surname = newUser.getSurname();
        userProfile user = new userProfile(id, name, surname, gender, dateOfBirth, location, description);
        return  user;
    }

    public userProfile(int id, String name, String surname, String gender, String dateOfBirth, String location, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.description = description;
    }

    public userProfile() {
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
