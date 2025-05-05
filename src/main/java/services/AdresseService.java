package services;

import AbstractClass.GenericService;
import DAO.AdresseDAO;
import entities.Adresse;

public class AdresseService extends GenericService<Adresse, Long> {
    public AdresseService(AdresseDAO adresseDAO) {
        super(adresseDAO);
    }
}
