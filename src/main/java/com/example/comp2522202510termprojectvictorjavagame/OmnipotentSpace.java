package com.example.comp2522202510termprojectvictorjavagame;

import java.util.Objects;
import java.util.Random;

/**
 * Generates omnipotent positions and each position's effects on the player.
 *
 * @author Victor Lum
 * @version 2025
 */
public class OmnipotentSpace extends Space {
    private static final int WIN_NUMBER = 100;
    private static final int BOUND_NUMBER = 4;
    private final int omnipotentPosition;

    /**
     * Initializes OmnipotentSpace with values to omnipotentPosition and position.
     * @param omnipotentPosition as an int
     * @param position as an int
     */
    public OmnipotentSpace(final int omnipotentPosition, final int position) {
        super(position);
        this.omnipotentPosition = omnipotentPosition;
    }

    /**
     * Uses the omnipotent force to determine the new position for the player.
     * @param omnipotentPosition as an int
     * @return omnipotentForce as an int
     */
    public static int determineNewPosition(final int omnipotentPosition) {
        Random random = new Random();
        int omnipotentForce = omnipotentPosition + (random.nextInt(BOUND_NUMBER) + 1)
                * (random.nextInt(2) * 2 - 1);
        if (omnipotentForce > WIN_NUMBER) {
            return ((WIN_NUMBER - omnipotentPosition) - (omnipotentForce - WIN_NUMBER)
                    + omnipotentPosition);
        } else {
            return omnipotentForce;
        }
    }

    /**
     * Accesses the omnipotentPosition value in OmnipotentSpace.
     * @return omnipotentPosition as an int
     */
    public int getOmnipotentPosition() {
        return omnipotentPosition;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        OmnipotentSpace omnipotentSpace = (OmnipotentSpace) object;
        return omnipotentPosition == omnipotentSpace.omnipotentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), omnipotentPosition);
    }

    @Override
    public String toString() {
        final StringBuilder sbuilder = new StringBuilder("OmnipotentSpace{");
        sbuilder.append("omnipotentPosition=");
        sbuilder.append(omnipotentPosition);
        sbuilder.append('}');
        return sbuilder.toString();
    }
}
