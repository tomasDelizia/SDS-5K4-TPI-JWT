// App.js
import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import LoginPage from "./pages/loginPage.jsx";
import Welcome from "./pages/welcomePage.jsx";
import { Switch } from "react";

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<LoginPage />} />
      <Route path="/welcomePage" element={<Welcome />} />
    </Routes>
  );
};

export default App;
