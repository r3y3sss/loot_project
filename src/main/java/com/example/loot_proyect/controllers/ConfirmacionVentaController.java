package com.example.loot_proyect.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ConfirmacionVentaController {

    @FXML private Label lblProducto;
    @FXML private Label lblPrecio;
    @FXML private Label lblVendedor;

    public void setDatos(RegistroProductosController.Producto p) {
        lblProducto.setText("Producto: " + p.nombre);
        lblPrecio.setText(String.format("Precio: $%.2f", p.precio));
        // Muestra el teléfono del dueño original en la interfaz gráfica
        lblVendedor.setText("Teléfono del Vendedor: " + p.vendedor);
    }

    @FXML
    void btnConfirmarClick(ActionEvent event) {
        String telefono = lblVendedor.getText().replace("Teléfono del Vendedor: ", "");

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Compra Exitosa");
        alerta.setHeaderText(null);
        alerta.setContentText("¡Felicidades! Has adquirido este producto.\n\nPara acordar la entrega, comunícate al teléfono: " + telefono);
        alerta.showAndWait();

        regresarAlMenu(event);
    }

    @FXML
    void btnCancelarClick(ActionEvent event) {
        regresarAlMenu(event);
    }

    private void regresarAlMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loot_proyect/views/Ventas.fxml"));
            Parent root = loader.load();

            MenuVentasController controlador = loader.getController();
            controlador.cargarProductosRegistrados();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 550));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}