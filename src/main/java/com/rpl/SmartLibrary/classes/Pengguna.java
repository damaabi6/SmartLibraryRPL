package com.rpl.SmartLibrary.classes;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter long id;
    private @Getter @Setter String username;
    private @Getter @Setter String password;
    private @Getter @Setter boolean admin;

}
