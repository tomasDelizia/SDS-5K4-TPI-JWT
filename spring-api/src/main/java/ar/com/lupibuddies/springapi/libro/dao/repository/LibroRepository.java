package ar.com.lupibuddies.springapi.libro.dao.repository;

import ar.com.lupibuddies.springapi.libro.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibroRepository extends JpaRepository<Libro, UUID> {
}
