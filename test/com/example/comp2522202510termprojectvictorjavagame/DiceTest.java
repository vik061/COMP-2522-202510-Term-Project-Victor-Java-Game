package com.example.comp2522202510termprojectvictorjavagame;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    public void testRollDiceValue() {
        int result = Dice.rollDice();
        assertTrue(result >= 1 && result <= 6, "Dice: " + result);
    }

    @Test
    public void testRollDiceMultipleTimes() {
        for (int index = 0; index < 20; index++) {
            int result = Dice.rollDice();
            assertTrue(result >= 1 && result <= 6, "Dice: " + result);
        }
    }

    @Test
    public void testRollDiceWithOutOfRangeHighTestValue() {
        int result = Dice.rollDice();
        assertFalse(result > 6, "Dice: " + result);
    }

    @Test
    public void testRollDiceWithOutOfRangeLowTestValue() {
        int result = Dice.rollDice();
        assertFalse(result < 1, "Dice: " + result);
    }
}