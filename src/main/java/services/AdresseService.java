package services;

import AbstractClass.GenericService;
import DAO.AdresseDAO;
import entities.Adresse;

import java.util.Optional;

public class AdresseService extends GenericService<Adresse, Long> {
    public AdresseService(AdresseDAO adresseDAO) {
        super(adresseDAO);
    }

    public Optional<Adresse> findOrCreateAdresse(int numero, String libelle, String ville, String region) {
        // Recherche d'abord l'adresse existante en fonction de la ville, région et libellé
        Optional<Adresse> adresseExistante = ((AdresseDAO) getDAO()).findByNumeroAndLibelle(numero, libelle);

        if (adresseExistante.isPresent()) {
            // Si l'adresse existe, on retourne l'adresse existante
            return adresseExistante;
        } else {
            // Sinon, on crée une nouvelle adresse
            Adresse nouvelleAdresse = new Adresse();
            nouvelleAdresse.setNumero(numero);
            nouvelleAdresse.setLibelle(libelle);
            // Si nécessaire, tu peux aussi définir la ville et la région dans l'adresse ici, ou les associer différemment

            // Enregistrer la nouvelle adresse
            save(nouvelleAdresse);
            return Optional.of(nouvelleAdresse);
        }
    }
}
