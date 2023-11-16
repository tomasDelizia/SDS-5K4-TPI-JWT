import React, { useState } from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Container,
  Button,
  TextField,
} from "@mui/material";

const Library = () => {
  const [rowss, setRowss] = useState([]);
  const [newRow, setNewRow] = useState({ isbn: "", titulo: "", autor: "" });

  // Manejar cambios en los campos de entrada del nuevo libro
  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNewRow({ ...newRow, [name]: value });
  };

  // Agregar fila a la tabla
  const agregarFila = () => {
    // Validar que todos los campos estén completos antes de agregar la fila
    if (newRow.isbn && newRow.titulo && newRow.autor) {
      setRowss([...rowss, newRow]);
      setNewRow({ isbn: "", titulo: "", autor: "" });
    } else {
      alert("Por favor, complete todos los campos.");
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
      <h1>Cargue sus libros aquí</h1>
      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>ISBN</TableCell>
              <TableCell>Título</TableCell>
              <TableCell>Autor</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rowss.map((row) => (
              <TableRow key={row.isbn}>
                <TableCell>{row.isbn}</TableCell>
                <TableCell>{row.titulo}</TableCell>
                <TableCell>{row.autor}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      {/* Formulario para agregar una nueva fila */}
      <form>
        <TextField
          sx={{
            backgroundColor: "gray",
            display: "flex",
            flexDirection: "column",
            marginTop: "15px",
            width: { xs: "200px", lg: "500px" },
          }}
          label="ISBN"
          name="isbn"
          value={newRow.isbn}
          onChange={handleInputChange}
        />
        <TextField
          sx={{
            backgroundColor: "gray",
            display: "flex",
            flexDirection: "column",
            marginTop: "15px",
            width: { xs: "200px", lg: "500px" },
          }}
          label="Título"
          name="titulo"
          value={newRow.titulo}
          onChange={handleInputChange}
        />
        <TextField
          sx={{
            backgroundColor: "gray",
            display: "flex",
            flexDirection: "column",
            marginTop: "15px",
            width: { xs: "200px", lg: "500px" },
          }}
          label="Autor"
          name="autor"
          value={newRow.autor}
          onChange={handleInputChange}
        />
        <Button
          type="button"
          variant="contained"
          sx={{ marginTop: "15px" }}
          onClick={agregarFila}
        >
          Agregar
        </Button>
      </form>
    </Container>
  );
};

export default Library;
