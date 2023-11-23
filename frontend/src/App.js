// App.js
import React from "react";
import { Route, Routes } from "react-router-dom";
import LoginPage from "./pages/loginPage.jsx";
import RegisterPage from "./pages/registerPage.jsx";
import Library from "./pages/library.jsx";

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<LoginPage />} />
      <Route path="/registerPage" element={<RegisterPage />} />
      <Route path="/libraryPage" element={<Library />} />
    </Routes>
  );
};

export default App;
