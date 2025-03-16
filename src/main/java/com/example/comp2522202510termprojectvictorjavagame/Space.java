package com.example.comp2522202510termprojectvictorjavagame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Space extends Rectangle {

    public Space(int position) {
        setWidth(position);
        setHeight(position);
        setFill(Color.AQUAMARINE);
        setStroke(Color.BLACK);
    }

    public void SetTranslateX(int position) {
        super.setTranslateX(position);
    }

    public void SetTranslateY(int position) {
        super.setTranslateY(position);
    }
}
