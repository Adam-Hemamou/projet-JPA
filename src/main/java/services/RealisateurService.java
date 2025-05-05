package services;

import AbstractClass.GenericService;
import DAO.RealisateurDAO;
import entities.Realisateur;

public class RealisateurService extends GenericService<Realisateur, String> {
    public RealisateurService(RealisateurDAO realisateurDAO) {
        super(realisateurDAO);
    }
}
