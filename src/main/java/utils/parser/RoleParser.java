package utils.parser;

import entities.Acteur;
import entities.Film;
import entities.Role;

public class RoleParser {

    public static Role parse(String[] record) {
        Role role = new Role();
        Film film = new Film();
        film.setId(record[0].trim());
        role.setFilm(film);

        Acteur acteur = new Acteur();
        acteur.setId(record[1].trim());
        role.setActeur(acteur);

        role.setNom(record[2].trim());
        return role;
    }
}
