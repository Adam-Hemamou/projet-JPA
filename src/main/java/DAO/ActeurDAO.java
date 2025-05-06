package DAO;

import AbstractClass.GenericDAO;
import entities.Acteur;
import jakarta.persistence.EntityManager;

public class ActeurDAO extends GenericDAO<Acteur, String> {

    public ActeurDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
