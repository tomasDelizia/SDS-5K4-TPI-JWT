package ar.com.lupibuddies.springapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictoInternoException extends RuntimeException {
    public ConflictoInternoException(String mensaje) {
        super(mensaje);
    }
}
