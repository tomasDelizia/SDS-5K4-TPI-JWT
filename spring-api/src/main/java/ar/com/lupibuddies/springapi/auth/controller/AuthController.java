package ar.com.lupibuddies.springapi.auth.controller;

import ar.com.lupibuddies.springapi.auth.dto.AuthRequest;
import ar.com.lupibuddies.springapi.auth.dto.AuthResponse;
import ar.com.lupibuddies.springapi.auth.dto.RegistroRequest;
import ar.com.lupibuddies.springapi.auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping("/registrar")
  public AuthResponse registrar(
          @RequestBody RegistroRequest request
  ) {
    return authService.registrar(request);
  }
  @PostMapping("/autenticar")
  public AuthResponse autenticar(
          @RequestBody AuthRequest request
  ) {
    return authService.autenticar(request);
  }

  @PostMapping("/refrescar-token")
  public void refrescarToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    authService.refrescarToken(request, response);
  }
}
