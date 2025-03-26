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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;

public class HelloApplication extends Application {
    private static final int TIME_LIMIT = 3; // Time limit in seconds
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 200;
    private PauseTransition timer;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Button clickButton = new Button("Click Me!");

        clickButton.setLayoutX(random.nextInt(WINDOW_WIDTH - 80));
        clickButton.setLayoutY(random.nextInt(WINDOW_HEIGHT - 40));
        timer = new PauseTransition(Duration.seconds(TIME_LIMIT));

        timer.setOnFinished(e -> {
            clickButton.setText("You Lost! Restart?");
            clickButton.setOnAction(event -> resetGame(clickButton, root));
        });

        clickButton.setOnAction(event -> {
            moveButton(clickButton);
            timer.stop(); // Stop current timer
            timer.playFromStart(); // Restart timer
        });

        root.getChildren().add(clickButton);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setTitle("Click or Lose Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        timer.play(); // Start initial timer
    }

    private void resetGame(Button clickButton, Pane root) {
        clickButton.setText("Click Me!");
        clickButton.setOnAction(event -> {
            moveButton(clickButton);
            timer.stop();
            timer.playFromStart();
        });
        moveButton(clickButton);
        timer.playFromStart();
    }

    private void moveButton(Button button) {
        button.setLayoutX(random.nextInt(WINDOW_WIDTH - 80));
        button.setLayoutY(random.nextInt(WINDOW_HEIGHT - 40));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
