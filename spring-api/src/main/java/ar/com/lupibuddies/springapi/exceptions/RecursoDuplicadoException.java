package ar.com.lupibuddies.springapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecursoDuplicadoException extends RuntimeException {
    public RecursoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
