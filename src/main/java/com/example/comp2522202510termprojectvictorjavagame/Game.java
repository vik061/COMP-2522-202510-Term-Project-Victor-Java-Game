package com.example.comp2522202510termprojectvictorjavagame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Creates the Game's user interface for gameplay.
 *
 * @author Victor Lum
 * @version 2025
 */
public class Game extends Application {
    /**
     * Sets the space size.
     */
    public static final int SPACE_SIZE = 40;
    /**
     * Sets the width size.
     */
    public static final int WIDTH = 10;
    /**
     * Sets the height size.
     */
    public static final int HEIGHT = 10;
    private static final int BUTTON_LINE = HEIGHT * SPACE_SIZE + 35;
    private static final int DESCRIPTION_LINE = BUTTON_LINE - 20;
    private Player playerOne;

    /*
    Creates the user interface for gameplay.
     */
    private Pane createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH * SPACE_SIZE, HEIGHT * SPACE_SIZE + 100);

        for (int index = 0; index < HEIGHT; index++) {
            for (int jIndex = 0; jIndex < WIDTH; jIndex++) {
                Space space = new Space(SPACE_SIZE);
                space.setTranslateX(jIndex * SPACE_SIZE);
                space.setTranslateY(index * SPACE_SIZE);
                root.getChildren().addAll(space);
            }
        }

        Image image = new Image("file:src/main/resources/images/COMP2522GameBoard.png");
        ImageView gameBoard = new ImageView();
        gameBoard.setImage(image);
        gameBoard.setFitHeight(HEIGHT * SPACE_SIZE);
        gameBoard.setFitWidth(WIDTH * SPACE_SIZE);

        Button playerButton = new Button("Roll Dice");
        Button startButton = new Button("Start");

        playerButton.setDisable(true);
        startButton.setDisable(false);

        playerButton.setTranslateY(BUTTON_LINE);
        playerButton.setTranslateX(77);
        startButton.setTranslateY(BUTTON_LINE);
        startButton.setTranslateX(270);

        Label playerLabel = new Label();
        Label startLabel = new Label("Start");

        playerLabel.setTranslateY(DESCRIPTION_LINE);
        playerLabel.setTranslateX(90);
        startLabel.setTranslateY(DESCRIPTION_LINE);
        startLabel.setTranslateX(277);

        startButton.setOnAction(event -> {
            playerButton.setDisable(false);
            startButton.setDisable(true);
            playerLabel.setText("Your turn");
        });

        playerOne = new Player(SPACE_SIZE, Color.BLACK);

        playerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent actionEvent) {
                int dieValue = Dice.rollDice();
                playerLabel.setText("Dice: " + dieValue);
                playerOne.setPlayerPosition(dieValue);
                if (playerOne.reachedEnd()) {
                    playerLabel.setText("You won!");
                    playerButton.setDisable(true);
                    playerOne.returnToStart();

                    startLabel.setText("Restart");
                    startLabel.setTranslateX(273);
                    startButton.setDisable(false);

                }
            }
        });

        root.getChildren().addAll(gameBoard,
                playerButton, startButton,
                playerLabel, startLabel,
                playerOne.getPlayerPiece());

        return root;
    }
    @Override
    public void start(final Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Omnipotent Six");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the game aka Omnipotent Six.
     * @param args unused
     */
    public static void main(final String[] args) {
        launch();
    }
}
