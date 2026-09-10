package com.rpl.SmartLibrary.classes;

public class User {

    private String username;
    private String NIM;
    private String password;

    public User(String username, String NIM, String password){
        setUsername(username);
        setNIM(NIM);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
