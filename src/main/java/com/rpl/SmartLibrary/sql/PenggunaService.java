package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.classes.Pengguna;
import com.rpl.SmartLibrary.sql.PenggunaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PenggunaService {

    private final PenggunaRepository penggunaRepository;
    private final PasswordEncoder passwordEncoder;

    public PenggunaService(PenggunaRepository penggunaRepository, PasswordEncoder passwordEncoder) {
        this.penggunaRepository = penggunaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // CREATE
    @Transactional
    public Pengguna tambah(Pengguna pengguna) {
        if (pengguna.getUsername() == null || pengguna.getUsername().isBlank()
                || pengguna.getPassword() == null || pengguna.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username dan password wajib diisi");
        }
        if (penggunaRepository.existsByUsername(pengguna.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username sudah dipakai");
        }
        pengguna.setId(0);
        pengguna.setPassword(passwordEncoder.encode(pengguna.getPassword()));
        return penggunaRepository.save(pengguna);
    }

    // LOGIN
    @Transactional(readOnly = true)
    public Pengguna login(String username, String password) {
        ResponseStatusException gagal =
                new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username atau password salah");
        if (username == null || password == null) throw gagal;
        Pengguna p = penggunaRepository.findByUsername(username).orElseThrow(() -> gagal);
        if (!passwordEncoder.matches(password, p.getPassword())) throw gagal;
        return p;
    }

    // READ
    @Transactional(readOnly = true)
    public List<Pengguna> semua() {
        return penggunaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pengguna cariById(long id) {
        return penggunaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pengguna id " + id + " tidak ditemukan"));
    }

    // UPDATE
    @Transactional
    public Pengguna ubah(long id, Pengguna data) {
        Pengguna p = cariById(id);

        if (data.getUsername() != null && !data.getUsername().equals(p.getUsername())) {
            if (penggunaRepository.existsByUsername(data.getUsername())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Username sudah dipakai");
            }
            p.setUsername(data.getUsername());
        }
        // password hanya diganti kalau diisi
        if (data.getPassword() != null && !data.getPassword().isBlank()) {
            p.setPassword(passwordEncoder.encode(data.getPassword()));
        }
        p.setNama_lengkap(data.getNama_lengkap());
        p.setAdmin(data.isAdmin());
        p.setProgram_studi(data.getProgram_studi());
        p.setAngkatan(data.getAngkatan());
        p.setNo_telepon(data.getNo_telepon());
        p.setAlamat(data.getAlamat());
        p.setStatus(data.getStatus());
        return penggunaRepository.save(p);
    }

    // DELETE
    @Transactional
    public void hapus(long id) {
        if (!penggunaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pengguna id " + id + " tidak ditemukan");
        }
        penggunaRepository.deleteById(id);
    }
}
