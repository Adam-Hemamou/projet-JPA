package services;

import AbstractClass.GenericService;
import DAO.LangueDAO;
import entities.Langue;

import java.util.Optional;

/**
 * Service pour les opérations CRUD sur les entités Langue.
 */
public class LangueService extends GenericService<Langue, Long> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param langueDAO le DAO à utiliser pour les opérations de base de données de la table Langue
     */
    public LangueService(LangueDAO langueDAO) {
        super(langueDAO);
    }

    /**
     * Trouve une langue par son nom.
     *
     * @param nom le nom de la langue
     * @return un Optional contenant la langue trouvée ou vide s'il n'existe pas
     */
    public Optional<Langue> findByNom(String nom) {
        return ((LangueDAO) getDAO()).findByNom(nom);
    }
}
