import React, { useState, useEffect } from "react";
import { Typography, Container, TextField, Button } from "@mui/material";
import axios from "axios";
const LoginPage = () => {
  // const [email, setEmail] = useState("");
  // const [password, setPassword] = useState("");
  const [animationClass, setAnimationClass] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const [credentials, setCredentials] = useState({
    email: "",
    password: "",
  });

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8080/v1/auth/autenticar",
        credentials
      );
      const { access_token, refresh_token } = response.data;
      localStorage.setItem("token", access_token);
      localStorage.setItem("refreshToken", refresh_token);
      console.log("token:", access_token);
      console.log(refresh_token);

      // Redirigir a la página de bienvenida
    } catch (error) {
      console.error("Error:", error.response);

      // Mostrar mensaje de error
      setErrorMessage(
        "Credenciales incorrectas. Por favor, inténtelo de nuevo."
      );
    }
  };

  useEffect(() => {
    const timeout = setTimeout(() => {
      setAnimationClass("appear");
    }, 100);
    return () => clearTimeout(timeout);
  }, []);

  // return (
  //   <form onSubmit={handleSubmit}>
  //     <input
  //       type="email"
  //       name="email"
  //       value={credentials.email}
  //       onChange={handleChange}
  //     />
  //     <input
  //       type="password"
  //       name="password"
  //       value={credentials.password}
  //       onChange={handleChange}
  //     />
  //     <button type="submit">Login</button>
  //   </form>
  // );

  return (
    <Container
      sx={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        minHeight: "100vh",
        background: `
    linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
    url(${process.env.PUBLIC_URL}/fotoLandingPage.jpg)
  `,
        backgroundSize: "cover",
        color: "#fff",
        textAlign: "center",
        minWidth: "100%",
      }}
    >
      <Typography
        variant="h2"
        sx={{
          fontSize: "2.5rem",
          marginBottom: "20px",
          opacity: 0,
          transform: "translateY(20px)",
          transition: "opacity 0.8s ease-in-out, transform 0.8s ease-in-out",
          "&.appear": {
            opacity: 1,
            transform: "translateY(0)",
          },
        }}
        className={animationClass}
      >
        ¡Bienvenido a nuestro sistema educativo!
      </Typography>
      <Typography
        sx={{
          opacity: 0,
          transform: "translateY(20px)",
          transition: "opacity 0.8s ease-in-out, transform 1.4s ease-in-out",
          "&.appear": {
            opacity: 1,
            transform: "translateY(0)",
          },
        }}
        className={animationClass}
      >
        Explora todas las características de nuestro sistema utilizando JSON Web
        Tokens.
      </Typography>
      <form
        onSubmit={handleSubmit}
        style={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          justifyContent: "center",
          marginTop: "20px",
        }}
      >
        <TextField
          label="Email"
          variant="outlined"
          sx={{
            marginBottom: "10px",
            backgroundColor: "gray",
            color: "#fff",
            transform: "translateY(20px)",
            transition: "opacity 0.8s ease-in-out, transform 1.8s ease-in-out",
            "&.appear": {
              transform: "translateY(0)",
            },
          }}
          value={credentials.email}
          className={animationClass}
          onChange={(e) =>
            setCredentials({ ...credentials, email: e.target.value })
          }
        />
        <TextField
          label="Password"
          variant="outlined"
          sx={{
            marginBottom: "10px",
            color: "#fff",
            backgroundColor: "gray",
            transform: "translateY(20px)",
            transition: "opacity 0.8s ease-in-out, transform 2.0s ease-in-out",
            "&.appear": {
              transform: "translateY(0)",
            },
          }}
          type="password"
          value={credentials.password}
          className={animationClass}
          onChange={(e) =>
            setCredentials({ ...credentials, password: e.target.value })
          }
        />
        <Button type="submit" variant="contained" sx={{ marginTop: "15px" }}>
          Iniciar Sesión
        </Button>{" "}
        {errorMessage && (
          <Typography sx={{ marginTop: "20px" }} variant="body2" color="error">
            {errorMessage}
          </Typography>
        )}
      </form>
    </Container>
  );
};

export default LoginPage;
