package ar.com.lupibuddies.springapi.auth.dto;

import ar.com.lupibuddies.springapi.usuario.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistroRequest {

  private String nombre;
  private String apellido;
  private String email;
  private String password;
  private Rol rol;
}
