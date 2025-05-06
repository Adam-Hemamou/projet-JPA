package DAO;

import AbstractClass.GenericDAO;
import entities.Realisateur;
import jakarta.persistence.EntityManager;

public class RealisateurDAO extends GenericDAO<Realisateur, String> {

    public RealisateurDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
