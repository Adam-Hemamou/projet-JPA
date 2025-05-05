package services;

import AbstractClass.GenericDAO;
import AbstractClass.GenericService;
import DAO.GenreDAO;
import entities.Genre;

public class GenreService extends GenericService<Genre, Long> {
    public GenreService(GenreDAO genreDAO) {
        super(genreDAO);
    }
}
