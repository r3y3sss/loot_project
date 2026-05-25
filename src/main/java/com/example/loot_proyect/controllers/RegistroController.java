package com.example.loot_proyect.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroController {

    @FXML private TextField CorreoRegistro;
    @FXML private PasswordField ContraseñaRegistro;
    @FXML private TextField NumeroRegistro;

    public static class Usuario {
        public String correo;
        public String contrasenia;
        public String telefono;

        public Usuario(String correo, String contrasenia, String telefono) {
            this.correo = correo;
            this.contrasenia = contrasenia;
            this.telefono = telefono;
        }
    }

    public static List<Usuario> listaUsuarios = new ArrayList<>();
    public static boolean cuentaCreada = false;

    @FXML
    void id_confirmar(ActionEvent event) {
        String correo = CorreoRegistro.getText().trim();
        String contra = ContraseñaRegistro.getText().trim();
        String telefono = NumeroRegistro.getText().trim();

        if (correo.isEmpty() || contra.isEmpty() || telefono.isEmpty()) {
            mostrarAlerta("Campos Vacíos", "Por favor rellena todos los campos.");
            return;
        }

        listaUsuarios.add(new Usuario(correo, contra, telefono));
        cuentaCreada = true;

        mostrarAlerta("Éxito", "Usuario registrado correctamente.");
        regresarAlLogin(event);
    }

    private void regresarAlLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/loot_proyect/views/login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.setTitle("Marketplace - Inicio de Sesión");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}