package com.example.comp2522202510termprojectvictorjavagame;

import java.util.Random;

public class Dice {

    public static int rollDice() {
        final int sides = 6;
        Random random = new Random();
        int die = random.nextInt(sides) + 1;
        return die;
    }
}
