package ar.com.lupibuddies.springapi.usuario.dao.repository;

import java.util.Optional;

import ar.com.lupibuddies.springapi.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);

  Optional<Usuario> findByEmail(String email);

}
