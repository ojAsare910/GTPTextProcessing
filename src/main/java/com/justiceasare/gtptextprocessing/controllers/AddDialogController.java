package com.justiceasare.gtptextprocessing.controllers;

import com.justiceasare.gtptextprocessing.MainApp;
import com.justiceasare.gtptextprocessing.models.DataModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AddDialogController {
    @FXML
    private TextArea dataInput;

    @FXML
    private void handleAdd() {
        String data = dataInput.getText();
        if (!data.isEmpty()) {
            MainController mainController = MainApp.getMainController();
            mainController.addData(new DataModel(data));
            handleCancel();
        }
    }

    @FXML
    private void handleCancel() {
        Stage stage = (Stage) dataInput.getScene().getWindow();
        stage.close();
    }
}