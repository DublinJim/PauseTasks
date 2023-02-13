module com.example.pausetasks {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens com.example.pausetasks to javafx.fxml;
    exports com.example.pausetasks;
}