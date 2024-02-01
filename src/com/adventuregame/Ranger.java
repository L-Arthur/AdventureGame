package com.adventuregame;

import static com.adventuregame.Constants.getDeltas;

/**
 * Represents the ranger character in the game. The ranger can move two cells at a time and jump a tree if the cell behind the tree is accessible.
 */
public class Ranger extends Character {

    // Uncomment if you want to allow users to specify their initial position on the map
    /*
    public Ranger(Position position) {
        super(position);
    }*/
    public Ranger() {super();}

    @Override
    public void move(Forest forest, Constants.Direction direction) {

        if (direction == null ) {
            throw new IllegalArgumentException("Invalid direction: " + null);
        }
        int x = getPosition().getX();
        int y = getPosition().getY();

        int[] deltas = getDeltas(direction);

        // Check if jumping over the tree is possible
        if (forest.isAccessibleCell(x + 2 * deltas[0], y + 2 * deltas[1])) {
            setPosition(new Position(x + 2 * deltas[0], y + 2 * deltas[1]));
        } else if (forest.isAccessibleCell(x + deltas[0], y + deltas[1])) {
            // If jumping is not possible, perform a standard movement
            setPosition(new Position(x + deltas[0], y + deltas[1]));
        }
    }
}
