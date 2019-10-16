package com.example.comicsshowcase;

public class ComicDB_User {

    public static final String TABLE = "user";
    public static final String ID = "user_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    private int id;
    private String username;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getTABLE() {
        return TABLE;
    }

    public static String getID() {
        return ID;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ComicDB_User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}