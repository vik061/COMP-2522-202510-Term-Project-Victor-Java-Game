package com.example.comp2522202510termprojectvictorjavagame;

import java.util.Random;

/**
 * Generates a playable dice for the game.
 *
 * @author Victor Lum
 * @version 2025
 */
public final class Dice {

    private Dice() { }

    /**
     * Rolls dice randomly.
     * @return die's value as an int
     */
    public static int rollDice() {
        final int sides = 6;
        Random random = new Random();
        return random.nextInt(sides) + 1;
    }

    @Override
    public String toString() {
        final StringBuilder sbuilder = new StringBuilder("Dice{");
        sbuilder.append('}');
        return sbuilder.toString();
    }
}
