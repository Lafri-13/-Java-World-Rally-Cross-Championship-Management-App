module com.example.cwpart2.cw2programming {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cwpart2.cw2programming to javafx.fxml;
    exports com.example.cwpart2.cw2programming;
}