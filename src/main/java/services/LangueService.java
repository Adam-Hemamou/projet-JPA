package services;

import AbstractClass.GenericService;
import DAO.LangueDAO;
import entities.Langue;

import java.util.Optional;

public class LangueService extends GenericService<Langue, Long> {
    public LangueService(LangueDAO langueDAO) {
        super(langueDAO);
    }

    public Optional<Langue> findByNom(String nom) {
        return ((LangueDAO) getDAO()).findByNom(nom);
    }
}
