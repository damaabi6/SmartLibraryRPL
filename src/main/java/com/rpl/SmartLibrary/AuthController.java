package com.rpl.SmartLibrary;

import com.rpl.SmartLibrary.classes.Pengguna;
import com.rpl.SmartLibrary.sql.PenggunaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public record LoginRequest(String username, String password) {}

    private final PenggunaService penggunaService;

    public AuthController(PenggunaService penggunaService) {
        this.penggunaService = penggunaService;
    }

    // Pendaftaran publik: akun yang dibuat selalu non-admin
    @PostMapping("/register")
    public ResponseEntity<Pengguna> register(@RequestBody Pengguna pengguna) {
        pengguna.setAdmin(false);
        return ResponseEntity.status(HttpStatus.CREATED).body(penggunaService.tambah(pengguna));
    }

    @PostMapping("/login")
    public Pengguna login(@RequestBody LoginRequest req) {
        return penggunaService.login(req.username(), req.password());
    }
}
