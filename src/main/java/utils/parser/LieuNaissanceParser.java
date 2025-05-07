package utils.parser;

import entities.LieuNaissance;
import entities.Pays;
import services.LieuNaissanceService;

/**
 * Classe utilitaire pour analyser les données des lieux de naissance à partir d'une chaîne.
 */
public class LieuNaissanceParser {

    private final LieuNaissanceService lieuNaissanceService;

    /**
     * Constructeur pour initialiser le service nécessaire.
     *
     * @param lieuNaissanceService le service pour gérer les opérations CRUD des lieux de naissance
     */
    public LieuNaissanceParser(LieuNaissanceService lieuNaissanceService) {
        this.lieuNaissanceService = lieuNaissanceService;
    }

    /**
     * Analyse une chaîne pour créer une instance de LieuNaissance.
     *
     * @param lieuNaissanceData la chaîne contenant les données du lieu de naissance
     * @return une instance de LieuNaissance créée à partir des données analysées
     */
    public LieuNaissance parse(String lieuNaissanceData) {
        LieuNaissance lieuNaissance = new LieuNaissance();
        String[] parts = lieuNaissanceData.split(",");

        if (parts.length > 0) {
            lieuNaissance.setVille(parts[0].trim());
        } else {
            lieuNaissance.setVille("");
        }

        if (parts.length > 1) {
            lieuNaissance.setRegion(parts[1].trim());
        } else {
            lieuNaissance.setRegion("");
        }

        if (parts.length > 2 && !parts[2].trim().isEmpty()) {
            Pays pays = PaysParser.parse(parts[2].trim());
            lieuNaissance.setPays(pays);
        } else {
            lieuNaissance.setPays(null);
        }

        return lieuNaissanceService.save(lieuNaissance);
    }
}

