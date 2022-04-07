module com.example.conversion {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.conversion to javafx.fxml;
    exports com.example.conversion;
}