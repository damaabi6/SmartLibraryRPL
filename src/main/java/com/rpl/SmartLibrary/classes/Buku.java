package com.rpl.SmartLibrary.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "buku")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter long id;
    private @Getter @Setter String isbn;
    private @Getter @Setter String judul;
    private @Getter @Setter String penulis;
    private @Getter @Setter String penerbit;
    private @Getter @Setter String tahunTerbit;
    private @Getter @Setter String kategori;
    private @Getter @Setter String sinopsis;
    private @Getter @Setter int stok;

    //public Buku(int id, String isbn, String judul, String penulis, String penerbit, String tahunTerbit, String kategori, String sinopsis, int stok) {
    //    this.id = id;
    //    this.isbn = isbn;
    //    this.judul = judul;
    //    this.penulis = penulis;
    //    this.penerbit = penerbit;
    //    this.tahunTerbit = tahunTerbit;
    //    this.kategori = kategori;
    //    this.sinopsis = sinopsis;
    //    this.stok = stok;
    //}

    public boolean Stok_Tersedia() { return stok > 0; }

}
