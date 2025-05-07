package services;

import AbstractClass.GenericService;
import DAO.RealisateurDAO;
import entities.Realisateur;

/**
 * Service pour les opérations CRUD sur les entités Realisateur.
 */
public class RealisateurService extends GenericService<Realisateur, String> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param realisateurDAO le DAO à utiliser pour les opérations de base de données de la table Realisateur
     */
    public RealisateurService(RealisateurDAO realisateurDAO) {
        super(realisateurDAO);
    }
}
