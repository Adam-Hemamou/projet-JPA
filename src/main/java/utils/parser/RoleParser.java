package utils.parser;

import entities.Acteur;
import entities.Film;
import entities.Role;

public class RoleParser {

    public static Role parse(String[] record) {
        Role role = new Role();
        Film film = new Film();
        film.setId(getSafeValue(record, 0)); // ID film
        role.setFilm(film);

        Acteur acteur = new Acteur();
        acteur.setId(getSafeValue(record, 1)); // ID acteur
        role.setActeur(acteur);

        role.setNom(getSafeValue(record, 2)); // Nom du rôle
        return role;
    }

    private static String getSafeValue(String[] record, int index) {
        return index < record.length && record[index] != null ? record[index].trim() : "";
    }
}
