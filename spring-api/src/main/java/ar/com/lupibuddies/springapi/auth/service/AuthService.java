package ar.com.lupibuddies.springapi.auth.service;

import ar.com.lupibuddies.springapi.auth.dto.AuthRequest;
import ar.com.lupibuddies.springapi.auth.dto.AuthResponse;
import ar.com.lupibuddies.springapi.auth.dto.RegistroRequest;
import ar.com.lupibuddies.springapi.token.service.TokenService;
import ar.com.lupibuddies.springapi.usuario.entity.Usuario;
import ar.com.lupibuddies.springapi.usuario.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UsuarioService usuarioService;
  private final TokenService tokenService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public AuthResponse registrar(RegistroRequest request) {
    Usuario usuario = Usuario.builder()
        .nombre(request.getNombre())
        .apellido(request.getApellido())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .rol(request.getRol())
        .build();
    usuarioService.save(usuario);
    return tokenService.generarTokenUsuario(usuario);
  }

  public AuthResponse autenticar(AuthRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.email(),
            request.password()
        )
    );
    Usuario usuario = usuarioService.findByEmail(request.email());
    return tokenService.generarTokenUsuario(usuario);
  }

  public void refrescarToken(HttpServletRequest request, HttpServletResponse response)
          throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    String refreshToken = authHeader.substring(7);
    String emailUsuario = tokenService.extraerEmailDeToken(refreshToken);
    if (emailUsuario == null) {
      return;
    }
    Usuario usuario = usuarioService.findByEmail(emailUsuario);
    if (tokenService.esTokenValido(refreshToken, usuario)) {
      AuthResponse authResponse = tokenService.generarTokenUsuario(usuario);
      new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
    }
  }
}
