package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.classes.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    boolean existsByIsbn(String isbn);
    Optional<Buku> findByIsbn(String isbn);
    List<Buku> findByJudul(String judul);
    List<Buku> findByKategori(String kategori);
}

