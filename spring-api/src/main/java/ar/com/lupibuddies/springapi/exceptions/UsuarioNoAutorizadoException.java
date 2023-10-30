package ar.com.lupibuddies.springapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UsuarioNoAutorizadoException extends RuntimeException {
    public UsuarioNoAutorizadoException(String mensaje) {
        super(mensaje);
    }
}
