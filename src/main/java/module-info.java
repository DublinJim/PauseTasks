module com.example.pausetasks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pausetasks to javafx.fxml;
    exports com.example.pausetasks;
}