package DAO;

import AbstractClass.GenericDAO;
import entities.Adresse;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class AdresseDAO extends GenericDAO<Adresse, Long> {
    public AdresseDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Optional<Adresse> findByNumeroAndLibelle(int numero, String libelle) {
        return entityManager.createQuery(
                        "SELECT a FROM Adresse a WHERE a.numero = :numero AND a.libelle = :libelle", Adresse.class)
                .setParameter("numero", numero)
                .setParameter("libelle", libelle)
                .getResultStream()
                .findFirst();
    }

}
