package com.rpl.SmartLibrary.services;

import com.rpl.SmartLibrary.classes.Buku;
import java.util.List;

public class Perpustakaan {

    public Buku cariBuku(String judulBuku, List<Buku> daftarBuku) {
        for (Buku buku : daftarBuku) {
            if(buku.getJudul().trim().equals(judulBuku.trim()))
                return buku;
        }
        return null;
    }
}
