package com.example.loot_proyect.controllers;

import com.example.loot_proyect.Dtos.ProductoDTO;
import com.example.loot_proyect.Services.ProductoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class MenuVentasController {

    @FXML private VBox contenedorCatalogo;

    private ProductoService productoService = new ProductoService();

    public void cargarProductosRegistrados() {
        if (contenedorCatalogo != null) {
            contenedorCatalogo.getChildren().clear();

            List<ProductoDTO> productos = productoService.buscarProducto();
            for (ProductoDTO p : productos) {
                agregarProductoAlCatalogo(p);
            }
        }
    }

    public void agregarProductoAlCatalogo(ProductoDTO p) {
        HBox filaProducto = new HBox(20);
        filaProducto.setAlignment(Pos.CENTER_LEFT);
        filaProducto.setStyle("-fx-background-color: white; -fx-padding: 15; -fx-background-radius: 10;");

        VBox seccionTextos = new VBox(5);
        HBox.setHgrow(seccionTextos, Priority.ALWAYS);

        Label lblNombre = new Label(p.nombre());
        lblNombre.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        Label lblDesc = new Label(p.descripcion());
        lblDesc.setWrapText(true);

        seccionTextos.getChildren().addAll(lblNombre, lblDesc);

        VBox seccionPrecio = new VBox(10);
        seccionPrecio.setAlignment(Pos.CENTER_RIGHT);
        Label lblPrecio = new Label(String.format("$%.2f", p.precio()));
        lblPrecio.setStyle("-fx-font-weight: bold; -fx-text-fill: #2ca045;");

        Button btnComprar = new Button("Comprar");
        btnComprar.setStyle("-fx-background-color: #005088; -fx-text-fill: white;");
        btnComprar.setOnAction(e -> abrirConfirmacion((ActionEvent) e, p));

        seccionPrecio.getChildren().addAll(lblPrecio, btnComprar);
        filaProducto.getChildren().addAll(seccionTextos, seccionPrecio);
        contenedorCatalogo.getChildren().add(filaProducto);
    }

    private void abrirConfirmacion(ActionEvent event, ProductoDTO p) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/loot_proyect/views/ConfirmacionVenta.fxml")
            );
            Parent root = loader.load();
            ConfirmacionVentaController ctrl = loader.getController();
            ctrl.setDatos(p);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void IrARegistroProducto(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/loot_proyect/views/RegistroProductos.fxml")
            );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    void Regresarclick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/loot_proyect/views/login.fxml")
            );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    void IrAPerfil(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/loot_proyect/views/Perfil.fxml")
            );
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) { e.printStackTrace(); }
    }
    public void
}