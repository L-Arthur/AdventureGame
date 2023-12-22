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

        if (direction != Constantes.DEPLACEMENT_HAUT && direction != Constantes.DEPLACEMENT_BAS && direction != Constantes.DEPLACEMENT_DROITE && direction != Constantes.DEPLACEMENT_GAUCHE) {
            throw new IllegalArgumentException("Direction invalide : " + direction);
        }
        int x = position.getX();
        int y = position.getY();

        if (direction == Constantes.DEPLACEMENT_HAUT && foret.estCaseAccessible(x, y - 1)) {
            return  new Position(x, y - 1);
        } else if (direction == Constantes.DEPLACEMENT_BAS && foret.estCaseAccessible(x, y + 1)) {
            return new Position(x, y + 1);
        } else if (direction == Constantes.DEPLACEMENT_DROITE && foret.estCaseAccessible(x + 1, y)) {
            return new Position(x + 1, y);
        } else if (direction == Constantes.DEPLACEMENT_GAUCHE && foret.estCaseAccessible(x - 1, y)) {
            return new Position(x - 1, y);
        }

        // Si la direction n'est pas valide, retourner la position actuelle
        return position;
    }
}
