package com.justiceasare.gtptextprocessing.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchDialogController {

    @FXML
    private TextArea selectedItemLabel;
    @FXML
    private TextField regexInput;
    @FXML
    private TextField searchWordInput;

    private Stage dialogStage;
    private String selectedItemText;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setSelectedItemText(String selectedItemText) {
        this.selectedItemText = selectedItemText;
        selectedItemLabel.setText(selectedItemText);
    }

    @FXML
    private void handleSearchByRegex() {
        String regexPattern = regexInput.getText();
        String result = performRegexSearch(selectedItemText, regexPattern);
        showHighlightedResult(selectedItemText, regexPattern, true);
    }

    @FXML
    private void handleSearchByWord() {
        String searchWord = searchWordInput.getText();
        String result = performWordSearch(selectedItemText, searchWord);
        showHighlightedResult(selectedItemText, searchWord, false);
    }

    @FXML
    private void handleClose() {
        dialogStage.close();
    }

    private String performRegexSearch(String text, String regexPattern) {
        StringBuilder result = new StringBuilder();
        result.append("Regex Pattern: ").append(regexPattern).append("\n");
        result.append("Selected Item Text: ").append(text).append("\n");

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(text);
        boolean regexMatchFound = matcher.find();

        if (regexMatchFound) {
            result.append("Regex match found.\n");
        } else {
            result.append("No regex match found.\n");
        }

        return result.toString();
    }

    private String performWordSearch(String text, String searchWord) {
        StringBuilder result = new StringBuilder();
        result.append("Search Word: ").append(searchWord).append("\n");
        result.append("Selected Item Text: ").append(text).append("\n");

        boolean searchWordFound = text.contains(searchWord);

        if (searchWordFound) {
            result.append("Search word found.\n");
        } else {
            result.append("Search word not found.\n");
        }

        return result.toString();
    }


    private void showHighlightedResult(String text, String pattern, boolean isRegex) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Search Results");
        alert.setHeaderText(null);

        TextFlow textFlow = new TextFlow();
        int lastEnd = 0;
        Matcher matcher = isRegex ? Pattern.compile(pattern).matcher(text) : null;

        while ((isRegex && matcher.find()) || (!isRegex && (matcher = Pattern.compile(Pattern.quote(pattern)).matcher(text)).find(lastEnd))) {
            if (matcher.start() > lastEnd) {
                textFlow.getChildren().add(new Text(text.substring(lastEnd, matcher.start())));
            }
            Text highlightedText = new Text(text.substring(matcher.start(), matcher.end()));
            highlightedText.setStyle("-fx-fill: red; -fx-font-weight: bold;");
            textFlow.getChildren().add(highlightedText);
            lastEnd = matcher.end();
        }

        if (lastEnd < text.length()) {
            textFlow.getChildren().add(new Text(text.substring(lastEnd)));
        }

        alert.getDialogPane().setContent(textFlow);
        alert.getDialogPane().getStyleClass().add("alert-dialog");
        alert.showAndWait();
    }
}
