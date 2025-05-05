package utils.parser;

import entities.Adresse;
import entities.LieuTournage;
import entities.Pays;
import services.PaysService;

public class LieuTournageParser {


    public static LieuTournage parse(String lieuTournageData) {
        LieuTournage lieuTournage = new LieuTournage();
        String[] parts = lieuTournageData.split(",");

        if (parts.length > 0) {
            Pays pays = PaysParser.parse(parts[0].trim());
            lieuTournage.setPays(pays);
        }
        if (parts.length > 1) {
            lieuTournage.setRegion(parts[1].trim());
        }
        if (parts.length > 2) {
            lieuTournage.setVille(parts[2].trim());
        }
        if (parts.length > 3) {
            Adresse adresse = parseAdresse(parts[3].trim());
            lieuTournage.setAdresse(adresse);
        }

        return lieuTournage;
    }

    private static Adresse parseAdresse(String adresseData) {
        Adresse adresse = new Adresse();
        String[] adresseParts = adresseData.split("-");
        if (adresseParts.length > 0) {
            adresse.setLibelle(adresseParts[0].trim());
        }
        if (adresseParts.length > 1) {
            adresse.setNumero(Integer.parseInt(adresseParts[1].trim()));
        }
        return adresse;
    }
}
