package com.example.comp2522202510termprojectvictorjavagame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {
    private final int position = 50;
    Space space = new Space(position);

    @Test
    void testConstructorInitialization() {
        int currentPosition = space.getPosition();
        double width = space.getWidth();
        double height = space.getHeight();

        assertEquals(position, currentPosition);
        assertEquals(position, width);
        assertEquals(position, height);
    }

    @Test
    void testConstructorEdgeCaseZero() {
        Space zeroSpace = new Space(0);
        assertEquals(0, zeroSpace.getPosition());
    }

    @Test
    void testConstructorEdgeCaseMaxNumber() {
        Space maxSpace = new Space(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, maxSpace.getPosition());
    }

    @Test
    void testSetTranslateX() {
        space.setTranslateX(100);
        assertEquals(100, space.getTranslateX());
    }

    @Test
    void testSetTranslateXNegativeValue() {
        space.setTranslateX(-50);
        assertEquals(-50, space.getTranslateX());
    }

    @Test
    void testSetTranslateY() {
        space.setTranslateY(200);
        assertEquals(200, space.getTranslateY());
    }

    @Test
    void testSetTranslateYNegativeValue() {
        space.setTranslateY(-100);
        assertEquals(-100, space.getTranslateY());
    }

    @Test
    void testGetPosition() {
        assertEquals(50, space.getPosition());
    }

    @Test
    void testHashCodeSameSpaces() {
        Space space1 = new Space(10);
        Space space2 = new Space(10);
        assertEquals(space1.hashCode(), space2.hashCode());
    }

    @Test
    void testToString() {
        Space space = new Space(10);
        String expected = "Space{position=10}";
        assertEquals(expected, space.toString());
    }
}