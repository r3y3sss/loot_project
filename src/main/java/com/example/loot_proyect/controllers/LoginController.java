package com.example.loot_proyect.controllers;

import com.example.loot_proyect.model.UsuarioEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
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

    @FXML
    void ID_INICIAR_SESION(ActionEvent event) {
        String correoIngresado = CorreoLogin.getText().trim();
        String contraIngresada = ContraseñaLogin.getText().trim();

        if (correoIngresado.isEmpty() || contraIngresada.isEmpty()) {
            mostrarAlerta("Campos Vacíos", "Ingresa tus datos.");
            return;
        }

        if (correoIngresado.equals("123") && contraIngresada.equals("123")) {
            usuarioLogueado = "123 (Admin)";
            irAlCatalogo(event);
            return;
        }




        boolean accesoConcedido = false;
        if (RegistroController.cuentaCreada) {
            for (RegistroController.Usuario u : RegistroController.listaUsuarios) {
                if (u.correo.equals(correoIngresado) && u.contrasenia.equals(contraIngresada)) {
                    usuarioLogueado = u.telefono;
                    accesoConcedido = true;
                    break;
                }
            }
        }

        if (accesoConcedido) {
            irAlCatalogo(event);
        } else {
            mostrarAlerta("Acceso Denegado", "Datos incorrectos o usuario no registrado.");
        }
    }

    @FXML
    void NOTIENESCONTRA(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loot_proyect/views/Registro.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 420);
            stage.setTitle("Marketplace - Registro de Usuarios");
            stage.setScene(scene);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loot_proyect/views/Ventas.fxml"));
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