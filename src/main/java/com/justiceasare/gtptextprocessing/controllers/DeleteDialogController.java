package com.justiceasare.gtptextprocessing.controllers;

import com.justiceasare.gtptextprocessing.MainApp;
import com.justiceasare.gtptextprocessing.models.DataModel;
import javafx.stage.Stage;

public class DeleteDialogController {
    private DataModel selectedItem;
    private Stage dialogStage;

    public void setSelectedItem(DataModel selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void handleDelete() {
        if (selectedItem != null) {
            MainController mainController = MainApp.getMainController();
            mainController.deleteData(selectedItem);
            handleCancel();
        }
    }

    public void handleCancel() {
        if (dialogStage != null) {
            dialogStage.close();
        }
    }
}