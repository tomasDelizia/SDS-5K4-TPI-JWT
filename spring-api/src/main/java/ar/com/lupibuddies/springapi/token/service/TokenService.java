package ar.com.lupibuddies.springapi.token.service;

import ar.com.lupibuddies.springapi.auth.dto.AuthResponse;
import ar.com.lupibuddies.springapi.config.JwtService;
import ar.com.lupibuddies.springapi.exceptions.RecursoNoEncontradoException;
import ar.com.lupibuddies.springapi.token.dao.TokenDAO;
import ar.com.lupibuddies.springapi.token.entity.Token;
import ar.com.lupibuddies.springapi.token.enums.TipoToken;
import ar.com.lupibuddies.springapi.usuario.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TokenService {
    private final TokenDAO tokenDAO;
    private JwtService jwtService;

    public AuthResponse generarTokenUsuario(Usuario usuario) {
        revocarTokensDeUsuario(usuario.getId());
        String tokenAcceso = generarTokenAccesoUsuario(usuario);
        String tokenRefresco = generarTokenRefrescoUsuario(usuario);
        saveTokenUsuario(tokenAcceso, usuario);
        return new AuthResponse(
                tokenAcceso,
                tokenRefresco
        );
    }

    private String generarTokenAccesoUsuario(Usuario usuario) {
        return jwtService.generateToken(usuario);
    }

    private String generarTokenRefrescoUsuario(Usuario usuario) {
        return jwtService.generateRefreshToken(usuario);
    }

    private void saveTokenUsuario(String tokenJwt, Usuario usuario) {
        Token token = Token.builder()
                .usuario(usuario)
                .token(tokenJwt)
                .tokenType(TipoToken.BEARER)
                .expirado(false)
                .revocado(false)
                .build();
        tokenDAO.save(token);
    }

    private void revocarTokensDeUsuario(Integer idUsuario) {
        List<Token> tokensValidos = tokenDAO.findTokensValidosDeUsuario(idUsuario);
        if (tokensValidos.isEmpty()) {
            return;
        }
        tokensValidos.forEach(Token::revocar);
        tokenDAO.saveAll(tokensValidos);
    }

    public String extraerEmailDeToken(String refreshToken) {
        return jwtService.extractUsername(refreshToken);
    }

    public boolean esTokenValido(String refreshToken, UserDetails usuario) {
        return jwtService.isTokenValid(refreshToken, usuario);
    }

    public Boolean esTokenValido(String jwt) {
        return tokenDAO.findByToken(jwt)
                .map(token -> !token.isExpirado() && !token.isRevocado())
                .orElse(false);
    }

    private Token findByToken(String jwt) throws RecursoNoEncontradoException {
        return tokenDAO.findByToken(jwt)
                .orElseThrow(()-> new RecursoNoEncontradoException("No se encontró el token."));
    }

    public void revocar(String jwt) {
        Token token = findByToken(jwt);
        token.revocar();
        tokenDAO.save(token);
    }
}
