package com.example.loot_proyect.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class PerfilController {

    @FXML private TextField txtCorreoPerfil;
    @FXML private TextField txtNombrePerfil;
    @FXML private TextField txtTelefonoPerfil;

    @FXML
    public void initialize() {

        String telefonoActual = LoginController.usuarioLogueado;


        boolean encontrado = false;
        if (RegistroController.cuentaCreada) {
            for (RegistroController.Usuario u : RegistroController.listaUsuarios) {
                if (u.telefono.equals(telefonoActual)) {
                    txtCorreoPerfil.setText(u.correo);
                    txtTelefonoPerfil.setText(u.telefono);


                    encontrado = true;
                    break;
                }
            }
        }

    //pruebaxpress
        if (!encontrado && "123 (Admin)".equals(telefonoActual)) {
            txtCorreoPerfil.setText("admin@marketplace.com");
            txtNombrePerfil.setText("ADMINISTRADOR LOCAL");
            txtTelefonoPerfil.setText("123");

        }
    }

    @FXML
    void btnAtrasClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loot_proyect/views/Ventas.fxml"));
            Parent root = loader.load();

            MenuVentasController controladorVentas = loader.getController();
            controladorVentas.cargarProductosRegistrados();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 550));
            stage.setTitle("Marketplace - Catálogo Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnEditarClick(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mantenimiento");
        alerta.setHeaderText(null);
        alerta.setContentText("La función para editar los campos de tu cuenta estará disponible en la siguiente versión.");
        alerta.showAndWait();
    }

    @FXML
    void btnCerrarSesionClick(ActionEvent event) {
        LoginController.usuarioLogueado = "";

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
}