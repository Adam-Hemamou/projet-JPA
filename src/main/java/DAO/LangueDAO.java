package DAO;

import AbstractClass.GenericDAO;
import entities.Langue;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class LangueDAO extends GenericDAO<Langue, Long> {

    public Optional<Langue> findByNom(String nom) {
        TypedQuery<Langue> query = entityManager.createQuery("SELECT l FROM Langue l WHERE l.nom = :nom", Langue.class);
        query.setParameter("nom", nom);
        return query.getResultList().stream().findFirst();
    }
}
