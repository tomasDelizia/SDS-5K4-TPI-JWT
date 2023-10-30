package ar.com.lupibuddies.springapi.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class DefaultExceptionHandler {
    /**
     * Manejar una excepción de tipo Recurso No Encontrado, generando una respuesta con código 404 (Not Found).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ApiError> handleException(RecursoNoEncontradoException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    /**
     * Manejar una excepción de tipo Recurso Duplicado, generando una respuesta con código 409 (Conflict).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(RecursoDuplicadoException.class)
    public ResponseEntity<ApiError> handleException(RecursoDuplicadoException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    /**
     * Manejar una excepción de tipo Conflicto Interno, generando una respuesta con código 409 (Conflict).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(ConflictoInternoException.class)
    public ResponseEntity<ApiError> handleException(ConflictoInternoException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    /**
     * Manejar una excepción de tipo Entrada Inválida, generando una respuesta con código 400 (Bad Request).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(EntradaInvalidaException.class)
    public ResponseEntity<ApiError> handleException(EntradaInvalidaException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manejar una excepción de tipo RecursoProhibido, generando una respuesta con código 403 (Forbidden).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(RecursoProhibidoException.class)
    public ResponseEntity<ApiError> handleException(RecursoProhibidoException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }

    /**
     * Manejar una excepción de tipo Access Denied, generando una respuesta con código 403 (Forbidden).
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiError> handleException(HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                "No tiene permisos para acceder al recurso",
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }

    /**
     * Manejar una excepción de tipo Insufficient Authentication, generando una respuesta con código 403 (Forbidden).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<ApiError> handleException(InsufficientAuthenticationException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }

    /**
     * Manejar una excepción de tipo Bad Credentials, generando una respuesta con código 401 (Unauthorized).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleException(BadCredentialsException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Manejar una excepción de tipo UsuarioNoAutorizado, generando una respuesta con código 401 (Unauthorized).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(UsuarioNoAutorizadoException.class)
    public ResponseEntity<ApiError> handleException(UsuarioNoAutorizadoException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Manejar una excepción de conexión.
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(ErrorInternoException.class)
    public ResponseEntity<ApiError> handleException(ErrorInternoException exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Manejar una excepción genérica, generando una respuesta con código 500 (Internal Server Error).
     * @param exception La excepción capturada.
     * @param request La petición HTTP que generó la excepción.
     * @return Una respuesta de tipo API Error, con la dirección del recurso, mensaje, código y fecha.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception exception,
                                                    HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
