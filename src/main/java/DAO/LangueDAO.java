package DAO;

import AbstractClass.GenericDAO;
import entities.Langue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

/**
 * Classe DAO pour les opérations CRUD sur les entités Langue.
 */
public class LangueDAO extends GenericDAO<Langue, Long> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public LangueDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Trouve une langue par son nom.
     *
     * @param nom le nom de la langue
     * @return un Optional contenant la langue trouvée ou vide si elle n'existe pas
     */
    public Optional<Langue> findByNom(String nom) {
        TypedQuery<Langue> query = entityManager.createQuery("SELECT l FROM Langue l WHERE l.nom = :nom", Langue.class);
        query.setParameter("nom", nom);
        return query.getResultList().stream().findFirst();
    }
}
