package com.adventuregame;

import java.util.Scanner;

/**
 * Utility class for handling user input.
 */
public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    // Uncomment if you want to allow users to specify their initial position on the map
    /**
     * Requests the user to input the character's initial position in the forest.
     *
     * @param forest The forest in which the initial position must be accessible.
     * @return The initial position entered by the user.
     *//*
    public static Position requestInitialPosition(Forest forest) {
        while (true) {
            int xDepart = requestCoordinate("Enter the initial position in x: ");
            int yDepart = requestCoordinate("Enter the initial position in y: ");

            if (forest.isAccessibleCell(xDepart, yDepart)) {
                return new Position(xDepart, yDepart);
            } else {
                System.out.println("Error: The initial position is not accessible. Please try again.");
            }
        }
    }
    *//**
     * Function used within the requestInitialPosition function.
     *
     * @param message The message to display in the function.
     * @return The coordinate entered by the user.
     *//*
    private static int requestCoordinate(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }*/

    /**
     * Requests the user to input the directions for the character.
     *
     * @return The directions entered by the user.
     */
    public static String directionsInput() {
        boolean inputValid = false;
        String directions = "";

        while (!inputValid) {
            System.out.println("Enter the directions the character should take using N for 'North', S for 'South', E for 'East', and W for 'West',\nand enter them the number of times you want the character to move (ex: SSESSNNWNN): ");
            directions = scanner.nextLine();

            if (Constants.isValidDirection(directions)) {
                inputValid = true;
            } else {
                System.out.println("Error: Enter valid directions (N, S, E, W). Please try again.");
            }
        }

        return directions;
    }

    /**
     * Requests the user to choose the difficulty level.
     *
     * @return The chosen difficulty level.
     */
    public static char choseLevel() {
        boolean inputValid = false;
        char levelChoice = '0';

        while (!inputValid) {
            System.out.println("Choose the difficulty level (1 for Easy, 2 for Normal or 3 for Hard)");
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                levelChoice = input.toUpperCase().charAt(0);

                if (Constants.isValidLevel(levelChoice)) {
                    inputValid = true;
                } else {
                    System.out.println("Error: Enter a valid choice (1, 2, 3). Please try again.");
                }
            } else {
                System.out.println("Error: Enter a non-empty value. Please try again.");
            }
        }

        return levelChoice;
    }

    /**
     * Requests the user to choose the character type.
     *
     * @return The chosen character type.
     */
    public static char characterChoiceInput() {
        boolean inputValid  = false;
        char characterChoice = '0';

        while (!inputValid) {
            System.out.println("Choose the character type (A for Adventurer, R for Ranger, or C for Conquistador): \n"+ Constants.CHARACTERS_EXPLANATION);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                characterChoice = input.toUpperCase().charAt(0);

                if (Constants.isValidChoice(characterChoice)) {
                    inputValid = true;
                } else {
                    System.out.println("Error: Enter a valid choice (A, R, C). Please try again.");
                }
            } else {
                System.out.println("Error: Enter a non-empty value. Please try again.");
            }
        }

        return characterChoice;
    }

    /**
     * Closes the scanner, saving resources.
     */
    public static void closeScanner() {
        scanner.close();
    }

}
