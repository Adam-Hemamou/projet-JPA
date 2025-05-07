package services;

import AbstractClass.GenericService;
import DAO.LieuTournageDAO;
import entities.Adresse;
import entities.LieuTournage;

import java.util.Optional;

/**
 * Service pour les opérations CRUD sur les entités LieuTournage.
 */
public class LieuTournageService extends GenericService<LieuTournage, Long> {

    private final AdresseService adresseService;

    /**
     * Constructeur pour initialiser le DAO et le service d'adresse.
     *
     * @param lieuTournageDAO le DAO à utiliser pour les opérations de base de données de la table LieuTournage
     * @param adresseService le service d'adresse à utiliser pour gérer les adresses
     */
    public LieuTournageService(LieuTournageDAO lieuTournageDAO, AdresseService adresseService) {
        super(lieuTournageDAO);
        this.adresseService = adresseService;
    }

    /**
     * Crée un lieu de tournage avec une adresse.
     * Vérifie d'abord si l'adresse existe déjà en base de données.
     * Si l'adresse existe, l'utilise. Sinon, crée une nouvelle adresse.
     * Vérifie ensuite si le lieu de tournage existe déjà avec cette adresse.
     * Si le lieu de tournage existe, le retourne. Sinon, crée un nouveau lieu de tournage.
     *
     * @param ville la ville du lieu de tournage
     * @param region la région du lieu de tournage
     * @param numero le numéro de l'adresse
     * @param libelle le libellé de l'adresse
     * @return le lieu de tournage créé ou existant
     */
    public LieuTournage createLieuTournage(String ville, String region, int numero, String libelle) {
        Adresse adresse = adresseService.findOrCreateAdresse(numero, libelle, ville, region)
                .orElseThrow(() -> new RuntimeException("Erreur lors de la création de l'adresse"));

        LieuTournageDAO lieuTournageDAO = (LieuTournageDAO) getDAO();

        Optional<LieuTournage> existingLieuTournage = lieuTournageDAO.findByVilleAndRegionAndAdresse(ville, region, adresse);
        if (existingLieuTournage.isPresent()) {
            return existingLieuTournage.get(); // Retourner le lieu de tournage existant si trouvé
        }

        LieuTournage lieuTournage = new LieuTournage();
        lieuTournage.setVille(ville);
        lieuTournage.setRegion(region);
        lieuTournage.setAdresse(adresse);

        return save(lieuTournage);
    }

}
