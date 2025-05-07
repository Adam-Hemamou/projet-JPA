package services;

import AbstractClass.GenericService;
import DAO.LieuNaissanceDAO;
import entities.LieuNaissance;

/**
 * Service pour les opérations CRUD sur les entités LieuNaissance.
 */
public class LieuNaissanceService  extends GenericService<LieuNaissance, Long> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param lieuNaissanceDAO le DAO à utiliser pour les opérations de base de données de la table LieuNaissance
     */
    public LieuNaissanceService(LieuNaissanceDAO lieuNaissanceDAO) {
        super(lieuNaissanceDAO);
    }
}
