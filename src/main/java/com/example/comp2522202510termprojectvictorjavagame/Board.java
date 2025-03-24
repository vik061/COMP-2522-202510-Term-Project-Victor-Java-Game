package com.example.comp2522202510termprojectvictorjavagame;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Generates a game board with coordinates and omnipotent spaces.
 * @author Victor Lum
 * @version 2025
 */
public class Board {
    private static final int WIN_NUMBER = 100;
    private static final int OMNIPOTENT_NUMBER = 6;
    private final ArrayList<Pair<Integer, Integer>> coordinates;
    private ArrayList<Integer> omnipotentSpaces;


    /**
     * Initializes Board with new coordinates and Omnipotent spaces.
     */
    public Board() {
        coordinates = new ArrayList<>();
        createCoordinates();
        createOmnipotentSpaces();
    }

    private void createCoordinates() {
        coordinates.add(new Pair<>(0, 0));
        for (int heightIndex = 0; heightIndex < Game.HEIGHT; heightIndex++) {
            for (int widthIndex = 0; widthIndex < Game.WIDTH; widthIndex++) {
                int xCoord;
                if (heightIndex % 2 == 0) {
                    xCoord = widthIndex * Game.SPACE_SIZE + Game.SPACE_SIZE / 2;
                } else {
                    xCoord = Game.SPACE_SIZE * Game.HEIGHT - (widthIndex * Game.SPACE_SIZE) - Game.SPACE_SIZE / 2;
                }
                int yCoord = Game.SPACE_SIZE * Game.HEIGHT - (heightIndex * Game.SPACE_SIZE) - Game.SPACE_SIZE / 2;
                coordinates.add(new Pair<>(xCoord, yCoord));
            }
        }
    }

    /*
    Generates omnipotent spaces to omnipotentSpaces ArrayList.
     */
    private void createOmnipotentSpaces() {
        omnipotentSpaces = new ArrayList<>();
        for (int index = 0; index <= WIN_NUMBER; index++) {
            omnipotentSpaces.add(index);

            if (index % OMNIPOTENT_NUMBER == 0) {
                omnipotentSpaces.set(index, OmnipotentSpace.determineNewPosition(index));
            }
        }
    }

    /**
     * Accesses currentPosition in omnipotentSpaces.
     * @param currentPosition as an int
     * @return -1 as an int (to exit this method)
     */
    public int getNewPosition(final int currentPosition) {
        if (currentPosition > 0 && currentPosition <= WIN_NUMBER) {
            return omnipotentSpaces.get(currentPosition);
        }
        return -1;
    }

    /**
     * Accesses the X coordinate's position in coordinates' key.
     * @param position as an int
     * @return -1 as an int (to exit this method)
     */
    public int getXCoordinate(final int position) {
        if (position >= 1 && position <= WIN_NUMBER) {
            return coordinates.get(position).getKey();
        }
        return -1;
    }

    /**
     * Accesses the Y coordinate's position in coordinates' value.
     * @param position as an int
     * @return -1 as an int (to exit this method)
     */
    public int getYCoordinate(final int position) {
        if (position >= 1 && position <= WIN_NUMBER) {
            return coordinates.get(position).getValue();
        }
        return -1;
    }
}
