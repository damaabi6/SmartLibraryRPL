package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.classes.Buku;
import com.rpl.SmartLibrary.sql.BukuRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BukuService {

    private final BukuRepository bukuRepository;

    public BukuService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    // CREATE
    @Transactional
    public Buku tambah(Buku buku) {
        if (buku.getIsbn() != null && bukuRepository.existsByIsbn(buku.getIsbn())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "ISBN sudah terdaftar");
        }
        buku.setId(0); // pastikan INSERT, bukan UPDATE
        return bukuRepository.save(buku);
    }

    // READ (semua / pencarian judul)
    @Transactional(readOnly = true)
    public List<Buku> semua(String judul) {
        if (judul != null && !judul.isBlank()) {
            return bukuRepository.findByJudulContainingIgnoreCase(judul);
        }
        return bukuRepository.findAll();
    }

    // READ (by id)
    @Transactional(readOnly = true)
    public Buku cariById(long id) {
        return bukuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku id " + id + " tidak ditemukan"));
    }

    // UPDATE
    @Transactional
    public Buku ubah(long id, Buku data) {
        Buku buku = cariById(id);
        buku.setIsbn(data.getIsbn());
        buku.setJudul(data.getJudul());
        buku.setPenulis(data.getPenulis());
        buku.setPenerbit(data.getPenerbit());
        buku.setTahunTerbit(data.getTahunTerbit());
        buku.setKategori(data.getKategori());
        buku.setSinopsis(data.getSinopsis());
        buku.setStok(data.getStok());
        return bukuRepository.save(buku);
    }

    // DELETE
    @Transactional
    public void hapus(long id) {
        if (!bukuRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Buku id " + id + " tidak ditemukan");
        }
        bukuRepository.deleteById(id);
    }
}
