package com.adventuregame;

import java.io.*;

/**
 * Creates a "forest" from the map.txt resource.
 */
public class MapReader  {
    private static final String MAP_FILE_PATH = Constants.MAP_FILE_PATH;

    /**
     * Creates the "forest".
     *
     * @return an instance of the Forest class
     */
    public static Forest createForestFromFile() {
        char[][] forest = readFileForest();
        if (forest != null) {
            return new Forest(forest);
        } else {
            return null;
        }
    }

    /**
     * Reads the file.
     *
     * @return A 2D array representing the forest or null if an error occurs.
     */
    private static char[][] readFileForest() {
        try (BufferedReader br = new BufferedReader(new FileReader(MapReader.MAP_FILE_PATH))) {
            // Utilisation de la méthode lines() pour obtenir un flux de lignes du fichier
            // Utilisation de map pour convertir chaque ligne en un tableau de caractères
            // Utilisation de toArray pour obtenir un tableau 2D résultant
            return br.lines().map(String::toCharArray).toArray(char[][]::new);
        } catch (IOException e) {
            System.err.printf("The file %s was not found.%n", MAP_FILE_PATH);
            return null;
        }
    }
}
