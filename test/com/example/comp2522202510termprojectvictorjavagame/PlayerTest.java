package com.example.comp2522202510termprojectvictorjavagame;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;

class PlayerTest {
    private static final int DICE_ANIMATION_DURATION = 100;
    Player player = new Player(20, Color.RED);

    @BeforeAll
    static void initJavaFX() {
        Platform.startup(() -> {});
    }

    @Test
    void testConstructorInitialization() {
        assertEquals(1, player.getPosition());
        assertFalse(player.getFinishedGame());
        assertNotNull(player.getPlayerPiece());
    }

    @Test
    void testSetPlayerPositionValidMove() {
        player.setPlayerPosition(2);
        assertEquals(3, player.getPosition());
    }

    @Test
    void testSetPlayerPositionExceedsWinNumber() {
        player.setPlayerPosition(101);
        assertEquals(1, player.getPosition());
    }

    @Test
    void testReturnToStart() {
        player.setPlayerPosition(50);
        player.returnToStart();
        assertEquals(1, player.getPosition());
        assertFalse(player.getFinishedGame());
    }

    @Test
    void testReachedEnd() {
        player.setPosition(100);
        assertTrue(player.reachedEnd());
        assertEquals(100, player.getPosition());
    }

    @Test
    void testMoveAnimationDuration() {
        TranslateTransition move = player.moveAnimation(5);
        assertEquals(DICE_ANIMATION_DURATION * 5, move.getDuration().toMillis());
    }

    @Test
    void testPlayerPieceAttributes() {
        Player player = new Player(20, Color.BLUE);
        Circle playerPiece = player.getPlayerPiece();
        assertEquals(10, playerPiece.getRadius());
        assertEquals(Color.BLUE, playerPiece.getFill());
    }

    @Test
    void testFinishedGameStatus() {
        player.setPosition(100);
        assertTrue(player.reachedEnd());
    }
}