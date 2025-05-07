package utils.parser;

import entities.Acteur;
import entities.Film;
import entities.Role;

/**
 * Classe utilitaire pour analyser les données des rôles à partir d'un tableau de chaînes.
 */
public class RoleParser {

    /**
     * Analyse un tableau de chaînes pour créer une instance de Role.
     *
     * @param record le tableau de chaînes contenant les données du rôle
     * @return une instance de Role créée à partir des données analysées
     */
    public static Role parse(String[] record) {
        Role role = new Role();
        Film film = new Film();
        film.setId(getSafeValue(record, 0));
        role.setFilm(film);

        Acteur acteur = new Acteur();
        acteur.setId(getSafeValue(record, 1));
        role.setActeur(acteur);

        role.setNom(getSafeValue(record, 2));
        return role;
    }

    private static String getSafeValue(String[] record, int index) {
        return index < record.length && record[index] != null ? record[index].trim() : "";
    }
}
