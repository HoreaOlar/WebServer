module com.example.vvs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vvs to javafx.fxml;
    exports com.example.vvs;
}