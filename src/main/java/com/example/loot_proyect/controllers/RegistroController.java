package com.example.loot_proyect.controllers;

import com.example.loot_proyect.Dtos.UsuarioRegistroDTO;
import com.example.loot_proyect.Services.UsuarioService;
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

public class RegistroController {

    @FXML private TextField CorreoRegistro;
    @FXML private TextField NombreRegistro;
    @FXML private TextField ApellidoPRegistro;
    @FXML private TextField ApellidoMRegistro;
    @FXML private PasswordField ContraseñaRegistro;
    @FXML private PasswordField ConfirmarContraseñaRegistro;
    @FXML private TextField NumeroRegistro;
    @FXML private TextField DireccionRegistro;
    private UsuarioService usuarioService = new UsuarioService();

    @FXML
    void id_confirmar(ActionEvent event) {
        String correo = CorreoRegistro.getText().trim();
        String nombre = NombreRegistro.getText().trim();
        String apellidoP = ApellidoPRegistro.getText().trim();
        String apellidoM = ApellidoMRegistro.getText().trim();
        String contra = ContraseñaRegistro.getText().trim();
        String confirmar = ConfirmarContraseñaRegistro.getText().trim();
        String telefono = NumeroRegistro.getText().trim();
        String direccion = DireccionRegistro.getText().trim();

        if (correo.isEmpty() || nombre.isEmpty() || contra.isEmpty() || telefono.isEmpty()) {
            mostrarAlerta("Campos Vacíos", "Por favor rellena todos los campos.");
            return;
        }

        if (!contra.equals(confirmar)) {
            mostrarAlerta("Error", "Las contraseñas no coinciden.");
            return;
        }

        try {
            UsuarioRegistroDTO registroDTO = new UsuarioRegistroDTO(
                    correo, nombre, apellidoP, apellidoM, contra, telefono, direccion
            );
            usuarioService.registroUsuario(registroDTO);
            mostrarAlerta("Éxito", "Usuario registrado correctamente.");
            regresarAlLogin(event);
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo registrar: " + e.getMessage());
        }
    }

    private void regresarAlLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/loot_proyect/views/login.fxml")
            );
            Parent root = loader.load();
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