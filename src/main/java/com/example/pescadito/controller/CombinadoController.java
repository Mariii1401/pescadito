package com.example.pescadito.controller;

import com.example.pescadito.model.Combinado;
import com.example.pescadito.service.CombinadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/combinados")
public class CombinadoController {

    private final CombinadoService service;

    public CombinadoController(CombinadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Combinado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combinado> obtener(@PathVariable Long id) {
        return service.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Combinado> crear(@Valid @RequestBody Combinado c) {
        Combinado creado = service.crear(c);
        return ResponseEntity.created(URI.create("/api/combinados/" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combinado> actualizar(@PathVariable Long id, @Valid @RequestBody Combinado c) {
        try {
            Combinado actualizado = service.actualizar(id, c);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
