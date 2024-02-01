package com.adventuregame;

import static com.adventuregame.Constants.*;

/**
 * Represents a generic character in the adventure game.
 */
public abstract class Character {
    private Position position;

    // Uncomment if you want to allow users to specify their initial position on the map
    /*
    public Character(Position position) {
        this.position = position;
    }*/

    // Constructor with a default starting position
    public Character() {
        this.position = new Position(3, 0);
    }

    public Position getPosition() {
        return position;
    }
    protected void setPosition(Position newPosition) {
        this.position = newPosition;
    }


    /**
     * Move the character's position based on the specified direction.
     *
     * @param forest    The forest in which the character is moving.
     * @param direction The direction of movement (N, S, E, W).
     */
    public void move(Forest forest, Direction direction) {

        if (direction == null ) {
            throw new IllegalArgumentException("Invalid direction: " + null);
        }
        int x = position.getX();
        int y = position.getY();

        int[] deltas = getDeltas(direction);

        if (forest.isAccessibleCell(x + deltas[0], y + deltas[1])) {
            position = new Position(x + deltas[0], y + deltas[1]);
        }
    }
}
