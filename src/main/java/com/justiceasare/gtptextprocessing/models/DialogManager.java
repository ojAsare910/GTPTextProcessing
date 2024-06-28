package com.justiceasare.gtptextprocessing.models;

import com.justiceasare.gtptextprocessing.MainApp;
import com.justiceasare.gtptextprocessing.controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogManager {
    public static void showAddDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/justiceasare/gtptextprocessing/add-dialog.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Data");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showUpdateDialog(DataModel selectedItem) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/justiceasare/gtptextprocessing/update-dialog.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Update Data");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));
            UpdateDialogController controller = loader.getController();
            controller.setSelectedItem(selectedItem);
            controller.setDialogStage(stage);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showDeleteDialog(DataModel selectedItem) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/justiceasare/gtptextprocessing/delete-dialog.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Delete Data");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));
            DeleteDialogController controller = loader.getController();
            controller.setSelectedItem(selectedItem);
            controller.setDialogStage(stage);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showSearchDialog(String selectedItemText) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/justiceasare/gtptextprocessing/search-dialog.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Search Data");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            SearchDialogController controller = loader.getController();
            controller.setDialogStage(stage);
            controller.setSelectedItemText(selectedItemText);

            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String showReplaceDialog(String initialData) {
        try {
            FXMLLoader loader = new FXMLLoader(DialogManager.class.getResource("/com/justiceasare/gtptextprocessing/replace-dialog.fxml"));
            Parent root = loader.load();

            ReplaceDialogController controller = loader.getController();
            controller.setText(initialData);

            Stage dialogStage = new Stage();
            controller.setDialogStage(dialogStage);
            dialogStage.setTitle("Replace Text");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();

            return controller.getUpdatedText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void showMatchDialog(String text) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/com/justiceasare/gtptextprocessing/match-dialog.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Match Data");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));
            MatchDialogController controller = loader.getController();
            controller.setText(text);
            controller.setDialogStage(stage);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
