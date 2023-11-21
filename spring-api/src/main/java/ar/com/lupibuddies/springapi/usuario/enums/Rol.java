package ar.com.lupibuddies.springapi.usuario.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ar.com.lupibuddies.springapi.usuario.enums.Permiso.ADMIN_CREATE;
import static ar.com.lupibuddies.springapi.usuario.enums.Permiso.ADMIN_DELETE;
import static ar.com.lupibuddies.springapi.usuario.enums.Permiso.ADMIN_READ;
import static ar.com.lupibuddies.springapi.usuario.enums.Permiso.ADMIN_UPDATE;

@Getter
@RequiredArgsConstructor
public enum Rol {

  USER(Collections.emptySet()),
  ADMIN(
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE
          )
  );

  private final Set<Permiso> permisos;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermisos()
            .stream()
            .map(permiso -> new SimpleGrantedAuthority(permiso.getPermiso()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
