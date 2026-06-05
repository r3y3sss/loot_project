package com.example.loot_proyect.controllers;

import com.example.loot_proyect.Dtos.ProductoDTO;
import com.example.loot_proyect.Services.ProductoService;
import com.example.loot_proyect.model.ProductoEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class RegistroProductosController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextArea txtDescripcion;
    @FXML private ComboBox<String> cmbCategoria;

    public static ProductoEntity productoEntity = null;

    private ProductoService productoService = new ProductoService();

    @FXML
    public void initialize() {
        if (cmbCategoria != null) {
            ObservableList<String> categorias = FXCollections.observableArrayList(
                    "Electrónica", "Ropa y Calzado", "Hogar", "Videojuegos", "Otros"
            );
            cmbCategoria.setItems(categorias);
        }
    }

    @FXML
    void btnGuardarClick(ActionEvent event) {
        try {
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            float precio = Float.parseFloat(txtPrecio.getText().trim());

            ProductoDTO dto = new ProductoDTO(0,nombre, descripcion, precio, null, "", "");
            ProductoEntity producto = productoService.agregarProducto(dto);
            productoEntity = producto;

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

        } catch (NumberFormatException e) {
            System.out.println("Error: ¡El precio debe ser un número válido!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLimpiarClick(ActionEvent event) {
        txtNombre.clear();
        txtPrecio.clear();
        txtDescripcion.clear();
        if (cmbCategoria != null) {
            cmbCategoria.getSelectionModel().clearSelection();
        }
    }

    @FXML
    void btnRegresar(ActionEvent event){
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
}