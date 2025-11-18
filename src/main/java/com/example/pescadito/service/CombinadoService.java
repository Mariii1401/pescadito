package com.example.pescadito.service;

import com.example.pescadito.model.Combinado;
import com.example.pescadito.repository.CombinadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombinadoService {

    private final CombinadoRepository repo;

    public CombinadoService(CombinadoRepository repo) {
        this.repo = repo;
    }

    public List<Combinado> listar() {
        return repo.findAll();
    }

    public Combinado crear(Combinado c) {
        if (c.getPrecio() == null || c.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        if (c.getDisponible() == null) {
            c.setDisponible(true);
        }
        return repo.save(c);
    }

    public Optional<Combinado> obtener(Long id) {
        return repo.findById(id);
    }

    public Combinado actualizar(Long id, Combinado c) {
        return repo.findById(id).map(existing -> {
            existing.setNombre(c.getNombre());
            existing.setDescripcion(c.getDescripcion());
            existing.setPrecio(c.getPrecio());
            existing.setDisponible(c.getDisponible());
            existing.setCategoria(c.getCategoria());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Combinado no encontrado"));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}

