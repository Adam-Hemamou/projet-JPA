package services;

import AbstractClass.GenericService;
import DAO.LangueDAO;
import entities.Langue;

public class LangueService extends GenericService<Langue, Long> {
    public LangueService(LangueDAO langueDAO) {
        super(langueDAO);
    }
}
