package utils.parser;

import entities.Pays;
import services.PaysService;

/**
 * Classe utilitaire pour analyser les données des pays à partir d'une chaîne.
 */
public class PaysParser {

    private static PaysService paysService;

    /**
     * Constructeur pour initialiser le service nécessaire.
     *
     * @param paysService le service pour gérer les opérations CRUD des pays
     */
    public PaysParser(PaysService paysService) {
        PaysParser.paysService = paysService;
    }

    /**
     * Définit le service pour gérer les opérations CRUD des pays.
     *
     * @param paysService le service pour gérer les opérations CRUD des pays
     */
    public static void setPaysService(PaysService paysService) {
        PaysParser.paysService = paysService;
    }

    /**
     * Analyse une chaîne pour créer une instance de Pays.
     *
     * @param nom le nom du pays
     * @return une instance de Pays créée à partir des données analysées
     */
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

    /**
     * Analyse un tableau de chaînes pour créer une instance de Pays.
     *
     * @param record le tableau de chaînes contenant les données du pays
     * @return une instance de Pays créée à partir des données analysées
     */
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