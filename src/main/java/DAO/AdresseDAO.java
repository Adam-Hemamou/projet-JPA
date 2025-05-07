package DAO;

import AbstractClass.GenericDAO;
import entities.Adresse;
import jakarta.persistence.EntityManager;

import java.util.Optional;

/**
 * Classe DAO pour les opérations CRUD sur les entités Adresse.
 */
public class AdresseDAO extends GenericDAO<Adresse, Long> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public AdresseDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Trouve une adresse par son numéro et son libellé.
     *
     * @param numero le numéro de l'adresse
     * @param libelle le libellé de l'adresse
     * @return un Optional contenant l'adresse trouvée ou vide si elle n'existe pas
     */
    public Optional<Adresse> findByNumeroAndLibelle(int numero, String libelle) {
        return entityManager.createQuery(
                        "SELECT a FROM Adresse a WHERE a.numero = :numero AND a.libelle = :libelle", Adresse.class)
                .setParameter("numero", numero)
                .setParameter("libelle", libelle)
                .getResultStream()
                .findFirst();
    }

}
