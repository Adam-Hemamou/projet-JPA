package services;

import AbstractClass.GenericService;
import DAO.LieuTournageDAO;
import entities.Adresse;
import entities.LieuTournage;

import java.util.Optional;

public class LieuTournageService extends GenericService<LieuTournage, Long> {

    private final AdresseService adresseService;

    public LieuTournageService(LieuTournageDAO lieuTournageDAO, AdresseService adresseService) {
        super(lieuTournageDAO);
        this.adresseService = adresseService;
    }

    public LieuTournage createLieuTournage(String ville, String region, int numero, String libelle) {
        // Vérifie si l'adresse existe déjà, sinon crée une nouvelle adresse
        Adresse adresse = adresseService.findOrCreateAdresse(numero, libelle, ville, region)
                .orElseThrow(() -> new RuntimeException("Erreur lors de la création de l'adresse"));

        // Cast le GenericDAO vers LieuTournageDAO pour accéder à la méthode spécifique
        LieuTournageDAO lieuTournageDAO = (LieuTournageDAO) getDAO();

        // Vérifie si le lieu de tournage existe déjà
        Optional<LieuTournage> existingLieuTournage = lieuTournageDAO.findByVilleAndRegionAndAdresse(ville, region, adresse);
        if (existingLieuTournage.isPresent()) {
            return existingLieuTournage.get(); // Retourner le lieu de tournage existant si trouvé
        }

        // Créer le lieu de tournage avec l'adresse trouvée ou créée
        LieuTournage lieuTournage = new LieuTournage();
        lieuTournage.setVille(ville);
        lieuTournage.setRegion(region);
        lieuTournage.setAdresse(adresse);

        // Enregistrer le lieu de tournage
        return save(lieuTournage);
    }

}
