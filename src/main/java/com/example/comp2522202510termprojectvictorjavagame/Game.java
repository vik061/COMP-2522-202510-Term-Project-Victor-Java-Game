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

public class Game extends Application {
    public static final int spaceSize=40, width=10, height=10;
    public static final int buttonLine = height * spaceSize + 35;
    public static final int descriptionLine = buttonLine - 20;
    private Player playerOne;

    private Pane createContent() {
        Pane root = new Pane();
        root.setPrefSize(width * spaceSize, height * spaceSize + 100);

        for (int index = 0; index < height; index++) {
            for (int j_index = 0; j_index < width; j_index++) {
                Space space = new Space(spaceSize, false, false, false);
                space.SetTranslateX(j_index * spaceSize);
                space.SetTranslateY(index * spaceSize);
                root.getChildren().addAll(space);
            }
        }

        Image image = new Image("C:\\Users\\vik06\\IdeaProjects\\COMP-2522-202510-Term-Project-Victor-Java-Game\\src\\main\\COMP2522GameBoard.png");
        ImageView gameBoard = new ImageView();
        gameBoard.setImage(image);
        gameBoard.setFitHeight(height * spaceSize);
        gameBoard.setFitWidth(width * spaceSize);

        Button playerButton = new Button("Player One");
        Button diceButton = new Button("Roll Dice");
        Button startButton = new Button("Start");


        playerButton.setTranslateY(buttonLine);
        playerButton.setTranslateX(160);
//        diceButton.setTranslateY(buttonLine);
//        diceButton.setTranslateX(160);
//        startButton.setTranslateY(buttonLine);
//        startButton.setTranslateX(270);

        Label playerLabel = new Label("Your Turn");
//        Label diceLabel = new Label("Dice");
//        Label startLabel = new Label("Start");

        playerLabel.setTranslateY(descriptionLine);
        playerLabel.setTranslateX(171);
//        diceLabel.setTranslateY(descriptionLine);
//        diceLabel.setTranslateX(175);
//        startLabel.setTranslateY(descriptionLine);
//        startLabel.setTranslateX(277);

//        diceButton.setOnAction(event -> {
//            int value = Dice.rollDice();
//            System.out.println("Dice: " + value);
//            diceLabel.setText("Dice: " + value);
//        });

        playerOne = new Player(spaceSize, Color.BLACK);

        playerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent actionEvent) {
                int dieValue = Dice.rollDice();
                playerLabel.setText("Dice: " + dieValue);
                playerOne.setPlayerPosition(dieValue);
            }
        });

        root.getChildren().addAll(gameBoard,
                playerButton,
                playerLabel,
                playerOne.getPlayerPiece());

        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(createContent());
        stage.setTitle("Omnipotent Six");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}