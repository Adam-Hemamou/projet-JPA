package services;

import AbstractClass.GenericService;
import DAO.ActeurDAO;
import entities.Acteur;

/**
 * Service pour les opérations CRUD sur les entités Acteur.
 */
public class ActeurService extends GenericService<Acteur, String> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param acteurDAO le DAO à utiliser pour les opérations de base de données de la table Acteur
     */
    public ActeurService(ActeurDAO acteurDAO) {
        super(acteurDAO);
    }
}
