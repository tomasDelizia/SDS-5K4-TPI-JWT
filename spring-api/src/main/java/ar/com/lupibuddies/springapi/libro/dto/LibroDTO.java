package ar.com.lupibuddies.springapi.libro.dto;

import java.time.LocalDate;
import java.util.UUID;

public record LibroDTO(
        UUID id,

        String isbn,

        String titulo,

        String autor,

        String editorial,

        LocalDate fechaLanzamiento
) {
}
