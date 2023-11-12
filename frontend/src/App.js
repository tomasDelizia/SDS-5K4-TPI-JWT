import React from "react";
import { Button, Typography, Container } from "@mui/material";

const App = () => {
  const styles = {
    root: {
      display: "flex",
      flexDirection: "column",
      alignItems: "center",
      justifyContent: "center",
      minHeight: "100vh",
      backgroundColor: "#2196f3",
      color: "#fff",
      textAlign: "center",
      minWidth: "100%",
    },
    title: {
      fontSize: "2.5rem",
      marginBottom: "20px",
    },
    button: {
      marginTop: "20px",
      backgroundColor: "#f44336",
      color: "#fff",
    },
  };

  return (
    <Container style={styles.root}>
      <Typography variant="h2" style={styles.title}>
        ¡Bienvenido a nuestro sistema de JWT!
      </Typography>
      <Typography>
        Explora todas las características de nuestro sistema utilizando JSON Web
        Tokens.
      </Typography>
      <Button variant="contained" style={styles.button}>
        Comenzar
      </Button>
    </Container>
  );
};

export default App;
