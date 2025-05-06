package utils.parser;

import entities.Pays;
import services.PaysService;

public class PaysParser {

    private static PaysService paysService;

    public PaysParser(PaysService paysService) {
        PaysParser.paysService = paysService;
    }

    public static void setPaysService(PaysService paysService) {
        PaysParser.paysService = paysService;
    }

    public static Pays parse(String nom) {
        System.out.println("Ligne analysée : " + nom);

        if (nom == null || nom.trim().isEmpty()) {
            // Si le nom est vide ou null, on retourne un pays par défaut sans l'enregistrer
            Pays paysDefault = new Pays();
            paysDefault.setNom(null);
            return paysDefault;
        }
        // Si le nom est valide, on cherche le pays dans la base de données
        return paysService.findByNom(nom.trim()).orElseGet(() -> {
            Pays pays = new Pays();
            pays.setNom(nom.trim());
            return paysService.save(pays); // On enregistre si nécessaire
        });
    }

    public static Pays parseFromCSV(String[] record) {
        String nom = getSafeValue(record, 0);
        String url = getSafeValue(record, 1);
        Pays pays = new Pays();
        pays.setNom(nom.trim());
        pays.setUrl(url.trim());
        return pays;
    }

    private static String getSafeValue(String[] record, int index) {
        return index < record.length && record[index] != null ? record[index].trim() : "";
    }
}