package ar.com.lupibuddies.springapi.libro.mapper;

import ar.com.lupibuddies.springapi.libro.dto.LibroDTO;
import ar.com.lupibuddies.springapi.libro.entity.Libro;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class LibroDTOMapper implements Function<Libro, LibroDTO> {

        @Override
        public LibroDTO apply(Libro libro) {
            return new LibroDTO(
                    libro.getId(),
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getEditorial(),
                    libro.getFechaLanzamiento()
            );
        }
}
