package com.example.comp2522202510termprojectvictorjavagame;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    public ArrayList<Pair<Integer, Integer>> coordinates;

    public Board() {
        coordinates = new ArrayList<>();
        createCoordinates();
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
//    public static void main(String[] args) {
//        Board board = new Board();
//        for (int i = 0; i < board.coordinates.size(); i++) {
//            System.out.println(i + " x :" + board.coordinates.get(i).getKey() +
//                    " y :" + board.coordinates.get(i).getValue());
//        }
//    }
}
