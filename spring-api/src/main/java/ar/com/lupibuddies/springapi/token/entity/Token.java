package ar.com.lupibuddies.springapi.token.entity;

import ar.com.lupibuddies.springapi.token.enums.TipoToken;
import ar.com.lupibuddies.springapi.usuario.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

  @Id
  @GeneratedValue
  public Integer id;

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
