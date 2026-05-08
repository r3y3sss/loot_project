module com.example.loot_proyect {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.loot_proyect to javafx.fxml;
    exports com.example.loot_proyect;
}