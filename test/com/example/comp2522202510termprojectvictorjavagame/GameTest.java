package com.example.comp2522202510termprojectvictorjavagame;

import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.junit.jupiter.api.Test;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;


public class GameTest {
    Game game = new Game();
    Button playerButton = game.createPlayerButton();

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

    @Test
    void testCreateRootPane() {
        Pane rootPane = game.createRootPane();
        assertNotNull(rootPane);
        assertEquals(Game.getWidth() * Game.getSpaceSize(), rootPane.getPrefWidth());
        assertEquals(Game.getHeight() * Game.getSpaceSize() + 100, rootPane.getPrefHeight());
    }

    @Test
    void testAddSpaces() {
        Pane rootPane = game.createRootPane();
        game.addSpaces(rootPane);

        int expectedSpaceCount = Game.getWidth() * Game.getHeight();
        assertEquals(expectedSpaceCount, rootPane.getChildren().size());
    }

    @Test
    void testCreatePlayerButton() {
        assertNotNull(playerButton);
        assertEquals("Roll Dice", playerButton.getText());
        assertTrue(playerButton.isDisabled());
        assertEquals(77, playerButton.getTranslateX());
        assertEquals(435, playerButton.getTranslateY());
    }

    @Test
    void testCreateStartButton() {
        Button startButton = game.createStartButton(playerButton);
        assertNotNull(startButton);
        assertEquals("Start", startButton.getText());
        assertFalse(startButton.isDisabled());
        assertEquals(270, startButton.getTranslateX());
        assertEquals(435, startButton.getTranslateY());
    }

    @Test
    void testCreatePlayerLabel() {
        Label playerLabel = game.createPlayerLabel();
        assertNotNull(playerLabel);
        assertEquals(84, playerLabel.getTranslateX());
        assertEquals(415, playerLabel.getTranslateY());
    }

    @Test
    void testCreateStartLabel() {
        Label startLabel = game.createStartLabel();
        assertNotNull(startLabel);
        assertEquals("Start", startLabel.getText());
        assertEquals(277, startLabel.getTranslateX());
        assertEquals(415, startLabel.getTranslateY());
    }

    @Test
    void testCreateContent() {
        Pane content = game.createContent();
        assertNotNull(content);
        assertEquals(106, content.getChildren().size());
    }
}