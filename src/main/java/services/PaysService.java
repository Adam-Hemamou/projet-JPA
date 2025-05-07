package services;

import AbstractClass.GenericService;
import DAO.PaysDAO;
import entities.Pays;

import java.util.Optional;

/**
 * Service pour les opérations CRUD sur les entités Pays.
 */
public class PaysService extends GenericService<Pays, Long> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param paysDAO le DAO à utiliser pour les opérations de base de données de la table Pays
     */
    public PaysService(PaysDAO paysDAO) {
        super(paysDAO);
    }

    /**
     * Trouve un pays par son nom.
     *
     * @param nom le nom du pays
     * @return un Optional contenant le pays trouvé ou vide s'il n'existe pas
     */
    public Optional<Pays> findByNom(String nom) {
        return ((PaysDAO) getDAO()).findByNom(nom);
    }
}
