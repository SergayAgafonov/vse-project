module com.example.jkhdiplom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.jkhdiplom to javafx.fxml;
    exports com.example.jkhdiplom;
}