package utils.parser;

import entities.Adresse;
import entities.LieuTournage;
import entities.Pays;
import services.LieuTournageService;
import services.PaysService;

public class LieuTournageParser {

    private LieuTournageService lieuTournageService;

    public LieuTournageParser(LieuTournageService lieuTournageService) {
        this.lieuTournageService = lieuTournageService;
    }

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
            lieuTournage.setPays(new Pays()); // Valeur par défaut si vide
        }

        if (parts.length > 1) {
            lieuTournage.setRegion(parts[1]);
        } else {
            lieuTournage.setRegion(""); // Valeur par défaut si vide
        }

        if (parts.length > 2) {
            lieuTournage.setVille(parts[2]);
        } else {
            lieuTournage.setVille(""); // Valeur par défaut si vide
        }

        if (parts.length > 3) {
            Adresse adresse = parseAdresse(parts[3]);
            lieuTournage.setAdresse(adresse);
        } else {
            lieuTournage.setAdresse(new Adresse()); // Valeur par défaut si vide
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
            adresse.setLibelle(""); // Valeur par défaut si vide
        }

        if (adresseParts.length > 1) {
            try {
                adresse.setNumero(Integer.parseInt(adresseParts[1].trim()));
            } catch (NumberFormatException e) {
                adresse.setNumero(0); // Valeur par défaut si le numéro est invalide
            }
        } else {
            adresse.setNumero(0); // Valeur par défaut si vide
        }
        return adresse;
    }
}
