package com.example.comp2522202510termprojectvictorjavagame;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pair<Integer, Integer>> coordinates;
    private ArrayList<Integer> omnipotentSpaces;
    private static final int winNumber = 100;
    private static final int omnipotentNumber = 6;


    public Board() {
        coordinates = new ArrayList<>();
        createCoordinates();
        createOmnipotentSpaces();
    }

    private void createCoordinates() {
        coordinates.add(new Pair<>(0, 0));
        for (int heightIndex = 0; heightIndex < Game.height; heightIndex++) {
            for (int widthIndex = 0; widthIndex < Game.width; widthIndex++) {
                int xCoord;
                if (heightIndex % 2 == 0) {
                    xCoord = widthIndex * Game.spaceSize + Game.spaceSize / 2;
                } else {
                    xCoord = Game.spaceSize * Game.height - (widthIndex * Game.spaceSize) - Game.spaceSize / 2;
                }

                int yCoord = Game.spaceSize * Game.height - (heightIndex * Game.spaceSize) - Game.spaceSize / 2;
                coordinates.add(new Pair<>(xCoord, yCoord));
            }
        }
    }

    private void createOmnipotentSpaces() {
        omnipotentSpaces = new ArrayList<>();
        for (int index = 0; index <= winNumber; index++) {
            omnipotentSpaces.add(index);

            if (index % omnipotentNumber == 0) {
                omnipotentSpaces.set(index, OmnipotentSpace.determineNewPosition(index));
            }
        }
    }

    public int getNewPosition(int currentPosition) {
        if (currentPosition > 0 && currentPosition <= 100) {
            return omnipotentSpaces.get(currentPosition);
        }
        return -1;
    }

    public int getXCoordinate(final int position) {
        if (position >= 1 && position <= winNumber) {
            return coordinates.get(position).getKey();
        }
        return -1;
    }

    public int getYCoordinate(final int position) {
        if (position >= 1 && position <= winNumber) {
            return coordinates.get(position).getValue();
        }
        return -1;
    }
//    public static void main(String[] args) {
//        Board board = new Board();
//        for (int i = 0; i < board.coordinates.size(); i++) {
//            System.out.println(i + " x :" + board.coordinates.get(i).getKey() +
//                    " y :" + board.coordinates.get(i).getValue());
//        }
//    }
}
