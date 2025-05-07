package DAO;

import AbstractClass.GenericDAO;
import entities.LieuNaissance;
import jakarta.persistence.EntityManager;

/**
 * Classe DAO pour les opérations CRUD sur les entités LieuNaissance.
 */
public class LieuNaissanceDAO extends GenericDAO<LieuNaissance, Long> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public LieuNaissanceDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
