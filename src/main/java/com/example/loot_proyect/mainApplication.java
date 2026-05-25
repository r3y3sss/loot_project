package com.example.loot_proyect;

import com.example.loot_proyect.utils.HibernateUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class mainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println(mainApplication.class.getResource("/com/example/loot_proyect/views/login.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(
                mainApplication.class.getResource("/com/example/loot_proyect/views/login.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Loot Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        HibernateUtils.closeEntityManagerFactory();
    }

    public static void main(String[] args) {
        HibernateUtils.getEntityManagerFactory();
        launch();
    }
}