package com.example.comp2522202510termprojectvictorjavagame;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DiceTest {
    private final int result = Dice.rollDice();

    @Test
    public void testRollDiceValue() {
        assertTrue(result >= 1 && result <= 6, "Dice: " + result);
    }

    @Test
    public void testRollDiceMultipleTimes() {
        for (int index = 0; index < 20; index++) {
            int eachResult = Dice.rollDice();
            assertTrue(eachResult >= 1 && eachResult <= 6, "Dice: " + eachResult);
        }
    }

    @Test
    public void testRollDiceWithOutOfRangeHighTestValue() {
        assertFalse(result > 6, "Dice: " + result);
    }

    @Test
    public void testRollDiceWithOutOfRangeLowTestValue() {
        assertFalse(result < 1, "Dice: " + result);
    }
}