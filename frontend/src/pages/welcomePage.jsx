import {
  Container,
  Typography,
  TableContainer,
  Table,
  TableHead,
  TableRow,
  TableCell,
  TableBody,
  Paper,
  Button,
  TextField,
} from "@mui/material";
import { useState } from "react";

const Welcome = () => {
  const [alumnos, setAlumnos] = useState([
    { nombre: "Juan", materia: "Matemáticas", nota: 90 },
    { nombre: "Ana", materia: "Ciencias", nota: 95 },
    // ...
  ]);

  const [nuevoAlumno, setNuevoAlumno] = useState({
    nombre: "",
    materia: "",
    nota: 0,
  });

  const agregarAlumno = () => {
    setAlumnos([...alumnos, nuevoAlumno]);
    setNuevoAlumno({ nombre: "", materia: "", nota: 0 });
  };

  const eliminarAlumno = (nombre) => {
    setAlumnos(alumnos.filter((alumno) => alumno.nombre !== nombre));
  };

  const handleChangeNuevoAlumno = (field, value) => {
    setNuevoAlumno((prev) => ({ ...prev, [field]: value }));
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
      <Typography>
        En esta sección, vas a poder cargarle notas a tus alumnos.
      </Typography>
      <TextField
        label="Nombre del alumno"
        value={nuevoAlumno.nombre}
        onChange={(e) => handleChangeNuevoAlumno("nombre", e.target.value)}
      />
      <TextField
        label="Materia"
        value={nuevoAlumno.materia}
        onChange={(e) => handleChangeNuevoAlumno("materia", e.target.value)}
      />
      <TextField
        type="number"
        label="Nota"
        value={nuevoAlumno.nota}
        onChange={(e) =>
          handleChangeNuevoAlumno("nota", parseInt(e.target.value, 10))
        }
      />
      <Button onClick={agregarAlumno}>Agregar alumno</Button>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Nombre del alumno</TableCell>
              <TableCell>Materia</TableCell>
              <TableCell>Nota</TableCell>
              <TableCell>Acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {alumnos.map((alumno) => (
              <TableRow key={alumno.nombre}>
                <TableCell>{alumno.nombre}</TableCell>
                <TableCell>{alumno.materia}</TableCell>
                <TableCell>{alumno.nota}</TableCell>
                <TableCell>
                  <Button onClick={() => eliminarAlumno(alumno.nombre)}>
                    Eliminar
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Container>
  );
};

export default Welcome;
