package com.cirilgroup.sujetaventurier;

/**
 * représente la forêt dans laquelle l'aventurier va se déplacer
 */
public class Foret {

    private final char[][] foret;

    public Foret(char[][] foret) {
        this.foret = foret;
    }

    /**
     *
     * @param x Coordonnée x de la case.
     * @param y Coordonnée y de la case.
     * @return true si la case est accessible, false sinon.
     */
    public boolean estCaseAccessible(int x, int y) {
        return x >= 0 && x < foret[0].length && y >= 0 && y < foret.length && foret[y][x] != Constantes.ARBRE;
    }

    /**
     * Affiche la forêt avec le personnage représenté par un 'x'.
     *
     * @param positionPersonnage Détermine la position du personnage dans la forêt.
     */
    public void afficherForetAvecPersonnage(Position positionPersonnage) {
        for (int i = 0; i < foret.length; i++) {
            char[] ligneAffichage = foret[i].clone();
            if (i == positionPersonnage.getY()) {
                ligneAffichage[positionPersonnage.getX()] = Constantes.PERSONNAGE;
            }
            System.out.println(new String(ligneAffichage));
        }
        System.out.println("-".repeat(foret[0].length + 2));  // Ligne de séparation pour plus de lisibilité
    }
}
