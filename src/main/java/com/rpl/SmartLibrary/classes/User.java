package com.rpl.SmartLibrary.classes;

public class User {

    private String username;
    private String id;
    private String password;

    public User(String username, String id, String password){
        setUsername(username);
        setid(id);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
