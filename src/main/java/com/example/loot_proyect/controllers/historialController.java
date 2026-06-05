package com.example.loot_proyect.controllers;

import com.example.loot_proyect.Dtos.HistorialDTO;
import com.example.loot_proyect.Services.VentaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;
import java.util.List;

public class historialController {
    @FXML private TableView<HistorialDTO> tblHistory;
    @FXML private TableColumn<HistorialDTO, String> colFecha;
    @FXML private TableColumn<HistorialDTO, String> colProducto;
    @FXML private TableColumn<HistorialDTO, Double> colPrecio;
    private VentaService ventaService = new VentaService();

    @FXML
    public void initialize() {

        colFecha.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().fechaProducto()));

        colProducto.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().nombreProducto()));

        colPrecio.setCellValueFactory(data ->
                new SimpleDoubleProperty(data.getValue().precio()).asObject());

        int idUsuario = LoginController.usuarioEntity.getId_usuario();

        ObservableList<HistorialDTO> historial =
                FXCollections.observableArrayList(
                        ventaService.obtenerHistorialUsuario(idUsuario)
                );

        tblHistory.setItems(historial);
    }

    @FXML
    void btnRegresar(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/loot_proyect/views/Perfil.fxml")
            );
            Parent root = loader.load();
            PerfilController controladorPerfil = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Perfil");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
