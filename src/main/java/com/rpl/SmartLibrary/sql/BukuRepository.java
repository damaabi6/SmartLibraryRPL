package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.classes.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    boolean existsByIsbn(String isbn);
    List<Buku> findByJudulContainingIgnoreCase(String judul);
    List<Buku> findByKategori(String kategori);
}
