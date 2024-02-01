package com.adventuregame;

/**
 * Represents the objective that the player needs to reach in the game.
 */
public class Objective {
    private Position position;

    public Objective(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    /**
     * Checks if the player has reached the objective and prints a message accordingly.
     *
     * @param finalPosition The final position of the player.
     * @param level         The level of difficulty.
     */
    public void victoryCheck(Position finalPosition, Constants.Level level) {
        if (isVictory(finalPosition, level)) {
            System.out.println("Congratulations, you have reached the objective! Victory!");
        } else {
            System.out.println("Sorry, you did not reach the objective. Please try again.");
        }
    }

    /**
     * Checks if the player's final position matches the objective position.
     *
     * @param finalPosition The final position of the player.
     * @param level         The level of difficulty.
     * @return True if the player has reached the objective, false otherwise.
     */
    private boolean isVictory(Position finalPosition, Constants.Level level) {
        Position objectivePosition = switch (level) {
            case EASY -> Constants.EASY_POSITION;
            case NORMAL -> Constants.NORMAL_POSITION;
            case HARD -> Constants.HARD_POSITION;
        };
        return objectivePosition.getX() == finalPosition.getX() && objectivePosition.getY() == finalPosition.getY();
    }
}
