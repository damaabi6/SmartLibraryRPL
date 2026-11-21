package com.rpl.SmartLibrary.sql;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record BukuRequest(
        @NotBlank @Pattern(regexp = "^(978|979)\\d{10}$", message = "harus berupa kode ISBN 13-digit") String isbn,
        @NotBlank @Size(max = 255) String judul,
        @Size(max = 255) String penulis,
        @Size(max = 255) String penerbit,
        @Size(max = 4) String tahunTerbit,
        @Size(max = 255) String kategori,
        String sinopsis,
        int stok
        ) {}
