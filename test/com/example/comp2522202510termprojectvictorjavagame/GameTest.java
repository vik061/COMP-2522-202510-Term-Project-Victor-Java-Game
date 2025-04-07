package com.example.comp2522202510termprojectvictorjavagame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void testGetSpaceSize() {
        int spaceSize = 40;
        assertEquals(spaceSize, Game.getSpaceSize());
    }

    @Test
    void testGetWidth() {
        int width = 10;
        assertEquals(width, Game.getWidth());
    }

    @Test
    void testGetHeight() {
        int height = 10;
        assertEquals(height, Game.getHeight());
    }
}