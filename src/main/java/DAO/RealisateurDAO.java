package DAO;

import AbstractClass.GenericDAO;
import entities.Realisateur;
import jakarta.persistence.EntityManager;

/**
 * Classe DAO pour les opérations CRUD sur les entités Realisateur.
 */
public class RealisateurDAO extends GenericDAO<Realisateur, String> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public RealisateurDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
