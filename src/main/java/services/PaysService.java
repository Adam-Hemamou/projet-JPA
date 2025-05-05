package services;

import AbstractClass.GenericService;
import DAO.PaysDAO;
import entities.Pays;

import java.util.Optional;


public class PaysService extends GenericService<Pays, Long> {
    public PaysService(PaysDAO paysDAO) {
        super(paysDAO);
    }


    public Optional<Pays> findByNom(String nom) {
        return ((PaysDAO) getDAO()).findByNom(nom);
    }
}
