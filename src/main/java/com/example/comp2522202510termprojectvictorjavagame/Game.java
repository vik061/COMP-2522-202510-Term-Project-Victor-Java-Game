package com.example.comp2522202510termprojectvictorjavagame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    public static final int spaceSize=70, width=10, height=10;

    private Pane createContent() {
        Pane root = new Pane();
        root.setPrefSize(width * spaceSize, height * spaceSize + 50);

        for (int index = 0; index < height; index++) {
            for (int j_index = 0; j_index < width; j_index++) {
                Space space = new Space(spaceSize);
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
        
        root.getChildren().add(gameBoard);

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