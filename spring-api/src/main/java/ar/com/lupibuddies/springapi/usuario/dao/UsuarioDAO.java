package ar.com.lupibuddies.springapi.usuario.dao;

import ar.com.lupibuddies.springapi.usuario.entity.Usuario;

import java.util.Optional;

public interface UsuarioDAO {
    Optional<Usuario> findByEmail(String email);
    void save(Usuario usuario);

    boolean existsByEmail(String email);
}
