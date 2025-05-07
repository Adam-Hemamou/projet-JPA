package DAO;

import AbstractClass.GenericDAO;
import entities.Film;
import jakarta.persistence.EntityManager;

/**
 * Classe DAO pour les opérations CRUD sur les entités Film.
 */
public class FilmDAO extends GenericDAO<Film, String> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public FilmDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
