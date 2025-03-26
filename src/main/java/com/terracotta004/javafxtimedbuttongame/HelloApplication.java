package com.terracotta004.javafxtimedbuttongame;

/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}*/

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    private static final int TIME_LIMIT = 3; // Time limit in seconds
    private PauseTransition timer;

    @Override
    public void start(Stage primaryStage) {
        Button clickButton = new Button("Click Me!");

        timer = new PauseTransition(Duration.seconds(TIME_LIMIT));
        timer.setOnFinished(e -> {
            clickButton.setText("You Lost! Restart?");
            clickButton.setOnAction(event -> resetGame(clickButton));
        });

        clickButton.setOnAction(event -> {
            timer.stop(); // Stop current timer
            timer.playFromStart(); // Restart timer
        });

        StackPane root = new StackPane(clickButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Click or Lose Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        timer.play(); // Start initial timer
    }

    private void resetGame(Button clickButton) {
        clickButton.setText("Click Me!");
        clickButton.setOnAction(event -> {
            timer.stop();
            timer.playFromStart();
        });
        timer.playFromStart();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

