package DAO;

import AbstractClass.GenericDAO;
import entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

public class GenreDAO extends GenericDAO<Genre, Long> {

    public GenreDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Optional<Genre> findByNom(String nom) {
        TypedQuery<Genre> query = entityManager.createQuery("SELECT g FROM Genre g WHERE g.nom = :nom", Genre.class);
        query.setParameter("nom", nom);
        return query.getResultList().stream().findFirst();
    }
}
