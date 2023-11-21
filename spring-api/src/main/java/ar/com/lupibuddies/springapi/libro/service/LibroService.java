package ar.com.lupibuddies.springapi.libro.service;

import ar.com.lupibuddies.springapi.exceptions.EntradaInvalidaException;
import ar.com.lupibuddies.springapi.exceptions.RecursoNoEncontradoException;
import ar.com.lupibuddies.springapi.libro.dao.LibroDAO;
import ar.com.lupibuddies.springapi.libro.dto.LibroDTO;
import ar.com.lupibuddies.springapi.libro.dto.LibroRequest;
import ar.com.lupibuddies.springapi.libro.entity.Libro;
import ar.com.lupibuddies.springapi.libro.mapper.LibroDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroDAO libroDAO;
    private final LibroDTOMapper libroDTOMapper;

    public void save(LibroRequest request) throws EntradaInvalidaException {
        String titulo = request.titulo();
        String isbn =  request.isbn();
        String editorial = request.editorial();
        String autor = request.autor();
        LocalDate fechaLanzamiento = request.fechaLanzamiento();
        validarLibro(titulo, isbn, editorial, autor, fechaLanzamiento);
        Libro libro = Libro.builder()
                .titulo(titulo)
                .autor(autor)
                .isbn(isbn)
                .editorial(editorial)
                .fechaLanzamiento(fechaLanzamiento)
                .build();
        libroDAO.save(libro);
    }

    private void validarLibro(
            String titulo,
            String isbn,
            String editorial,
            String autor,
            LocalDate fechaLanzamiento) {
        if (!StringUtils.hasText(titulo) || !StringUtils.hasText(isbn) || !StringUtils.hasText(editorial) || !StringUtils.hasText(autor) || fechaLanzamiento == null) {
            throw new EntradaInvalidaException("Los campos no pueden estar vacíos");
        }
        if (titulo.length() > 50 || isbn.length() > 50 || editorial.length() > 50 || autor.length() > 50) {
            throw new EntradaInvalidaException("Los campos no pueden tener más de 50 caracteres");
        }
    }

    public List<LibroDTO> findAll() throws RecursoNoEncontradoException {
        List<Libro> libros = libroDAO.findAll();
        if (libros.isEmpty()) {
            throw new RecursoNoEncontradoException("No se encontraron libros");
        }
        return libros.stream().map(libroDTOMapper).toList();
    }

    private Libro findById(UUID id) throws RecursoNoEncontradoException {
        return libroDAO.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró el libro con id " + id));
    }

    public void delete(UUID id) {
        Libro libro = findById(id);
        libroDAO.delete(libro);
    }
}
