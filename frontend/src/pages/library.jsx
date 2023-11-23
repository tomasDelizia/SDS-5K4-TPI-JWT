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

import { useEffect } from "react";

import { jwtDecode } from "jwt-decode";

const Library = () => {
  const [rowss, setRowss] = useState([]);
  const [newRow, setNewRow] = useState({
    isbn: "",
    titulo: "",
    autor: "",
    editorial: "",
    fechaLanzamiento: "",
  });

  // Manejar cambios en los campos de entrada del nuevo libro
  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNewRow({ ...newRow, [name]: value });
  };

  const esAdmin = () => {
    const authToken = localStorage.getItem("token");
    const decoded = jwtDecode(authToken);
    const esAdmin = decoded.custom_claims.includes("ROLE_ADMIN");
    return esAdmin;
  }

  const getBooks = async () => {
    const authToken = localStorage.getItem("token");
    try {
      const response = await fetch("http://localhost:8080/v1/libros", {
        method: "GET",
        headers: {
          Authorization: `Bearer ${authToken}`,
        },
      });

      if (!response.ok) {
        const errorMessage = await response.text();
        console.error("Error en la solicitud GET:", errorMessage);
      } else {
        const data = await response.json();
        setRowss(data);
      }
    } catch (error) {
      console.error("Error en la solicitud GET:", error.message);
    }
  };

  useEffect(() => {
    getBooks();
  }, []);

  const handleDelete = async (id) => {
    const authToken = localStorage.getItem("token");

    try {
      const response = await fetch(`http://localhost:8080/v1/libros/${id}`, {
        method: "DELETE",
        headers: {
          Authorization: `Bearer ${authToken}`,
        },
      });
      if (!response.ok) {
        const errorMessage = await response.text();
        console.error("Error en la solicitud DELETE:", errorMessage);
      } else {
        console.log("Eliminación exitosa!");
        getBooks();
      }
    } catch (error) {
      console.error("Error en la solicitud DELETE:", error.message);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (
      newRow.isbn.trim() === "" ||
      newRow.titulo.trim() === "" ||
      newRow.autor.trim() === "" ||
      newRow.editorial.trim() === "" ||
      newRow.fechaLanzamiento.trim() === ""
    ) {
      console.error("Por favor, complete todos los campos.");
      return;
    }

    const authToken = localStorage.getItem("token");

    try {
      const response = await fetch("http://localhost:8080/v1/libros", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${authToken}`,
        },
        body: JSON.stringify({
          isbn: newRow.isbn,
          titulo: newRow.titulo,
          autor: newRow.autor,
          editorial: newRow.editorial,
          fechaLanzamiento: newRow.fechaLanzamiento,
        }),
      });

      if (!response.ok) {
        const errorMessage = await response.text();
        console.error("Error en la solicitud POST:", errorMessage);
      } else {
        console.log("Registro exitoso!");
        getBooks();
        setNewRow({
          isbn: "",
          titulo: "",
          autor: "",
          editorial: "",
          fechaLanzamiento: "",
        });
      }
    } catch (error) {
      console.error("Error en la solicitud POST:", error.message);
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
              <TableCell>Editorial</TableCell>
              <TableCell>Fecha Lanzamiento</TableCell>
             {esAdmin() ? <TableCell>Acciones</TableCell> : <TableCell></TableCell>} 
              
            </TableRow>
          </TableHead>
          <TableBody>
            {rowss.map((row) => (
              <TableRow key={row.isbn}>
                <TableCell>{row.isbn}</TableCell>
                <TableCell>{row.titulo}</TableCell>
                <TableCell>{row.autor}</TableCell>
                <TableCell>{row.editorial}</TableCell>
                <TableCell>{row.fechaLanzamiento}</TableCell>
                {esAdmin() ? <TableCell>
                  <Button
                    variant="contained"
                    color="secondary"
                    onClick={() => handleDelete(row.id)}
                  >
                    Eliminar
                  </Button>
                </TableCell> : <TableCell></TableCell>}
                
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      {/* Formulario para agregar un nuevo libro  */}
      {esAdmin() ? <form onSubmit={handleSubmit}>
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
          label="Editorial"
          name="editorial"
          value={newRow.editorial}
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

        <TextField
          sx={{
            backgroundColor: "gray",
            display: "flex",
            flexDirection: "column",
            marginTop: "15px",
            width: { xs: "200px", lg: "500px" },
          }}
          label="Fecha de Lanzamiento"
          name="fechaLanzamiento"
          value={newRow.fechaLanzamiento}
          onChange={handleInputChange}
        />

        <Button type="submit" variant="contained" sx={{ marginTop: "15px" }}>
          Agregar
        </Button>
      </form> : <h2></h2>}
      
    </Container>
  );
};

export default Library;
