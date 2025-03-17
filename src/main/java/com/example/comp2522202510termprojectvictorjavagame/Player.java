package com.example.comp2522202510termprojectvictorjavagame;

public class Player {
    int position;
    boolean finishedGame;

    public Player(int position, boolean finishedGame) {
        this.position = position;
        this.finishedGame = position == 100;
    }

    public int getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(int newPosition) {
        this.position = newPosition;
    }
}
