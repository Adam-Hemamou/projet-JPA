package DAO;

import AbstractClass.GenericDAO;
import entities.Film;
import jakarta.persistence.EntityManager;

public class FilmDAO extends GenericDAO<Film, String> {

    public FilmDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
