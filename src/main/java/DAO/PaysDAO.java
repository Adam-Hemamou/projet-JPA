package DAO;

import AbstractClass.GenericDAO;
import entities.Pays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class PaysDAO extends GenericDAO<Pays, Long> {

    public PaysDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Optional<Pays> findByNom(String nom) {
        TypedQuery<Pays> query = entityManager.createQuery("SELECT p FROM Pays p WHERE p.nom = :nom", Pays.class);
        query.setParameter("nom", nom);
        return query.getResultList().stream().findFirst();
    }
}
