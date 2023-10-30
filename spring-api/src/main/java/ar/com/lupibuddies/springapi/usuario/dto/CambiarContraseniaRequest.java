package ar.com.lupibuddies.springapi.usuario.dto;

public record CambiarContraseniaRequest(
        String passwordActual,
        String passwordNueva,
        String confirmacionPasswordNueva
) {
}
