package DAO;

import AbstractClass.GenericDAO;
import entities.LieuNaissance;
import jakarta.persistence.EntityManager;

public class LieuNaissanceDAO extends GenericDAO<LieuNaissance, Long> {

    public LieuNaissanceDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
