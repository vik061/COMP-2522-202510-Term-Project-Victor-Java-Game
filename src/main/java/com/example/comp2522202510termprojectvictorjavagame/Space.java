package com.example.comp2522202510termprojectvictorjavagame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Space extends Rectangle {
    private int position;
    protected boolean isStart;
    protected boolean isEnd;
    protected boolean isOmnipotentSix;

    public Space(int position, boolean isStart, boolean isEnd, boolean isOmnipotentSix) {
        setWidth(position);
        setHeight(position);
        this.position = position;
        this.isStart = position == 1;
        this.isEnd = position == 100;
        this.isOmnipotentSix = position % 6 == 0;

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
