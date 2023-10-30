package ar.com.lupibuddies.springapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class RecursoProhibidoException extends RuntimeException {
    public RecursoProhibidoException(String mensaje) {
        super(mensaje);
    }
}
