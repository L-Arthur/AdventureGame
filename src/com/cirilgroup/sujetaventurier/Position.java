package com.cirilgroup.sujetaventurier;

/**
 * Représente les coordonnées (x, y) d'une position.
 */
public class Position {

    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Obtient la coordonnée x de la position.
     * @return La coordonnée x.
     */
    public int getX() {
        return x;
    }

    /**
     * Obtient la coordonnée y de la position.
     * @return La coordonnée y.
     */
    public int getY() {
        return y;
    }
}
