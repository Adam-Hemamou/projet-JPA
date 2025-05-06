package utils.parser;

import entities.LieuNaissance;
import entities.Pays;
import services.LieuNaissanceService;
import services.PaysService;

public class LieuNaissanceParser {

    private final LieuNaissanceService lieuNaissanceService;

    public LieuNaissanceParser(LieuNaissanceService lieuNaissanceService) {
        this.lieuNaissanceService = lieuNaissanceService;
    }

    public LieuNaissance parse(String lieuNaissanceData) {
        LieuNaissance lieuNaissance = new LieuNaissance();
        String[] parts = lieuNaissanceData.split(",");

        if (parts.length > 0) {
            lieuNaissance.setVille(parts[0].trim());
        } else {
            lieuNaissance.setVille(""); // Valeur par défaut si vide
        }

        if (parts.length > 1) {
            lieuNaissance.setRegion(parts[1].trim());
        } else {
            lieuNaissance.setRegion(""); // Valeur par défaut si vide
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

