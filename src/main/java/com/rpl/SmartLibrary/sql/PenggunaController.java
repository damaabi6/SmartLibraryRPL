package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.classes.Pengguna;
import com.rpl.SmartLibrary.sql.PenggunaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pengguna")
public class PenggunaController {

    private final PenggunaService penggunaService;

    public PenggunaController(PenggunaService penggunaService) {
        this.penggunaService = penggunaService;
    }

    @PostMapping
    public ResponseEntity<Pengguna> tambah(@RequestBody Pengguna pengguna) {
        return ResponseEntity.status(HttpStatus.CREATED).body(penggunaService.tambah(pengguna));
    }

    @GetMapping
    public List<Pengguna> semua() {
        return penggunaService.semua();
    }

    @GetMapping("/{id}")
    public Pengguna detail(@PathVariable long id) {
        return penggunaService.cariById(id);
    }

    @PutMapping("/{id}")
    public Pengguna ubah(@PathVariable long id, @RequestBody Pengguna pengguna) {
        return penggunaService.ubah(id, pengguna);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hapus(@PathVariable long id) {
        penggunaService.hapus(id);
        return ResponseEntity.noContent().build();
    }
}
