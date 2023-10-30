package ar.com.lupibuddies.springapi.token.entity;

import ar.com.lupibuddies.springapi.token.enums.TipoToken;
import ar.com.lupibuddies.springapi.usuario.entity.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TipoToken tokenType = TipoToken.BEARER;

  public boolean revocado;

  public boolean expirado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "usuario_id")
  public Usuario usuario;

  public void revocar() {
    revocado = true;
    expirado = true;
  }
}
