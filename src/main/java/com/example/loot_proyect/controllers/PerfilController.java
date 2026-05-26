package com.example.loot_proyect.controllers;

import com.example.loot_proyect.Services.UsuarioService;
import com.example.loot_proyect.model.UsuarioEntity;
import com.example.loot_proyect.utils.HibernateUtils;
import jakarta.persistence.EntityManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class PerfilController {

    @FXML private TextField txtCorreoPerfil;
    @FXML private TextField txtNombrePerfil;
    @FXML private TextField txtTelefonoPerfil;
    @FXML private Button btnEditar;

    private UsuarioService usuarioService = new UsuarioService();
    private boolean modoEdicion = false;

    @FXML
    public void initialize() {
        if ("Admin".equals(LoginController.usuarioLogueado)) {
            txtCorreoPerfil.setText("admin@marketplace.com");
            txtNombrePerfil.setText("ADMINISTRADOR LOCAL");
            txtTelefonoPerfil.setText("123");
            return;
        }

        UsuarioEntity u = LoginController.usuarioEntity; // ← usa el usuario guardado
        if (u != null) {
            txtCorreoPerfil.setText(u.getCorreo());
            txtNombrePerfil.setText(u.getNombre() + " " + u.getApellido_p());
            txtTelefonoPerfil.setText(u.getNumTelefono());
        }
    }

    @FXML
    void btnEditarClick(ActionEvent event) {
        if (!modoEdicion) {
            txtNombrePerfil.setEditable(true);
            txtTelefonoPerfil.setEditable(true);
            txtNombrePerfil.setStyle("-fx-background-color: #fff9c4;");
            txtTelefonoPerfil.setStyle("-fx-background-color: #fff9c4;");
            ((Button) event.getSource()).setText("Guardar");
            modoEdicion = true;
        } else {
            String correoActual = LoginController.usuarioEntity.getCorreo(); // ← correo real
            String nuevoNombre = txtNombrePerfil.getText().trim();
            String nuevoTelefono = txtTelefonoPerfil.getText().trim();

            if (nuevoNombre.isEmpty() || nuevoTelefono.isEmpty()) {
                mostrarAlerta("Error", "Los campos no pueden estar vacíos.");
                return;
            }

            EntityManager em = HibernateUtils.getEntityManagerFactory().createEntityManager();
            try {
                em.getTransaction().begin();
                UsuarioEntity usuario = em.createQuery(
                                "SELECT u FROM UsuarioEntity u WHERE u.correo = :correo", UsuarioEntity.class)
                        .setParameter("correo", correoActual)
                        .getSingleResult();

                usuario.setNombre(nuevoNombre);
                usuario.setNumTelefono(nuevoTelefono);
                em.getTransaction().commit();

                // ← actualiza también el entity en memoria
                LoginController.usuarioEntity.setNombre(nuevoNombre);
                LoginController.usuarioEntity.setNumTelefono(nuevoTelefono);
                LoginController.usuarioLogueado = nuevoNombre;
                LoginController.telefonoLogueado = nuevoTelefono;

                mostrarAlerta("Éxito", "Perfil actualizado correctamente.");
            } catch (Exception e) {
                if (em.getTransaction().isActive()) em.getTransaction().rollback();
                mostrarAlerta("Error", "No se pudo actualizar: " + e.getMessage());
            } finally {
                em.close();
            }

            txtNombrePerfil.setEditable(false);
            txtTelefonoPerfil.setEditable(false);
            txtNombrePerfil.setStyle("");
            txtTelefonoPerfil.setStyle("");
            ((Button) event.getSource()).setText("Editar Usuario");
            modoEdicion = false;
        }
    }

    @FXML
    void btnAtrasClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/loot_proyect/views/Ventas.fxml")
            );
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
    void btnCerrarSesionClick(ActionEvent event) {
        LoginController.usuarioLogueado = "";
        LoginController.telefonoLogueado = "";
        LoginController.usuarioEntity = null; // ← limpia todo al cerrar sesión
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