package com.justiceasare.gtptextprocessing.controllers;

import com.justiceasare.gtptextprocessing.MainApp;
import com.justiceasare.gtptextprocessing.models.DataModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class UpdateDialogController {
    @FXML
    private TextArea dataInput;

    private DataModel selectedItem;
    private Stage dialogStage; // Stage for the dialog window

    public void setSelectedItem(DataModel selectedItem) {
        this.selectedItem = selectedItem;
        dataInput.setText(selectedItem.getData());
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleUpdate() {
        String data = dataInput.getText();
        if (!data.isEmpty() && selectedItem != null) {
            // Assuming MainController and updateData method are correctly implemented
            MainController mainController = MainApp.getMainController();
            mainController.updateData(selectedItem, new DataModel(data));
            handleCancel();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
