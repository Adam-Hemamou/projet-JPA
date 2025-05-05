package services;

import AbstractClass.GenericService;
import DAO.FilmDAO;
import entities.Film;

public class FilmService extends GenericService<Film, String> {

    public FilmService(FilmDAO filmDAO) {
        super(filmDAO);
    }

}
