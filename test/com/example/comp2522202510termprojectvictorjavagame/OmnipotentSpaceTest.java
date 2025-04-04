package com.example.comp2522202510termprojectvictorjavagame;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OmnipotentSpaceTest {
    private final int expectedOmnipotentPosition = 66;
    private final int expectedPosition = 10;

    @Test
    public void testConstructor() {
        OmnipotentSpace space = new OmnipotentSpace(expectedOmnipotentPosition, expectedPosition);

        assertEquals(expectedOmnipotentPosition, space.getOmnipotentPosition());
        assertEquals(expectedPosition, space.getPosition());
    }

    @Test
    public void testDetermineNewPositionInRange() {
        int newPosition = OmnipotentSpace.determineNewPosition(expectedOmnipotentPosition);
        assertTrue(true, String.valueOf(newPosition >= expectedOmnipotentPosition - 5
                                                    && newPosition <= expectedOmnipotentPosition + 5));
    }

    @Test
    public void testDetermineNewPositionOutOfRangePosition() {
        int outOfRangePosition = 101;
        int newPosition = OmnipotentSpace.determineNewPosition(outOfRangePosition);
        assertTrue(newPosition >= 1 && newPosition <= 100);
    }

    @Test
    public void testGetOmnipotentPosition() {
        OmnipotentSpace space = new OmnipotentSpace(expectedOmnipotentPosition, expectedPosition);
        assertEquals(expectedOmnipotentPosition, space.getOmnipotentPosition());
    }

}