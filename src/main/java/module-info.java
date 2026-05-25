module com.example.loot_proyect {

    requires javafx.controls;
    requires javafx.fxml;

    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.sql;

    opens com.example.loot_proyect to javafx.fxml;
    opens com.example.loot_proyect.controllers to javafx.fxml;
    opens com.example.loot_proyect.model
            to javafx.fxml,
            org.hibernate.orm.core;

    exports com.example.loot_proyect;
    exports com.example.loot_proyect.model;
}