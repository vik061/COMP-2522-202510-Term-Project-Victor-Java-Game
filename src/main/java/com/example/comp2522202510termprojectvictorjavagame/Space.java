package com.example.comp2522202510termprojectvictorjavagame;

import javafx.scene.shape.Rectangle;

/**
 * Creates spaces on board as reference for positioning purposes.
 *
 * @author Victor Lum
 * @version 2025
 */
public class Space extends Rectangle {
    private int position;

    /**
     * Initializes Space with values to position.
     * @param position as an int
     */
    public Space(final int position) {
        setWidth(position);
        setHeight(position);
        this.position = position;
    }

    /**
     * Sets the X coordinate for a position's place on the Board.
     * @param place as an int
     */
    public void setTranslateX(final int place) {
        super.setTranslateX(place);
    }

    /**
     * Sets the Y coordinate for a position's place on the Board.
     * @param place as an int
     */
    public void setTranslateY(final int place) {
        super.setTranslateY(place);
    }
}
