package com.example.loot_proyect.controllers;

import com.example.loot_proyect.Dtos.ProductoDTO;
import com.example.loot_proyect.Dtos.VentaDTO;
import com.example.loot_proyect.Services.VentaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.time.LocalDate;

public class ConfirmacionVentaController {

    @FXML private Label lblProducto;
    @FXML private Label lblPrecio;
    @FXML private Label lblVendedor;

    private ProductoDTO productoActual;
    private VentaService ventaService = new VentaService();

    public void setDatos(ProductoDTO p) {
        productoActual = p;
        lblProducto.setText("Producto: " + p.nombre());
        lblPrecio.setText(String.format("Precio: $%.2f", p.precio()));
        lblVendedor.setText("Vendedor: " + p.nombreVendedor() + " | Tel: " + p.telefonoVendedor());
    }

    @FXML
    void btnConfirmarClick(ActionEvent event) {
        try {
            VentaDTO ventaDTO = new VentaDTO(
                    0,
                    LocalDate.now(),
                    1,
                    (double) productoActual.precio(),
                    productoActual.id_producto()
            );
            ventaService.GuardarVenta(ventaDTO);

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Compra Exitosa");
            alerta.setHeaderText(null);
            alerta.setContentText("¡Felicidades! Has adquirido: " + productoActual.nombre()
                    + "\nVendedor: " + productoActual.nombreVendedor()
                    + "\nTeléfono: " + productoActual.telefonoVendedor());
            alerta.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }

        regresarAlMenu(event);
    }

    @FXML
    void btnCancelarClick(ActionEvent event) {
        regresarAlMenu(event);
    }

    private void regresarAlMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/loot_proyect/views/Ventas.fxml")
            );
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