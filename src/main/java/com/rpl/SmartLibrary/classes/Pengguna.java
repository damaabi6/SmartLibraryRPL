package com.rpl.SmartLibrary.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pengguna")
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter long id;

    @Column(nullable = false, unique = true)
    private @Getter @Setter String username;

    // hanya bisa diterima dari request, tidak pernah dikirim balik di response
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private @Getter @Setter String password;

    private @Getter @Setter String nama_lengkap;
    private @Getter @Setter boolean admin;
    private @Getter @Setter String program_studi;
    private @Getter @Setter String angkatan;
    private @Getter @Setter String no_telepon;
    private @Getter @Setter String alamat;
    private @Getter @Setter String status;
    private @Getter @Setter String created_at;

    @PrePersist
    void saatDibuat() {
        if (created_at == null) {
            created_at = LocalDateTime.now().toString();
        }
    }

}
