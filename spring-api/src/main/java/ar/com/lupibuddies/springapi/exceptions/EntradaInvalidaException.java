package ar.com.lupibuddies.springapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntradaInvalidaException extends RuntimeException {
    public EntradaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
