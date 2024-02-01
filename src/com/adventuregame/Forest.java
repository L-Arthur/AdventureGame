package com.adventuregame;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the forest where the adventurer will navigate.
 */
public class Forest {

    private final char[][] forest;
    private final List<Position> trees;
    private final int rows;
    private final int columns;
    private Objective objective;


    public Forest(char[][] forest) {

        // Check that all rows have the same length
        if (!isValidMap(forest)) {
            throw new IllegalArgumentException("The map is not valid");
        }

        this.forest = forest;
        this.rows = forest.length;
        this.columns = (rows > 0) ? forest[0].length : 0;
        this.trees = findTrees();

    }

    public Objective getObjective() {

        return objective;
    }

    /**
     * Initializes the objective based on the specified difficulty level.
     *
     * @param level The difficulty level chosen by the player.
     */
    public void initObjective(Constants.Level level) {
        // Generate the objective based on the difficulty level
        switch (level) {
            case EASY -> this.objective = new Objective(Constants.EASY_POSITION);
            case NORMAL -> this.objective = new Objective(Constants.NORMAL_POSITION);
            case HARD -> this.objective = new Objective(Constants.HARD_POSITION);
            default -> throw new IllegalArgumentException("Invalid difficulty level");
        }
    }

    /**
     * Finds the positions of trees in the forest.
     *
     * @return A list of positions where trees are located.
     */
    private List<Position> findTrees() {
        List<Position> treePositions = new ArrayList<>();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns ; x++) {
                if (forest[y][x] == Constants.TREE) {
                    treePositions.add(new Position(x, y));
                }
            }
        }
        return treePositions;
    }

    /**
     * Checks if the provided forest map is valid.
     *
     * @return True if the forest map is valid, false otherwise.
     */
    private boolean isValidMap(char[][] forest) {
        int firstRowLength = (forest.length > 0) ? forest[0].length : 0;
        for (char[] row : forest) {
            if (row.length != firstRowLength) {
                return false;
            }
        }
        int numRows = forest.length;

        for (int i = 1; i < numRows; i++) {
            if (forest[i].length != forest[i - 1].length) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the specified cell is accessible within the forest boundaries and does not contain a tree.
     *
     * @param x The x-coordinate of the cell.
     * @param y The y-coordinate of the cell.
     * @return true if the cell is accessible, false otherwise.
     */
    public boolean isAccessibleCell(int x, int y) {
        return x >= 0 && x < columns && y >= 0 && y < rows && !containsTree(x, y);
    }

    /**
     * Checks if the specified coordinates contain a tree.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return True if the specified coordinates contain a tree, false otherwise.
     */
    private boolean containsTree(int x, int y) {
        return trees.stream().anyMatch(position -> position.getX() == x && position.getY() == y);
    }

    /**
     * Displays the forest with the character represented by 'x' (Constants.CHARACTER).
     * Displays the forest with the objective represented by '@' (Constants.OBJECTIVE).
     *
     * @param playerPosition Determines the position of the character in the forest.
     * @param position Determines the position of the objective in the forest
     */
    public void displayForestWithPlayerAndObjective(Position playerPosition, Position position) {
        for (int i = 0; i < forest.length; i++) {
            char[] rowDisplayed = forest[i].clone();
            if (playerPosition != null && i == playerPosition.getY()) {
                rowDisplayed[playerPosition.getX()] = Constants.CHARACTER;
                }
                if (objective != null && i == objective.getPosition().getY()) {
                    rowDisplayed[objective.getPosition().getX()] = Constants.GOAL;
                }
                System.out.println(new String(rowDisplayed));
            }
        System.out.println("-".repeat(forest[0].length + 2));  // Separation line for readability
    }
}

