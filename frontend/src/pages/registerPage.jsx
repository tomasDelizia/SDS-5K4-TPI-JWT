import React, { useState } from "react";
import {
  Typography,
  Container,
  TextField,
  Button,
  Select,
  MenuItem,
} from "@mui/material";

const RegisterPage = () => {
  const [nombre, setNombre] = useState("");
  const [apellido, setApellido] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [rol, setRol] = useState("");

  const handleChangeRol = (event) => {
    setRol(event.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch("http://localhost:8080/v1/auth/registrar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          nombre,
          apellido,
          email,
          password,
          rol,
        }),
      });

      if (!response.ok) {
        const errorMessage = await response.text();
        throw new Error(`Registration failed: ${errorMessage}`);
      }

      console.log("Registration successful!");
    } catch (error) {
      console.error(error.message);
    }
  };

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
      <Typography variant="h4" sx={{}}>
        ¡Regístrese en nuestro sistema!
      </Typography>

      <form onSubmit={handleSubmit}>
        <TextField
          sx={{
            backgroundColor: "gray",
            display: "flex",
            flexDirection: "column",
            marginTop: "15px",
          }}
          label="Nombre"
          variant="outlined"
          value={nombre}
          onChange={(e) => setNombre(e.target.value)}
        />
        <TextField
          sx={{
            backgroundColor: "gray",
            display: "flex",
            flexDirection: "column",
            marginTop: "15px",
            width: { xs: "200px", lg: "500px" },
          }}
          label="Apellido"
          variant="outlined"
          value={apellido}
          onChange={(e) => setApellido(e.target.value)}
        />
        <TextField
          sx={{
            backgroundColor: "gray",
            marginTop: "15px",
            width: { xs: "200px", lg: "500px" },
            display: "flex",
            flexDirection: "column",
          }}
          label="Email"
          variant="outlined"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <TextField
          sx={{
            backgroundColor: "gray",
            display: "flex",
            flexDirection: "column",
            marginTop: "15px",
            width: { xs: "200px", lg: "500px" },
          }}
          label="Password"
          variant="outlined"
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <Select
          sx={{
            backgroundColor: "gray",
            display: "flex",
            flexDirection: "column",
            marginTop: "15px",
            width: { xs: "200px", lg: "500px" },
          }}
          value={rol}
          onChange={handleChangeRol}
        >
          <MenuItem value="ADMIN">Administrador</MenuItem>
          <MenuItem value="USER">Usuario</MenuItem>
        </Select>
        <Button type="submit" variant="contained" sx={{ marginTop: "15px" }}>
          Registrar
        </Button>
      </form>
    </Container>
  );
};

export default RegisterPage;
