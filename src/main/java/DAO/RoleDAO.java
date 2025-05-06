package DAO;

import AbstractClass.GenericDAO;
import entities.Role;
import entities.RoleId;
import jakarta.persistence.EntityManager;

public class RoleDAO extends GenericDAO<Role, RoleId> {

    public RoleDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
