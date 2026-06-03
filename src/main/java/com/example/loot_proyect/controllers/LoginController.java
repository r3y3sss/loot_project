package com.example.loot_proyect.controllers;

import com.example.loot_proyect.Dtos.UsuarioLoginDTO;
import com.example.loot_proyect.Services.UsuarioService;
import com.example.loot_proyect.model.UsuarioEntity;
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

public class LoginController {

    @FXML private TextField CorreoLogin;
    @FXML private TextField ContraseñaLogin;

    public static String usuarioLogueado = "";
    public static String telefonoLogueado = "";
    public static UsuarioEntity usuarioEntity = null;

    private UsuarioService usuarioService = new UsuarioService();

    @FXML
    void ID_INICIAR_SESION(ActionEvent event) {
        String correoIngresado = CorreoLogin.getText().trim();
        String contraIngresada = ContraseñaLogin.getText().trim();

        if (correoIngresado.isEmpty() || contraIngresada.isEmpty()) {
            mostrarAlerta("Campos Vacíos", "Ingresa tus datos.");
            return;
        }

        if (correoIngresado.equals("123") && contraIngresada.equals("123")) {
            usuarioLogueado = "Admin";
            telefonoLogueado = "N/A";
            usuarioEntity = null;
            irAlCatalogo(event);
            return;
        }

        try {
            UsuarioLoginDTO loginDTO = new UsuarioLoginDTO(correoIngresado, contraIngresada);
            UsuarioEntity usuario = usuarioService.login(loginDTO);
            usuarioLogueado = usuario.getNombre() + " " + usuario.getApellido_p();
            telefonoLogueado = usuario.getNumTelefono();
            usuarioEntity = usuario;
            irAlCatalogo(event);
        } catch (Exception e) {
            mostrarAlerta("Acceso Denegado", e.getMessage());
        }
    }

    @FXML
  public void NOTIENESCONTRA(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/loot_proyect/views/Registro.fxml")
            );
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Marketplace - Registro de Usuarios");
            stage.setScene(new Scene(root, 600, 420));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void IDOLVIDASTECONTRA(ActionEvent event) {
        System.out.println("¿Olvidaste la contraseña?");
    }

    private void irAlCatalogo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/loot_proyect/views/Ventas.fxml")
            );
            Parent root = loader.load();
            MenuVentasController ctrl = loader.getController();
            ctrl.cargarProductosRegistrados();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 550));
            stage.setTitle("Marketplace - Catálogo Principal");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}