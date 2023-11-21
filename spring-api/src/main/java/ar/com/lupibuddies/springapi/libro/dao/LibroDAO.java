package ar.com.lupibuddies.springapi.libro.dao;

import ar.com.lupibuddies.springapi.libro.entity.Libro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LibroDAO {
    void save(Libro libro);

    List<Libro> findAll();

    Optional<Libro> findById(UUID id);

    void delete(Libro libro);
}
