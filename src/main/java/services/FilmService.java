package services;

import AbstractClass.GenericService;
import DAO.FilmDAO;
import entities.Film;

/**
 * Service pour les opérations CRUD sur les entités Film.
 */
public class FilmService extends GenericService<Film, String> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param filmDAO le DAO à utiliser pour les opérations de base de données de la table Film
     */
    public FilmService(FilmDAO filmDAO) {
        super(filmDAO);
    }

}
