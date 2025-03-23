package com.example.comp2522202510termprojectvictorjavagame;

import java.util.Random;

public class OmnipotentSpace extends Space {
    public int omnipotentPosition;
    private static final int WIN_NUMBER = 100;

    public OmnipotentSpace(int omnipotentPosition, int position, boolean isStart, boolean isEnd, boolean isOmnipotentSix) {
        super(position, isStart, isEnd, isOmnipotentSix);
        this.omnipotentPosition = omnipotentPosition;
    }

    public static int determineNewPosition(final int omnipotentPosition) {
        Random random = new Random();
        int omnipotentForce = omnipotentPosition + (random.nextInt(4) + 1) * (random.nextInt(2) * 2 - 1);
        if (omnipotentForce > WIN_NUMBER) {
            return ((WIN_NUMBER - omnipotentPosition) - (omnipotentForce - WIN_NUMBER) + omnipotentPosition);
        } else {
            return omnipotentForce;
        }
    }
}
