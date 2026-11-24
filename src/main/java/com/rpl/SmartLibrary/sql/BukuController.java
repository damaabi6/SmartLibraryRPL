package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.classes.Buku;
import com.rpl.SmartLibrary.sql.BukuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buku")
public class BukuController {

    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @PostMapping
    public ResponseEntity<Buku> tambah(@RequestBody Buku buku) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bukuService.tambah(buku));
    }

    @GetMapping
    public List<Buku> semua(@RequestParam(required = false) String judul) {
        return bukuService.semua(judul);
    }

    @GetMapping("/{id}")
    public Buku detail(@PathVariable long id) {
        return bukuService.cariById(id);
    }

    @PutMapping("/{id}")
    public Buku ubah(@PathVariable long id, @RequestBody Buku buku) {
        return bukuService.ubah(id, buku);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapus(@PathVariable long id) {
        bukuService.hapus(id);
        return ResponseEntity.noContent().build();
    }
}
