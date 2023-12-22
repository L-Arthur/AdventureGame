package com.cirilgroup.sujetaventurier;

import java.io.*;

/**
 * Crée une "forêt" à partir de la ressource carte v2.txt.
 */
public class LecteurCarte {
    private static final String CHEMIN_FICHIER_CARTE = Constantes.CHEMIN_FICHIER_CARTE;

    /**
     * Crée la "forêt".
     *
     * @return une instance de la classe Foret
     */
    public static Foret creerForetDepuisFichier() {
        char[][] foret = lireFichierForet();
        if (foret != null) {
            return new Foret(foret);
        } else {
            return null;
        }
    }

    /**
     * Lecture du fichier.
     *
     * @return Un tableau 2D représentant la forêt ou null si une erreur survient.
     */
    private static char[][] lireFichierForet() {
        try (BufferedReader br = new BufferedReader(new FileReader(LecteurCarte.CHEMIN_FICHIER_CARTE))) {
            // Utilisation de la méthode lines() pour obtenir un flux de lignes du fichier
            // Utilisation de map pour convertir chaque ligne en un tableau de caractères
            // Utilisation de toArray pour obtenir un tableau 2D résultant
            return br.lines().map(String::toCharArray).toArray(char[][]::new);
        } catch (IOException e) {
            System.err.printf("Le fichier %s n'a pas été trouvé.%n", CHEMIN_FICHIER_CARTE);
            return null;
        }
    }
}
