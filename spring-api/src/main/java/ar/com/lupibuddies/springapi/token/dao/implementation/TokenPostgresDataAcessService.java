package ar.com.lupibuddies.springapi.token.dao.implementation;

import ar.com.lupibuddies.springapi.token.dao.TokenDAO;
import ar.com.lupibuddies.springapi.token.dao.repository.TokenRepository;
import ar.com.lupibuddies.springapi.token.entity.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TokenPostgresDataAcessService implements TokenDAO {
    private final TokenRepository tokenRepository;

    @Override
    public List<Token> findTokensValidosDeUsuario(Integer idUsuario) {
        return tokenRepository.findTokensValidosDeUsuario(idUsuario);
    }

    @Override
    public Optional<Token> findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void save(Token token) {
        tokenRepository.save(token);
    }

    @Override
    public void saveAll(List<Token> tokens) {
        tokenRepository.saveAll(tokens);
    }
}
