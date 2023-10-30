package ar.com.lupibuddies.springapi.auth.dto;

public record AuthRequest(
        String email,
        String password
) {
}
