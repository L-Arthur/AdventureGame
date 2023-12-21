package com.cirilgroup.sujetaventurier;

public class DeplacementPersonnage {
    /**
     * Déplace la position du personnage en fonction de la direction spécifiée.
     *
     * @param foret La forêt dans laquelle le personnage se déplace.
     * @param position La position actuelle du personnage.
     * @param direction La direction du déplacement (N, S, E, O).
     * @return La nouvelle position du personnage après le déplacement, ou la position actuelle si le déplacement n'est pas possible.
     */
    public static Position deplacer(Foret foret, Position position, char direction) {

        if (direction != 'N' && direction != 'S' && direction != 'E' && direction != 'O') {
            throw new IllegalArgumentException("Direction invalide : " + direction);
        }
        int x = position.getX();
        int y = position.getY();

        Position nouvellePosition = new Position(x, y);

        if (direction == 'N' && foret.estCaseAccessible(x, y - 1)) {
            nouvellePosition = new Position(x, y - 1);
        } else if (direction == 'S' && foret.estCaseAccessible(x, y + 1)) {
            nouvellePosition = new Position(x, y + 1);
        } else if (direction == 'E' && foret.estCaseAccessible(x + 1, y)) {
            nouvellePosition = new Position(x + 1, y);
        } else if (direction == 'O' && foret.estCaseAccessible(x - 1, y)) {
            nouvellePosition = new Position(x - 1, y);
        }

        return nouvellePosition;
    }
}
