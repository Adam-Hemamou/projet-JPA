package services;

import AbstractClass.GenericService;
import DAO.AdresseDAO;
import entities.Adresse;

import java.util.Optional;

/**
 * Service pour les opérations CRUD sur les entités Adresse.
 */
public class AdresseService extends GenericService<Adresse, Long> {

    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param adresseDAO le DAO à utiliser pour les opérations de base de données de la table Adresse
     */
    public AdresseService(AdresseDAO adresseDAO) {
        super(adresseDAO);
    }

    /**
     * Trouve ou crée une adresse par son numéro et son libellé.
     * Vérifie d'abord si l'adresse existe déjà en base de données.
     * Si l'adresse existe, retourne l'adresse existante.
     * Sinon, crée une nouvelle adresse et l'insère dans la base de données.
     *
     * @param numero le numéro de l'adresse
     * @param libelle le libellé de l'adresse
     * @param ville la ville de l'adresse
     * @param region la région de l'adresse
     * @return un Optional contenant l'adresse trouvée ou créée
     */
    public Optional<Adresse> findOrCreateAdresse(int numero, String libelle, String ville, String region) {
        Optional<Adresse> adresseExistante = ((AdresseDAO) getDAO()).findByNumeroAndLibelle(numero, libelle);

        if (adresseExistante.isPresent()) {
            return adresseExistante;
        } else {
            Adresse nouvelleAdresse = new Adresse();
            nouvelleAdresse.setNumero(numero);
            nouvelleAdresse.setLibelle(libelle);

            save(nouvelleAdresse);
            return Optional.of(nouvelleAdresse);
        }
    }
}
