# SDS-5K4-TPI-JWT
Trabajo Práctico Integrador para la asignatura Seguridad en el Desarrollo de Software, implementando autenticación y autorización con JWT.

## Cómo iniciar el proyecto

### Iniciar el servidor

1. Cree las variables de entorno:
- JWT_SECRET_KEY=clave secreta para firmar el token
- JWT_EXPIRATION=tiempo de expiración del token
- JWT_REFRESH=tiempo de refresco del token JWT
- DB_URL=jdbc:postgresql://localhost:5432/nombre_bd. Ejemplo: jdbc:postgresql://localhost:5432/sds
- DB_USERNAME=usuario de BD. Ejemplo: username
- DB_PASSWORD=contraseña de BD. Ejemplo: password
2. Navegue hasta el directorio del proyecto spring-boot en la terminal.
3. Levante la base de datos Postgres con el comando `docker compose up`
4. Conéctese a Postgres y crear la base de datos definida en la variable DB_URL.
5. Ejecute el comando `./mvnw spring-boot:run` para iniciar el servidor. El servidor se iniciará en `http://localhost:8080`.

### Iniciar la aplicación React

1. Navegue hasta el directorio del proyecto frontend en la terminal.
2. Ejecute el comando `npm install` para instalar todas las dependencias del proyecto.
3. Ejecute el comando `npm start` para iniciar la aplicación. La aplicación se iniciará en `http://localhost:3000`.

## Documentación de la API
Disponible en: http://localhost:8080/swagger-ui/index.html#/

## Arquitectura de Spring Security
🏰 Componentes clave:

1. Authenticator Manager 🤝:
- Responsable de validar las credenciales de los usuarios.
- Utiliza varios proveedores de autenticación (por ejemplo, LDAP, JDBC).

2. Security Context 📚:
- Almacena los detalles del usuario autenticado actualmente.
- Garantiza que la información de seguridad sea accesible en toda la aplicación.

3. Authentication Provider 🔑:
- Implementa el proceso de autenticación real.
- Admite múltiples mecanismos de autenticación (por ejemplo, nombre de usuario/contraseña, OAuth).

4. UserDetailsService 📖:
- Recupera información relacionada con el usuario (como roles y permisos) del almacén de datos.

5. Authorization 🚦:
- Controla el acceso a recursos específicos en función de los roles y permisos de los usuarios.
- Utiliza expresiones de control de acceso (ACL) para una autorización detallada.

🔄 Flujo de autenticación:

1. Filter Chain 🔗:
- Las solicitudes pasan por una serie de filtros.
- Cada filtro maneja un aspecto específico del proceso de autenticación.

2. Autenticación de nombre de usuario y contraseña 🔐:
- El inicio de sesión típico implica el 'UsernamePasswordAuthenticationFilter'.
- Valida las credenciales de usuario con el 'AuthenticationManager'.

3. Autenticación basada en tokens 🔑:
- Habilita la autenticación sin estado mediante tokens (por ejemplo, JWT).
- Ideal para la arquitectura de microservicios.

![Arquitectura Spring Security](spring_security.gif)

Créditos: https://amigoscode.com