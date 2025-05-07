package services;

import AbstractClass.GenericService;
import DAO.GenreDAO;
import entities.Genre;

import java.util.Optional;

/**
 * Service pour les opérations CRUD sur les entités Genre.
 */
public class GenreService extends GenericService<Genre, Long> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param genreDAO le DAO à utiliser pour les opérations de base de données de la table Genre
     */
    public GenreService(GenreDAO genreDAO) {
        super(genreDAO);
    }

    /**
     * Trouve un genre par son nom.
     * Vérifie si le genre existe déjà en base de données.
     *
     * @param nom le nom du genre
     * @return un Optional contenant le genre trouvé ou vide s'il n'existe pas
     */
    public Optional<Genre> findByNom(String nom) {
        return ((GenreDAO) getDAO()).findByNom(nom);
    }

}
