package com.example.comp2522202510termprojectvictorjavagame;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class Player {
    private Circle playerPiece;
    private int position;
    private boolean finishedGame;
    private static Board gameBoard = new Board();
    private static final int winNumber = 100;

    public Player(int spaceSize, final Color pieceColor) {
        playerPiece = new Circle(spaceSize / 2);
        playerPiece.setFill(pieceColor);
        position = 0;
        setPlayerPosition(1);
        finishedGame = (position == winNumber);
    }

    public int getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(final int dieValue) {
        if (position + dieValue <= winNumber) {
            position += dieValue;
        }
        moveAnimation(dieValue);
    }

    private void moveAnimation(final int dieValue) {
        TranslateTransition move = new TranslateTransition(Duration.millis(200 * dieValue), playerPiece);
        move.setToX(gameBoard.getXCoordinate(position));
        move.setToY(gameBoard.getYCoordinate(position));
        move.setAutoReverse(false);
        move.play();
    }

    public Circle getPlayerPiece() {
        return playerPiece;
    }

    public int getPosition() {
        return position;
    }

    public boolean isFinishedGame() {
        return finishedGame;
    }
}
