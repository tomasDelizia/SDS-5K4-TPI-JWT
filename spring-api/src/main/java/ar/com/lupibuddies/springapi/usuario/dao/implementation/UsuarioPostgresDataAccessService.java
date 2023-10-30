package ar.com.lupibuddies.springapi.usuario.dao.implementation;

import ar.com.lupibuddies.springapi.usuario.dao.UsuarioDAO;
import ar.com.lupibuddies.springapi.usuario.dao.repository.UsuarioRepository;
import ar.com.lupibuddies.springapi.usuario.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UsuarioPostgresDataAccessService implements UsuarioDAO {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
