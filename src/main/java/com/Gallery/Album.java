package com.Gallery;

import com.ConnectionDatabase.ConnectionToDataBase;

import java.sql.*;

public class Album {
    private int ID;
    private int userID;
    private String description;

    public int getID() { return ID; }

    public int getUserID() { return userID; }

    public String getDescription() { return description; }

    public void setID(int ID) { this.ID = ID; }

    public void setUserID(int userID) { this.userID = userID; }

    public void setDescription(String description) { this.description = description; }

    public Album() {
    }

    public Album(int userID) throws SQLException {
        this.ID = getUniqueId();
        this.userID = userID;
    }

    public static int getUniqueId() throws SQLException {
        Connection myCon = ConnectionToDataBase.getConnection();
        Statement Stmt =myCon.createStatement();
        String sql =" SELECT ALBUM_ID FROM MiniSocialNetDB.ALBUM WHERE ALBUM_ID = (SELECT MAX(ALBUM_ID) FROM MiniSocialNetDB.ALBUM)";
        ResultSet myResult=Stmt.executeQuery(sql);
        myResult.next();
        int albumID = myResult.getInt("ALBUM_ID");
        ConnectionToDataBase.endConnection(myCon);
        return ++albumID;
    }

    public static void writeAlbumInDataBase(Album ob) throws SQLException {
        Connection myCon = ConnectionToDataBase.getConnection();
        PreparedStatement prepStmt = myCon.prepareStatement(" INSERT INTO MiniSocialNetDB.ALBUM (ALBUM_ID, USER_ID) VALUES (?, ?) ");
        prepStmt.setInt(1, ob.getID());
        prepStmt.setInt(2, ob.getUserID());
        prepStmt.executeUpdate();
        ConnectionToDataBase.endConnection(myCon);
    }

    public static int getAlbumIdFromDataBase(int userID) throws SQLException {
        Connection myCon = ConnectionToDataBase.getConnection();
        PreparedStatement prepStm = myCon.prepareStatement("SELECT ALBUM_ID FROM MiniSocialNetDB.ALBUM WHERE USER_ID = ?");
        prepStm.setInt(1, userID);
        ResultSet res = prepStm.executeQuery();
        res.next();
        int albumID = res.getInt("ALBUM_ID");
        ConnectionToDataBase.endConnection(myCon);
        return albumID;
    }
}
