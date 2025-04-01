package com.example.comp2522202510termprojectvictorjavagame;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OmnipotentSpaceTest {

    @Test
    public void testConstructor() {
        int expectedOmnipotentPosition = 50;
        int expectedPosition = 10;
        OmnipotentSpace space = new OmnipotentSpace(expectedOmnipotentPosition, expectedPosition);

        assertEquals(expectedOmnipotentPosition, space.getOmnipotentPosition());
        assertEquals(expectedPosition, space.getPosition());
    }

    @Test
    public void testDetermineNewPositionInRange() {
        int omnipotentPosition = 6;
        int newPosition = OmnipotentSpace.determineNewPosition(omnipotentPosition);
        assertTrue(newPosition >= omnipotentPosition - 5 && newPosition <= omnipotentPosition + 5);
    }

    @Test
    public void testDetermineNewPositionOutOfRangePosition() {
        int outOfRangePosition = 101;
        int newPosition = OmnipotentSpace.determineNewPosition(outOfRangePosition);
        assertTrue(newPosition >= 1 && newPosition <= 100);
    }
}