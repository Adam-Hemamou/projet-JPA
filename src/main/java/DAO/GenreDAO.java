package DAO;

import AbstractClass.GenericDAO;
import entities.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

/**
 * Classe DAO pour les opérations CRUD sur les entités Genre.
 */
public class GenreDAO extends GenericDAO<Genre, Long> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public GenreDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Trouve un genre par son nom.
     *
     * @param nom le nom du genre
     * @return un Optional contenant le genre trouvé ou vide si elle n'existe pas
     */
    public Optional<Genre> findByNom(String nom) {
        TypedQuery<Genre> query = entityManager.createQuery("SELECT g FROM Genre g WHERE g.nom = :nom", Genre.class);
        query.setParameter("nom", nom);
        return query.getResultList().stream().findFirst();
    }
}
