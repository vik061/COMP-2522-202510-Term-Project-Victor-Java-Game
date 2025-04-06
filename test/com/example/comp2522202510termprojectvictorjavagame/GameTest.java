package com.example.comp2522202510termprojectvictorjavagame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;


public class GameTest {
    Game game = new Game();

    @BeforeAll
    static void initJavaFX() {
        try {
            Platform.startup(() -> {});
        } catch (IllegalStateException error) {
            error.printStackTrace();
        }
    }

    @Test
    void testGetSpaceSize() {
        assertEquals(40, Game.getSpaceSize());
    }

    @Test
    void testGetWidth() {
        assertEquals(10, Game.getWidth());
    }

    @Test
    void testGetHeight() {
        assertEquals(10, Game.getHeight());
    }
}