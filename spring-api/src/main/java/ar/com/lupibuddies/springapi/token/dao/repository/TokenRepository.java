package ar.com.lupibuddies.springapi.token.dao.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ar.com.lupibuddies.springapi.token.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  @Query(value = """
      select t from Token t inner join Usuario u\s
      on t.usuario.id = u.id\s
      where u.id = :id and (t.expirado = false or t.revocado = false)\s
      """)
  List<Token> findTokensValidosDeUsuario(UUID id);

  Optional<Token> findByToken(String token);
}
