package com.adventuregame;

/**
 * This class defines constants used throughout the adventure game application.
 * It includes visual elements, file paths, enums for character types and difficulty levels,
 * and utility methods for validating user choices and handling movement directions.
 */
public class Constants {

    // Visual elements
        public static final char TREE = '#'; // Change to correspond to the characters used in the .txt file to define inaccessible squares
        public static final char CHARACTER = 'x';
        public static char GOAL = '@';

    //Path of the 2D map file
        public static final String MAP_FILE_PATH ="resources/map.txt";


    //Constants system for the character

        // Enumeration for character selection
            public enum CharacterType  {
                ADVENTURER('A'),
                RANGER('R'),
                CONQUISTADOR('C');

                private final char choice;

                CharacterType (char choice) {
            this.choice = choice;
        }

                public char getChoice(){
            return choice;
        }
                public static CharacterType  fromKey(char key) {
                    for(CharacterType  type : values()) {
                        if (type.getChoice() == key) {
                            return type;
                        }
                    }
                    return null;
                }
            }
        //Boolean to check if the character choice is valid
            public static boolean isValidChoice(char choix) {

                return choix == 'A' || choix == 'R' || choix == 'C';
            }

    //Constants system for movements and directions

        //Directions
            public enum Direction {
                UP('N'),
                DOWN('S'),
                RIGHT('E'),
                LEFT('W');
                private final char key;

                Direction(char key) {
            this.key = key;
        }

                public char getKey() {
            return key;
        }

                public static Direction fromKey(char key) {
                    for (Direction direction : values()) {
                        if (direction.getKey() == key) {
                            return direction;
                        }
                    }
                    return null;
                }
            }
        // Movements
            public enum Movement {
                UP(0, -1),
                DOWN(0, 1),
                RIGHT(1, 0),
                LEFT(-1, 0);

                private final int deltaX;
                private final int deltaY;

                Movement(int deltaX, int deltaY) {
                    this.deltaX = deltaX;
                    this.deltaY = deltaY;
                }

                public int getDeltaX() {
                return deltaX;
            }

                public int getDeltaY() {
                return deltaY;
            }
            }
            /**
            * Get the delta values (change in x and y coordinates) for a given direction.
            *
            * @param direction The direction for which to retrieve delta values.
            * @return An array containing the change in x and y coordinates corresponding to the given direction.
            * @throws IllegalArgumentException if the direction is not recognized.
            */
            public static int[] getDeltas(Direction direction) {
                return switch (direction) {
                    case UP -> new int[]{Movement.UP.getDeltaX(), Movement.UP.getDeltaY()};
                    case DOWN -> new int[]{Movement.DOWN.getDeltaX(), Movement.DOWN.getDeltaY()};
                    case RIGHT -> new int[]{Movement.RIGHT.getDeltaX(), Movement.RIGHT.getDeltaY()};
                    case LEFT -> new int[]{Movement.LEFT.getDeltaX(), Movement.LEFT.getDeltaY()};
                    default -> throw new IllegalArgumentException("Unhandled direction: " + direction);
                };
            }
        //Check if the direction is valid
            static boolean isValidDirection(String directions) {
                for (char directionKey : directions.toCharArray()) {
                    if (Constants.Direction.fromKey(directionKey) == null) {
                        return false;
                    }
                }
                return true;
            }


    //Constants system objectives based on difficulty level

        //Positions of Objectives based on levels
            public static final Position EASY_POSITION = new Position(9, 2);
            public static final Position NORMAL_POSITION = new Position(0, 7);
            public static final Position HARD_POSITION = new Position(6, 18);

        // Enumeration for difficulty level selection
            public enum Level {
                EASY('1'),
                NORMAL('2'),
                HARD('3');

                private final char level;

                Level(char level) {
            this.level = level;
        }

                public char getLevel() {
            return level;
        }

                public static Level fromKey(char key) {
                    for (Level levels : values()) {
                        if (levels.getLevel() == key) {
                            return levels;
                        }
                    }
                    return null;
                }
            }
        // Check if the level is valid
            public static boolean isValidLevel(char choice) {

                return choice == '1' || choice == '2' || choice == '3';
            }
    // Text constants for explanation
    public static final String CHARACTERS_EXPLANATION = "The adventurer can only move one cell at a time. He is the most basic character.\n" +
            "The ranger can move two cells at a time and jump a tree if the cell behind the tree is accessible.\n" +
            "The Conquistador always moves in a strait line until he meets a tree.";

}
