package com.example.comp2522202510termprojectvictorjavagame;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * Generates a player with playerPiece, position, and finishedGame.
 *
 * @author Victor Lum
 * @version 2025
 */
public class Player {
    private static final Board GAME_BOARD = new Board();
    private static final int WIN_NUMBER = 100;
    private static final int SEQUENCE_DURATION = 800;
    private static final int DICE_ANIMATION_DURATION = 200;
    private static final int DIE_VALUE = 6;
    private final Circle playerPiece;
    private int position;
    private boolean finishedGame;

    /**
     * Initializes Player with values to playerPiece, position, and finishedGame.
     * @param spaceSize as an int
     * @param pieceColor as a Color
     */
    public Player(final int spaceSize, final Color pieceColor) {
        playerPiece = new Circle(spaceSize / 2);
        playerPiece.setFill(pieceColor);
        position = 0;
        setPlayerPosition(1);
        finishedGame = (position == WIN_NUMBER);
    }

    /**
     * Moves the playerPiece with animation.
     * @param dieValue as an int
     */
    public void setPlayerPosition(final int dieValue) {
        if (position + dieValue <= WIN_NUMBER) {
            position += dieValue;

            TranslateTransition firstMove = moveAnimation(dieValue);
            TranslateTransition secondMove = null;

            int newPosition = GAME_BOARD.getNewPosition(position);
            if (newPosition != position && newPosition != -1) {
                position = newPosition;
                secondMove = moveAnimation(DIE_VALUE);
            }
            if (secondMove == null) {
                firstMove.play();
            } else {
                SequentialTransition sequentialTransition = new SequentialTransition(firstMove,
                        new PauseTransition(Duration.millis(SEQUENCE_DURATION)), secondMove
                );
                sequentialTransition.play();
            }
        }
        moveAnimation(dieValue);
    }

    /*
    Implements animation for player's piece to move across the board.
     */
    private TranslateTransition moveAnimation(final int dieValue) {
        TranslateTransition move = new TranslateTransition(Duration.millis(DICE_ANIMATION_DURATION * dieValue), playerPiece);
        move.setToX(GAME_BOARD.getXCoordinate(position));
        move.setToY(GAME_BOARD.getYCoordinate(position));
        move.setAutoReverse(false);
        return move;
    }

    /**
     * Brings the player back to the start of the board.
     */
    public void returnToStart() {
        position = 0;
        setPlayerPosition(1);
    }

    /**
     * Checks if a player has reached the end of the board.
     * @return a boolean
     */
    public boolean reachedEnd() {
        return position == WIN_NUMBER;
    }

    /**
     * Accesses the playerPiece in Player.
     * @return playerPiece as a Circle
     */
    public Circle getPlayerPiece() {
        return playerPiece;
    }

}
