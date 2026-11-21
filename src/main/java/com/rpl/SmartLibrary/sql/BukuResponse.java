package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.classes.Buku;

public record BukuResponse(Long id, String isbn, String judul, String penulis, String penerbit, String tahunTerbit, String kategori, String sinopsis, int stok) {
    public static BukuResponse from(Buku b) {
        return new BukuResponse(b.getId(), b.getIsbn(), b.getJudul(), b.getPenulis(), b.getPenerbit(), b.getTahunTerbit(), b.getKategori(), b.getSinopsis(), b.getStok());
    }
}
