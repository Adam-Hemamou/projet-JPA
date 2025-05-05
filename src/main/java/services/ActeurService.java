package services;

import AbstractClass.GenericService;
import DAO.ActeurDAO;
import entities.Acteur;

public class ActeurService extends GenericService<Acteur, String> {

    public ActeurService(ActeurDAO acteurDAO) {
        super(acteurDAO);
    }
}
