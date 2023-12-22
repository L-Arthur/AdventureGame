package com.cirilgroup.sujetaventurier;

import java.util.Scanner;

/**
 * Classe utilitaire pour gérer la saisie utilisateur
 */
public class SaisieUtilisateur {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Demande à l'utilisateur d'entrer la position initiale dans la forêt.
     *
     * @param foret La forêt dans laquelle la position initiale doit être accessible.
     * @return La position initiale entrée par l'utilisateur.
     */
    public static Position demanderPositionInitiale(Foret foret) {
        while (true) {
            int xDepart = demanderCoordonnee("Entrez la position initiale en x : ");
            int yDepart = demanderCoordonnee("Entrez la position initiale en y : ");

            if (foret.estCaseAccessible(xDepart, yDepart)) {
                return new Position(xDepart, yDepart);
            } else {
                System.out.println("Erreur : La position initiale n'est pas accessible. Veuillez réessayer.");
            }
        }
    }

    /**
     * Demande à l'utilisateur d'entrer les directions du personnage.
     *
     * @return Les directions entrées par l'utilisateur.
     */
    public static String demanderDirections() {
        System.out.println("Entrez les directions du personnage (par exemple, 'SSEEN'): ");
        return scanner.nextLine();
    }

    /**
     * Fonction utilisée dans la fonction demanderPositionInitiale.
     *
     * @param message Le message à afficher dans la fonction
     * @return La coordonnée entrée par l'utilisateur
     */
    private static int demanderCoordonnee(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    /**
     * Ferme le scanner, libérant ainsi les ressources.
     */
    public static void fermerScanner() {
        scanner.close();
    }
}
