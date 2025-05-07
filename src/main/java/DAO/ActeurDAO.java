package DAO;

import AbstractClass.GenericDAO;
import entities.Acteur;
import jakarta.persistence.EntityManager;

/**
 * Classe DAO pour les opérations CRUD sur les entités Acteur.
 */
public class ActeurDAO extends GenericDAO<Acteur, String> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public ActeurDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
