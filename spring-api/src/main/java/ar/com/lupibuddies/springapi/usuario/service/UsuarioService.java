package ar.com.lupibuddies.springapi.usuario.service;

import ar.com.lupibuddies.springapi.exceptions.EntradaInvalidaException;
import ar.com.lupibuddies.springapi.exceptions.RecursoNoEncontradoException;
import ar.com.lupibuddies.springapi.usuario.dao.UsuarioDAO;
import ar.com.lupibuddies.springapi.usuario.dto.CambiarContraseniaRequest;
import ar.com.lupibuddies.springapi.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final PasswordEncoder passwordEncoder;
    private final UsuarioDAO usuarioDAO;

    public void cambiarContrasenia(CambiarContraseniaRequest request, Principal connectedUser) {
        Usuario usuario = (Usuario) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.passwordActual(), usuario.getPassword())) {
            throw new EntradaInvalidaException("Contraseña incorrecta.");
        }
        if (!request.passwordNueva().equals(request.confirmacionPasswordNueva())) {
            throw new EntradaInvalidaException("Las contraseñas no coinciden.");
        }

        usuario.setPassword(passwordEncoder.encode(request.passwordNueva()));

        usuarioDAO.save(usuario);
    }

    public void save(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    public Usuario findByEmail(String email) throws RecursoNoEncontradoException {
        return usuarioDAO.findByEmail(email)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado."));
    }
}
