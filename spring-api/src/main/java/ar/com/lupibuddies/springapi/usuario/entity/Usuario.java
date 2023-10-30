package ar.com.lupibuddies.springapi.usuario.entity;

import ar.com.lupibuddies.springapi.token.entity.Token;
import ar.com.lupibuddies.springapi.usuario.enums.Rol;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String nombre;

  private String apellido;

  private String email;

  private String password;

  @Enumerated(EnumType.STRING)
  private Rol rol;

  @OneToMany(mappedBy = "usuario")
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return rol.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
