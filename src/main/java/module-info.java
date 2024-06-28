module com.justiceasare.gtptextprocessing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.justiceasare.gtptextprocessing to javafx.fxml;
    exports com.justiceasare.gtptextprocessing;
    exports com.justiceasare.gtptextprocessing.controllers;
    opens com.justiceasare.gtptextprocessing.controllers to javafx.fxml;
    opens com.justiceasare.gtptextprocessing.models to javafx.base; // This line is crucial
    exports com.justiceasare.gtptextprocessing.models;
}