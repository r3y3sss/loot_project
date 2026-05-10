package com.example.loot_proyect;

import com.example.loot_proyect.utils.HibernateUtils;
import javafx.application.Application;
import javafx.stage.Stage;

public class mainApplication extends Application {



    @Override
    public void start(Stage primaryStage) {
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        HibernateUtils.closeEntityManagerFactory();
    }

    public static void main(String[] args) {
        HibernateUtils.getEntityManagerFactory();
        launch();
    }
}
