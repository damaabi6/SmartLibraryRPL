package com.rpl.SmartLibrary.classes;

import lombok.Getter;
import lombok.Setter;

public class User {

    private @Getter String username;
    private @Getter String id;
    private @Getter String password;
    private @Getter boolean admin;

    public User(String username, String id, String password) {
        setUsername(username);
        setId(id);
        setPassword(password);
    }

    public User(String username, String id, String password, boolean admin) {
        setUsername(username);
        setId(id);
        setPassword(password);
        setAdmin(admin);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
