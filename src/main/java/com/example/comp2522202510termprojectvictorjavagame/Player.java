package com.example.comp2522202510termprojectvictorjavagame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


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
        int xCoord = gameBoard.getXCoordinate(position);
        int yCoord = gameBoard.getYCoordinate(position);
        playerPiece.setTranslateX(xCoord);
        playerPiece.setTranslateY(yCoord);

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
