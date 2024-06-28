package com.justiceasare.gtptextprocessing.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceDialogController {

    @FXML
    private TextField regexInput;
    @FXML
    private TextField replacementInput;

    private Stage dialogStage;
    private String originalText;
    private String updatedText;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setText(String text) {
        this.originalText = text;
    }

    public String getUpdatedText() {
        return updatedText;
    }

    @FXML
    private void handleReplace() {
        String pattern = regexInput.getText();
        String replacement = replacementInput.getText();
        String result = originalText.replaceAll(pattern, replacement);
        updatedText = result;
        showHighlightedResult(originalText, pattern, replacement); // Show the result in an alert dialog with highlights
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private void showHighlightedResult(String originalText, String pattern, String replacement) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Replacement Result");
        alert.setHeaderText(null);

        TextFlow textFlow = new TextFlow();
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(originalText);
        int lastEnd = 0;

        while (matcher.find()) {
            if (matcher.start() > lastEnd) {
                textFlow.getChildren().add(new Text(originalText.substring(lastEnd, matcher.start())));
            }

            Text replacedText = new Text(replacement);
            replacedText.setStyle("-fx-fill: red; -fx-font-weight: bold;");
            textFlow.getChildren().add(replacedText);

            lastEnd = matcher.end();
        }

        if (lastEnd < originalText.length()) {
            textFlow.getChildren().add(new Text(originalText.substring(lastEnd)));
        }

        alert.getDialogPane().setContent(textFlow);
        alert.showAndWait();
    }
}
