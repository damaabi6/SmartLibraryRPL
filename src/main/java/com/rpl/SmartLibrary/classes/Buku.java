package com.rpl.SmartLibrary.classes;

import lombok.Getter;

public class Buku {
    private @Getter String judul;
    private @Getter String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
}
