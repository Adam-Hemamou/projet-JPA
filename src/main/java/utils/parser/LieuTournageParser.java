package utils.parser;

import entities.Adresse;
import entities.LieuTournage;
import entities.Pays;
import services.LieuTournageService;

/**
 * Classe utilitaire pour analyser les données des lieux de tournage à partir d'une chaîne.
 */
public class LieuTournageParser {

    private LieuTournageService lieuTournageService;

    /**
     * Constructeur pour initialiser le service nécessaire.
     *
     * @param lieuTournageService le service pour gérer les opérations CRUD des lieux de tournage
     */
    public LieuTournageParser(LieuTournageService lieuTournageService) {
        this.lieuTournageService = lieuTournageService;
    }

    /**
     * Analyse une chaîne pour créer une instance de LieuTournage.
     *
     * @param lieuTournageData la chaîne contenant les données du lieu de tournage
     * @return une instance de LieuTournage créée à partir des données analysées
     */
    public LieuTournage parse(String lieuTournageData) {
        System.out.println("LieuTournage brut : " + lieuTournageData);
        LieuTournage lieuTournage = new LieuTournage();
        String[] parts = lieuTournageData.split(",");

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
        }

        if (parts.length > 0) {
            Pays pays = PaysParser.parse(parts[0]);
            lieuTournage.setPays(pays);
        } else {
            lieuTournage.setPays(new Pays());
        }

        if (parts.length > 1) {
            lieuTournage.setRegion(parts[1]);
        } else {
            lieuTournage.setRegion("");
        }

        if (parts.length > 2) {
            lieuTournage.setVille(parts[2]);
        } else {
            lieuTournage.setVille("");
        }

        if (parts.length > 3) {
            Adresse adresse = parseAdresse(parts[3]);
            lieuTournage.setAdresse(adresse);
        } else {
            lieuTournage.setAdresse(new Adresse());
        }

        return lieuTournageService.createLieuTournage(lieuTournage.getVille(), lieuTournage.getRegion(), lieuTournage.getAdresse().getNumero(), lieuTournage.getAdresse().getLibelle());
    }

    private static Adresse parseAdresse(String adresseData) {
        System.out.println(adresseData);
        Adresse adresse = new Adresse();
        String[] adresseParts = adresseData.split("-");
        if (adresseParts.length > 0) {
            adresse.setLibelle(adresseParts[0].trim());
        } else {
            adresse.setLibelle("");
        }

        if (adresseParts.length > 1) {
            try {
                adresse.setNumero(Integer.parseInt(adresseParts[1].trim()));
            } catch (NumberFormatException e) {
                adresse.setNumero(0);
            }
        } else {
            adresse.setNumero(0);
        }
        return adresse;
    }
}
