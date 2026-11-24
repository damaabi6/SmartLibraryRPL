package com.rpl.SmartLibrary.sql;

import com.rpl.SmartLibrary.classes.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Long> {
    boolean existsByUsername(String username);
    Optional<Pengguna> findByUsername(String username);
}
