package ar.com.lupibuddies.springapi.libro.dao.implementation;

import ar.com.lupibuddies.springapi.libro.dao.LibroDAO;
import ar.com.lupibuddies.springapi.libro.dao.repository.LibroRepository;
import ar.com.lupibuddies.springapi.libro.entity.Libro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class LibroPostgresDataAcessService implements LibroDAO {
    private final LibroRepository libroRepository;

    @Override
    public void save(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> findById(UUID id) {
        return libroRepository.findById(id);
    }

    @Override
    public void delete(Libro libro) {
        libroRepository.delete(libro);
    }
}
