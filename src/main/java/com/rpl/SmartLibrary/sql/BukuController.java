package com.rpl.SmartLibrary.sql;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/buku")
public class BukuController {
    private final BukuService service;

    public BukuController(BukuService service) { this.service = service; }

    @GetMapping
    public Page<BukuResponse> list(Pageable pageable) {
        return service.list(pageable);          // ?page=0&size=20&sort=title
    }

    @GetMapping("/{id}")
    public BukuResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<BukuResponse> create(@Valid @RequestBody BukuRequest req) {
        BukuResponse created = service.create(req);
        URI location = URI.create("/api/buku/" + created.id());
        return ResponseEntity.created(location).body(created);   // 201 + Location header
    }

    @PutMapping("/{id}")
    public BukuResponse update(@PathVariable Long id, @Valid @RequestBody BukuRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)       // 204
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

