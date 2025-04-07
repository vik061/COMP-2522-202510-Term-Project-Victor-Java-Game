package com.example.comp2522202510termprojectvictorjavagame;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates the Game's user interface for gameplay.
 *
 * @author Victor Lum
 * @version 2025
 */
public class Game extends Application {
    private static final int SPACE_SIZE = 40;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final int BOTTOM_SPACE = 100;
    private static final int BUTTON_LINE = HEIGHT * SPACE_SIZE + 35;
    private static final int DESCRIPTION_LINE = BUTTON_LINE - 20;
    private static final int PLAYER_BUTTON_X_COORD = 77;
    private static final int START_BUTTON_X_COORD = 270;
    private static final int PLAYER_LABEL_X_COORD = 84;
    private static final int START_LABEL_X_COORD = 277;
    private static final int RESTART_LABEL_X_COORD = 273;
    private static final String SAVE_FILE_PATH = "src/main/resources/player_position.txt";
    private Player playerOne;

    /**
     * Accesses the SPACE_SIZE value in Game.
     * @return SPACE_SIZE as an int
     */
    public static int getSpaceSize() {
        return SPACE_SIZE;
    }

    /**
     * Accesses the WIDTH value in Game.
     * @return WIDTH as an int
     */
    public static int getWidth() {
        return WIDTH;
    }

    /**
     * Accesses the HEIGHT value in Game.
     * @return HEIGHT as an int
     */
    public static int getHeight() {
        return HEIGHT;
    }

    /*
    Creates a root pane for the game board.
     */
    private Pane createRootPane() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH * SPACE_SIZE, HEIGHT * SPACE_SIZE + BOTTOM_SPACE);
        return root;
    }

    /*
    Adds space's X and Y coordinates to the root pane.
     */
    private void addSpaces(final Pane root) {
        for (int index = 0; index < HEIGHT; index++) {
            for (int jIndex = 0; jIndex < WIDTH; jIndex++) {
                Space space = new Space(SPACE_SIZE);
                space.setTranslateX(jIndex * SPACE_SIZE);
                space.setTranslateY(index * SPACE_SIZE);
                root.getChildren().addAll(space);
            }
        }
    }

    /*
    Creates visual display of the game board.
     */
    private ImageView createGameBoard() {
        Image image = new Image("file:src/main/resources/images/COMP2522GameBoard.png");
        ImageView gameBoard = new ImageView();
        gameBoard.setImage(image);
        gameBoard.setFitHeight(HEIGHT * SPACE_SIZE);
        gameBoard.setFitWidth(WIDTH * SPACE_SIZE);
        return gameBoard;
    }

    /*
    Creates the player button.
     */
    private Button createPlayerButton() {
        Button playerButton = new Button("Roll Dice");
        playerButton.setDisable(true);
        playerButton.setTranslateY(BUTTON_LINE);
        playerButton.setTranslateX(PLAYER_BUTTON_X_COORD);
        return playerButton;
    }

    /*
    Creates the start button
     */
    private Button createStartButton(final Button playerButton) {
        Button startButton = new Button("Start");
        startButton.setDisable(false);
        startButton.setTranslateY(BUTTON_LINE);
        startButton.setTranslateX(START_BUTTON_X_COORD);

        startButton.setOnAction(event -> {
            playerButton.setDisable(false);
            startButton.setDisable(true);
        });
        return startButton;
    }

    /*
    Creates the player label.
     */
    private Label createPlayerLabel() {
        Label playerLabel = new Label();
        playerLabel.setTranslateY(DESCRIPTION_LINE);
        playerLabel.setTranslateX(PLAYER_LABEL_X_COORD);
        return playerLabel;
    }

    /*
    Creates the start label.
     */
    private Label createStartLabel() {
        Label startLabel = new Label("Start");
        startLabel.setTranslateY(DESCRIPTION_LINE);
        startLabel.setTranslateX(START_LABEL_X_COORD);
        return startLabel;
    }

    /*
    Sets the start and player button's event handlers in the game.
     */
    private void setEventHandlers(final Button playerButton, final Button startButton,
                                  final Label playerLabel, final Label startLabel) {
        startButton.setOnAction(event -> {
            playerButton.setDisable(false);
            startButton.setDisable(true);
            playerLabel.setText("Your turn");
        });

        playerButton.setOnAction(event -> {
            int dieValue = Dice.rollDice();
            playerLabel.setText("Dice: " + dieValue);
            playerOne.setPlayerPosition(dieValue);
            if (playerOne.reachedEnd()) {
                playerLabel.setText("You won!");
                playerButton.setDisable(true);
                playerOne.returnToStart();

                startLabel.setText("Restart");
                startLabel.setTranslateX(RESTART_LABEL_X_COORD);
                startButton.setDisable(false);

            }
        });
    }

    /*
    Creates the user interface for gameplay.
     */
    private Pane createContent() {
        Pane root = createRootPane();
        addSpaces(root);

        ImageView gameBoard = createGameBoard();

        Button playerButton = createPlayerButton();
        Button startButton = createStartButton(playerButton);
        Label playerLabel = createPlayerLabel();
        Label startLabel = createStartLabel();

        playerOne = new Player(SPACE_SIZE, Color.BLACK);

        setEventHandlers(playerButton, startButton, playerLabel, startLabel);

        root.getChildren().addAll(gameBoard,
                playerButton, startButton,
                playerLabel, startLabel,
                playerOne.getPlayerPiece());

        return root;
    }

    /**
     * Initializes the game's functionalities.
     * @param stage as a Stage
     */
    @Override
    public void start(final Stage stage) {
        Scene scene = new Scene(createContent());
        stage.setTitle("Omnipotent Six");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> savePlayerPosition());
    }

    /*
    Saves the player's most recent position in a txt file.
     */
    private void savePlayerPosition() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE_PATH))) {
            writer.write(String.valueOf(playerOne.getPosition()));
        } catch (IOException error) {
            System.err.println("Error saving player position: " + error.getMessage());
        }
    }

    /**
     * Launches the game aka Omnipotent Six.
     * @param args unused
     */
    public static void main(final String[] args) {
        launch();
    }
}
