package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.CustomExceptions.*;
import com.rpl.SmartLibrary.classes.Buku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BukuService {
    private final BukuRepository repo;

    public BukuService(BukuRepository repo) { this.repo = repo; }

    public Page<BukuResponse> list(Pageable pageable) {
        return repo.findAll(pageable).map(BukuResponse::from);
    }

    public BukuResponse get(Long id) {
        return BukuResponse.from(find(id));
    }

    @Transactional
    public BukuResponse create(BukuRequest req) {
        if (repo.existsByIsbn(req.isbn())) {
            throw new DuplicateIsbnException(req.isbn());
        }
        Buku b = new Buku();
        b.setIsbn(req.isbn());
        b.setJudul(req.judul());
        b.setPenulis(req.penulis());
        b.setPenerbit(req.penerbit());
        b.setTahunTerbit(req.tahunTerbit());
        b.setKategori(req.kategori());
        b.setSinopsis(req.sinopsis());
        b.setStok(req.stok());
        return BukuResponse.from(repo.save(b));
    }

    @Transactional
    public BukuResponse update(Long id, BukuRequest req) {
        Buku b = find(id);
        b.setIsbn(req.isbn());
        b.setJudul(req.judul());
        b.setPenulis(req.penulis());
        b.setPenerbit(req.penerbit());
        b.setTahunTerbit(req.tahunTerbit());
        b.setKategori(req.kategori());
        b.setSinopsis(req.sinopsis());
        b.setStok(req.stok());
        return BukuResponse.from(b);
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new BukuNotFoundException(id);
        repo.deleteById(id);
    }

    private Buku find(Long id) {
        return repo.findById(id).orElseThrow(() -> new BukuNotFoundException(id));
    }
}
