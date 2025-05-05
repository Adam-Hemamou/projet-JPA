package utils.parser;

import entities.LieuNaissance;
import entities.Pays;
import services.PaysService;

public class LieuNaissanceParser {

    public static LieuNaissance parse(String lieuNaissanceData) {
        LieuNaissance lieuNaissance = new LieuNaissance();
        String[] parts = lieuNaissanceData.split(",");
        if (parts.length > 0) {
            lieuNaissance.setVille(parts[0].trim());
        }
        if (parts.length > 1) {
            lieuNaissance.setRegion(parts[1].trim());
        }
        if (parts.length > 2) {
            Pays pays = PaysParser.parse(parts[2].trim());
            lieuNaissance.setPays(pays);
        }
        return lieuNaissance;
    }
}

