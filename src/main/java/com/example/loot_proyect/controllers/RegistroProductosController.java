package com.example.loot_proyect.controllers;

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
import java.util.ArrayList;
import java.util.List;

public class RegistroProductosController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;
    @FXML private TextArea txtDescripcion;
    @FXML private ComboBox<String> cmbCategoria;

    public static List<Producto> listaProductos = new ArrayList<>();

    public static class Producto {
        public String nombre;
        public String descripcion;
        public double precio;
        public String categoria;
        public String vendedor;

        public Producto(String nombre, String descripcion, double precio, String categoria, String vendedor) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.categoria = categoria;
            this.vendedor = vendedor;
        }
    }

    @FXML
    public void initialize() {
        if (cmbCategoria != null) {
            ObservableList<String> deAltas = FXCollections.observableArrayList(
                    "Electrónica", "Ropa y Calzado", "Hogar", "Videojuegos", "Otros"
            );
            cmbCategoria.setItems(deAltas);
        }
    }

    @FXML
    void btnGuardarClick(ActionEvent event) {
        try {
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            String categoria = cmbCategoria.getValue();

            if (categoria == null || categoria.isEmpty()) {
                categoria = "Otros";
            }

            listaProductos.add(new Producto(nombre, descripcion, precio, categoria, LoginController.usuarioLogueado));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loot_proyect_views/Ventas.fxml"));
            Parent root = loader.load();

            MenuVentasController controladorVentas = loader.getController();
            controladorVentas.cargarProductosRegistrados();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 800, 550);
            stage.setTitle("Marketplace - Catálogo Principal");
            stage.setScene(scene);
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
}