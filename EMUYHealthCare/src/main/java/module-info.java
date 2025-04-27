module com.example.emuyhealthcare {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.emuyhealthcare to javafx.fxml;
    exports com.example.emuyhealthcare;
}