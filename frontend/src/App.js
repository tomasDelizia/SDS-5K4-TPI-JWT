import React, { useState, useEffect } from "react";
import { Button, Typography, Container, TextField } from "@mui/material";

const App = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [animationClass, setAnimationClass] = useState("");

  useEffect(() => {
    const timeout = setTimeout(() => {
      setAnimationClass("appear");
    }, 100);
    return () => clearTimeout(timeout);
  }, []);

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
          value={username}
          className={animationClass}
          onChange={(e) => setUsername(e.target.value)}
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
          value={password}
          className={animationClass}
          onChange={(e) => setPassword(e.target.value)}
        />

        <Button
          variant="contained"
          sx={{ marginTop: "20px", backgroundColor: "#f44336", color: "#fff" }}
        >
          Login
        </Button>
      </form>
    </Container>
  );
};

export default App;
