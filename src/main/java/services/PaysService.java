package services;

import AbstractClass.GenericService;
import DAO.PaysDAO;
import entities.Pays;

public class PaysService extends GenericService<Pays, Long> {
    public PaysService(PaysDAO paysDAO) {
        super(paysDAO);
    }
}
