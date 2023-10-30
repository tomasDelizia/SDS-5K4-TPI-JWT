package ar.com.lupibuddies.springapi.usuario.controller;

import ar.com.lupibuddies.springapi.usuario.dto.CambiarContraseniaRequest;
import ar.com.lupibuddies.springapi.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PatchMapping
    public void changePassword(
          @RequestBody CambiarContraseniaRequest request,
          Principal connectedUser) {
        usuarioService.cambiarContrasenia(request, connectedUser);
    }
}
