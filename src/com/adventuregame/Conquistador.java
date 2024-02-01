package com.adventuregame;

import static com.adventuregame.Constants.getDeltas;

/**
 * Represents the Conquistador character in the game. The Conquistador moves in a strait line until he meets a tree.
 */
public class Conquistador extends Character {

    public Conquistador() {super();}
    // Uncomment if you want to allow users to specify their initial position on the map
    /*
    public Conquistador(Position position){
        super(position);
    }*/

    @Override
    public void move(Forest forest, Constants.Direction direction){
        int x = getPosition().getX();
        int y = getPosition().getY();

        int[] deltas = getDeltas(direction);

        while (forest.isAccessibleCell(x + deltas[0], y + deltas[1])) {
            setPosition(new Position(x + deltas[0], y + deltas[1]));
            x = getPosition().getX();
            y = getPosition().getY();
        }
    }
}

