package com.cirilgroup.sujetaventurier;

/**
*La classe principale d'un petit jeu où un aventurier se déplace dans une forêt
 */
public class JeuAventurier {
    public static void main(String[] args) {

        Foret foret = LecteurCarte.creerForetDepuisFichier();

        if (foret != null) {
            Position positionPersonnage = SaisieUtilisateur.demanderPositionInitiale(foret);
            foret.afficherForetAvecPersonnage(positionPersonnage);

            String directions = SaisieUtilisateur.demanderDirections();
            for (char direction : directions.toCharArray()) {
                positionPersonnage = DeplacementPersonnage.deplacer(foret, positionPersonnage, direction);
                foret.afficherForetAvecPersonnage(positionPersonnage);
            }

            SaisieUtilisateur.fermerScanner();

        System.out.printf("Coordonnées finales du personnage : (%d, %d)%n", positionPersonnage.getX(), positionPersonnage.getY());
        }
    }
}

