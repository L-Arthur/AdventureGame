package com.adventuregame;

/**
 * The main class of a small game where an adventurer moves in a forest toward an objective.
 */
public class AdventureGame {
    public static void main(String[] args) {

        // Create a forest from a file
        Forest forest = MapReader.createForestFromFile();

        if (forest != null) {
            // Display the forest without the character nor the objective
            forest.displayForestWithPlayerAndObjective(null, null);

            // Selection of the difficulty setting
            char levelChoice = UserInput.choseLevel();
            Constants.Level level = Constants.Level.fromKey(levelChoice);
            forest.initObjective(level);
            forest.displayForestWithPlayerAndObjective(null, forest.getObjective().getPosition());

            // Selection of the character
            char characterChoice = UserInput.characterChoiceInput();
            // Convert user choice to Enum
            Constants.CharacterType  characterType  = Constants.CharacterType .fromKey(characterChoice);

            // Uncomment if you want to make the users place themselves on the map
            /*
            Position characterPosition = UserInput.requestInitialPosition(forest);
            */

            // Create the character instance based on the user choice
            Character character;
            switch (characterType) {
                case ADVENTURER:
                    character = new Adventurer();
                    break;
                case RANGER:
                    character = new Ranger();
                    break;
                case CONQUISTADOR:
                    character = new Conquistador();
                    break;
                default:
                    System.out.println("Invalid character choice. Using default character.");
                    character = new Adventurer();
                    break;
            }
            // Display the forest with the character and objective
            forest.displayForestWithPlayerAndObjective(character.getPosition(), forest.getObjective().getPosition());

            // Get input for character movements
            String directions = UserInput.directionsInput();
            for (char direction : directions.toCharArray()) {
                // Convert char to Direction before calling the move method
                Constants.Direction directionEnum = Constants.Direction.fromKey(direction);
                character.move(forest, directionEnum);
                forest.displayForestWithPlayerAndObjective(character.getPosition(), forest.getObjective().getPosition());
            }
            // Check the victory condition by calling the victoryCheck method of Objective
            forest.getObjective().victoryCheck(character.getPosition(), level);

            // Close the scanner
            UserInput.closeScanner();


        // Display the final character coordinates
        System.out.printf("Final character coordinates: (%d, %d)%n", character.getPosition().getX(), character.getPosition().getY());
        }
    }
}

