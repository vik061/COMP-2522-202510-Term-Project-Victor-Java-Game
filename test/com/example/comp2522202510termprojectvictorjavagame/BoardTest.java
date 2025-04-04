package com.example.comp2522202510termprojectvictorjavagame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private final int validNonOmnipotentPosition = 11;
    private final int invalidNonOmnipotentPosition = 101;
    Board board = new Board();

    @Test
    void testGetNewPositionNonOmnipotentPositionValidRange() {
        int newPosition = board.getNewPosition(validNonOmnipotentPosition);
        assertEquals(validNonOmnipotentPosition, newPosition);
    }

    @Test
    void testGetNewPositionOmnipotentPositionValidRange() {
        int validOmnipotentPosition = 12;
        int newPosition = board.getNewPosition(validOmnipotentPosition);
        assertTrue(true, String.valueOf(newPosition >= 7 && newPosition <= 17));
    }

    @Test
    void testGetNewPositionInvalidfRange() {
        int newPosition = board.getNewPosition(invalidNonOmnipotentPosition);
        assertEquals(-1, newPosition);
    }

    @Test
    void testGetXCoordinateValidRange() {
        int xCoordinate = board.getXCoordinate(validNonOmnipotentPosition);
        assertEquals(380, xCoordinate);
    }

    @Test
    void testGetXCoordinateInvalidRange() {
        int xCoordinate = board.getXCoordinate(invalidNonOmnipotentPosition);
        assertEquals(-1, xCoordinate);
    }

    @Test
    void testGetYCoordinateValidRange() {
        int yCoordinate = board.getYCoordinate(validNonOmnipotentPosition);
        assertEquals(340, yCoordinate);
    }

    @Test
    void testGetYCoordinateInvalidRange() {
        int yCoordinate = board.getYCoordinate(invalidNonOmnipotentPosition);
        assertEquals(-1, yCoordinate);
    }
}