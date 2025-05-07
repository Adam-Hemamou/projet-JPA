package DAO;

import AbstractClass.GenericDAO;
import entities.Pays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Optional;

/**
 * Classe DAO pour les opérations CRUD sur les entités Pays.
 */
public class PaysDAO extends GenericDAO<Pays, Long> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public PaysDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Trouve un pays par son nom.
     *
     * @param nom le nom du pays
     * @return un Optional contenant le pays trouvé ou vide si elle n'existe pas
     */
    public Optional<Pays> findByNom(String nom) {
        TypedQuery<Pays> query = entityManager.createQuery("SELECT p FROM Pays p WHERE p.nom = :nom", Pays.class);
        query.setParameter("nom", nom);
        return query.getResultList().stream().findFirst();
    }
}
