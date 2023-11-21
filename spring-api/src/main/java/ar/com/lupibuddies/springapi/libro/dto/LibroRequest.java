package ar.com.lupibuddies.springapi.libro.dto;

import java.time.LocalDate;

public record LibroRequest(
        String titulo,
        String autor,
        String isbn,
        String editorial,
        LocalDate fechaLanzamiento) {
}
