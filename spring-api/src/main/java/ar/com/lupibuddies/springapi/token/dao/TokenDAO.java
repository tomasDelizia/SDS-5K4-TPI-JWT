package ar.com.lupibuddies.springapi.token.dao;

import ar.com.lupibuddies.springapi.token.entity.Token;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenDAO {
    List<Token> findTokensValidosDeUsuario(UUID idUsuario);

    Optional<Token> findByToken(String token);
    void save(Token token);

    void saveAll(List<Token> tokens);
}
