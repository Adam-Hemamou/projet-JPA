package utils.parser;

import entities.Acteur;
import entities.LieuNaissance;
import services.ActeurService;
import services.LieuNaissanceService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Classe utilitaire pour analyser les données des acteurs à partir d'un tableau de chaînes.
 */
public class ActeurParser {

    private final ActeurService acteurService;
    private final LieuNaissanceService lieuNaissanceService;

    /**
     * Constructeur pour initialiser les services nécessaires.
     *
     * @param acteurService le service pour gérer les opérations CRUD des acteurs
     * @param lieuNaissanceService le service pour gérer les lieux de naissance
     */
    public ActeurParser(ActeurService acteurService, LieuNaissanceService lieuNaissanceService) {
        this.acteurService = acteurService;
        this.lieuNaissanceService = lieuNaissanceService;
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);

    /**
     * Analyse un tableau de chaînes pour créer une instance d'Acteur.
     *
     * @param record le tableau de chaînes contenant les données de l'acteur
     * @return une instance d'Acteur créée à partir des données analysées
     */
    public Acteur parse(String[] record) {
        Acteur acteur = new Acteur();
        acteur.setId(getSafeValue(record, 0));
        acteur.setNom(getSafeValue(record, 1));

        String dateNaissanceStr = getSafeValue(record, 2);
        if (!dateNaissanceStr.isEmpty()) {
            try {
                acteur.setDateNaissance(LocalDate.parse(dateNaissanceStr.trim(), DATE_FORMATTER));
            } catch (Exception e) {
                acteur.setDateNaissance(null);
            }
        } else {
            acteur.setDateNaissance(null);
        }

        LieuNaissance lieuNaissance = new LieuNaissanceParser(lieuNaissanceService).parse(getSafeValue(record, 3));
        acteur.setLieuNaissance(lieuNaissance);
        String taille = getSafeValue(record, 4);
        if (!taille.isEmpty()) {
            try {
                acteur.setTaille(extractNumericValue(taille));
            } catch (NumberFormatException e) {
                acteur.setTaille(0.0);
            }
        } else {
            acteur.setTaille(0.0);
        }
        acteur.setUrl(getSafeValue(record, 5));
        return acteur;
    }

    private static String getSafeValue(String[] record, int index) {
        return index < record.length && record[index] != null ? record[index].trim() : "";
    }

    private static double extractNumericValue(String value) {
        String numericValue = value.replaceAll("[^0-9.]", "");
        return Double.parseDouble(numericValue);
    }

}
