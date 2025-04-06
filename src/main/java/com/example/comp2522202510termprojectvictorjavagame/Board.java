package com.example.comp2522202510termprojectvictorjavagame;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Objects;

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
        for (int heightIndex = 0; heightIndex < Game.getHeight(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < Game.getWidth(); widthIndex++) {
                int xCoord;
                if (heightIndex % 2 == 0) {
                    xCoord = widthIndex * Game.getSpaceSize() + Game.getSpaceSize() / 2;
                } else {
                    xCoord = Game.getSpaceSize() * Game.getHeight() - (widthIndex * Game.getSpaceSize())
                            - Game.getSpaceSize() / 2;

                }
                int yCoord = Game.getSpaceSize() * Game.getHeight() - (heightIndex * Game.getSpaceSize())
                        - Game.getSpaceSize() / 2;
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
     * @return new position or -1 as an int
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
     * @return x-coordinate or -1 as an int
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
     * @return y-coordinate or -1 as an int
     */
    public int getYCoordinate(final int position) {
        if (position >= 1 && position <= WIN_NUMBER) {
            return coordinates.get(position).getValue();
        }
        return -1;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Board board = (Board) object;
        return Objects.equals(coordinates, board.coordinates) && Objects.equals(omnipotentSpaces, board.omnipotentSpaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, omnipotentSpaces);
    }

    @Override
    public String toString() {
        StringBuilder sbuilder = new StringBuilder("Board{");
        sbuilder.append("coordinates=");
        sbuilder.append(coordinates);
        sbuilder.append(", omnipotentSpaces=");
        sbuilder.append(omnipotentSpaces);
        sbuilder.append("}");
        return sbuilder.toString();
    }
}

