package com.justiceasare.gtptextprocessing.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDialogController {

    @FXML
    private TextArea selectedTextArea;

    @FXML
    private TextArea matchTextArea;

    private Stage dialogStage;
    private String selectedText;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setText(String text) {
        this.selectedText = text;
        selectedTextArea.setText(text);
        selectedTextArea.setEditable(false); // Make the selected text area uneditable
    }

    @FXML
    private void handleMatch() {
        String pattern = matchTextArea.getText().trim();
        if (!pattern.isEmpty()) {
            String result = performMatch(selectedText, pattern);
            showAlert("Match Result", result);
        } else {
            showAlert("Error", "Please enter a pattern to match.");
        }
    }

    @FXML
    private void HandleCancel() {
        dialogStage.close();
    }

    private String performMatch(String text, String regexPattern) {
        StringBuilder result = new StringBuilder();

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(text);

        boolean matchFound = false;
        while (matcher.find()) {
            matchFound = true;
//            result.append("Match: ").append(matcher.group()).append("");
            result.append(matcher.group());
        }
        System.out.println(result);

        if (!matchFound) {
            result.append("No match found.");
        }

        return result.toString();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
