package services;

import AbstractClass.GenericService;
import DAO.GenreDAO;
import entities.Genre;

import java.util.Optional;

public class GenreService extends GenericService<Genre, Long> {
    public GenreService(GenreDAO genreDAO) {
        super(genreDAO);
    }

    public Optional<Genre> findByNom(String nom) {
        return ((GenreDAO) getDAO()).findByNom(nom);
    }

}
