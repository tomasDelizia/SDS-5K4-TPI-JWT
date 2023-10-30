package ar.com.lupibuddies.springapi.exceptions;

import java.time.LocalDateTime;

public record ApiError(
        String path,
        String error,
        int status,
        LocalDateTime timestamp
) {
}
