package com.example.comp2522202510termprojectvictorjavagame;

import java.util.Random;

public class OmnipotentSpace extends Space {
    int omnipotentPosition;

    public OmnipotentSpace(int omnipotentPosition, int position, boolean isStart, boolean isEnd, boolean isOmnipotentSix) {
        super(position, isStart, isEnd, isOmnipotentSix);
        this.omnipotentPosition = omnipotentPosition;
    }

    public int determineNewPosition(int omnipotentPosition) {
        final int maximum = 5;
        final int minimum = -5;
        Random random = new Random();
        int omnipotentForce = (random.nextInt() - 1) * (random.nextInt(maximum - minimum) - maximum);
        return omnipotentForce;
    }
}
