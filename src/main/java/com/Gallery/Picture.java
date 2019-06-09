package com.Gallery;

import com.ConnectionDatabase.ConnectionToDataBase;

import java.sql.*;

public class Picture {
    private String path;
    private int ID;
    private int albumID;
    public Picture() {
    }

    public Picture(String path, int albumID) throws SQLException {
        this.path = path;
        this.albumID = albumID;
        this.ID = getUniqueId();
    }

    public static int getUniqueId() throws SQLException {
        Connection myCon = ConnectionToDataBase.getConnection();
        Statement Stmt =myCon.createStatement();
        String sql =" SELECT PHOTO_ID FROM MiniSocialNetDB.PHOTO WHERE PHOTO_ID = (SELECT MAX(PHOTO_ID) FROM MiniSocialNetDB.PHOTO)";
        ResultSet myResult=Stmt.executeQuery(sql);
        myResult.next();
        int photoID = myResult.getInt("PHOTO_ID");
        ConnectionToDataBase.endConnection(myCon);
        return ++photoID;
    }

    public static void writePhotoInDataBase(Picture ob) throws SQLException {
        Connection myCon = ConnectionToDataBase.getConnection();
        PreparedStatement prepStmt = myCon.prepareStatement(" INSERT INTO MiniSocialNetDB.PHOTO (PHOTO_ID, ALBUM_ID, PATH) VALUES (?, ?, ?) ");
        prepStmt.setInt(1, ob.getID());
        prepStmt.setInt(2, ob.getAlbumID());
        prepStmt.setString(3, ob.getPath());
        prepStmt.executeUpdate();
        ConnectionToDataBase.endConnection(myCon);
    }

    public String getPath() {
        return path;
    }

    public int getID() {
        return ID;
    }

    public int getAlbumID() { return albumID; }

    public void setPath(String path) { this.path = path; }

    public void setID(int ID) { this.ID = ID; }

    public void setAlbumID(int albumID) { this.albumID = albumID; }
}
