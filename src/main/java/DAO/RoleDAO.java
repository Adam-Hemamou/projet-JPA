package DAO;

import AbstractClass.GenericDAO;
import entities.Role;
import entities.RoleId;
import jakarta.persistence.EntityManager;

/**
 * Classe DAO pour les opérations CRUD sur les entités Role.
 */
public class RoleDAO extends GenericDAO<Role, RoleId> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public RoleDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
