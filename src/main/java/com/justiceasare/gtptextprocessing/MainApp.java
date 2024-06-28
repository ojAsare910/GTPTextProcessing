package com.justiceasare.gtptextprocessing;

import com.justiceasare.gtptextprocessing.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class MainApp extends Application {
    private static MainController mainController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
        BorderPane root = loader.load();
        mainController = loader.getController();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Text Processing and Data Management Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static void main(String[] args) {
        launch(args);
    }
}