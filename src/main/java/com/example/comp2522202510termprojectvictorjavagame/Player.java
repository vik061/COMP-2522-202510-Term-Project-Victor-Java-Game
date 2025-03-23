package com.example.comp2522202510termprojectvictorjavagame;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class Player {
    private final Circle playerPiece;
    private int position;
    private boolean finishedGame;
    private static final Board gameBoard = new Board();
    private static final int WIN_NUMBER = 100;

    public Player(final int spaceSize, final Color pieceColor) {
        playerPiece = new Circle(spaceSize / 2);
        playerPiece.setFill(pieceColor);
        position = 0;
        setPlayerPosition(1);
        finishedGame = (position == WIN_NUMBER);
    }

    public void setPlayerPosition(final int dieValue) {
        if (position + dieValue <= WIN_NUMBER) {
            position += dieValue;

            TranslateTransition firstMove = moveAnimation(dieValue);
            TranslateTransition secondMove = null;

            int newPosition = gameBoard.getNewPosition(position);
            if (newPosition != position && newPosition != -1) {
                position = newPosition;
                secondMove = moveAnimation(6);
            }
            if (secondMove == null) {
                firstMove.play();
            } else {
                SequentialTransition sequentialTransition = new SequentialTransition(firstMove,
                        new PauseTransition(Duration.millis(800)), secondMove
                );
                sequentialTransition.play();
            }
        }
        moveAnimation(dieValue);
    }

    private TranslateTransition moveAnimation(final int dieValue) {
        TranslateTransition move = new TranslateTransition(Duration.millis(200 * dieValue), playerPiece);
        move.setToX(gameBoard.getXCoordinate(position));
        move.setToY(gameBoard.getYCoordinate(position));
        move.setAutoReverse(false);
        return move;
    }

    public void returnToStart() {
        position = 0;
        setPlayerPosition(1);
    }

    public boolean reachedEnd() {
        return position == WIN_NUMBER;
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
