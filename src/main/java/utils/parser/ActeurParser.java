package utils.parser;

import entities.Acteur;
import entities.LieuNaissance;
import services.ActeurService;
import services.LieuNaissanceService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ActeurParser {

    private final ActeurService acteurService;
    private final LieuNaissanceService lieuNaissanceService;

    public ActeurParser(ActeurService acteurService, LieuNaissanceService lieuNaissanceService) {
        this.acteurService = acteurService;
        this.lieuNaissanceService = lieuNaissanceService;
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);

    public Acteur parse(String[] record) {
        Acteur acteur = new Acteur();
        acteur.setId(getSafeValue(record, 0));
        acteur.setNom(getSafeValue(record, 1));

        String dateNaissanceStr = getSafeValue(record, 2);
        if (!dateNaissanceStr.isEmpty()) {
            try {
                acteur.setDateNaissance(LocalDate.parse(dateNaissanceStr.trim(), DATE_FORMATTER));
            } catch (Exception e) {
                acteur.setDateNaissance(null);  // Si la date est mal formatée, on l'assigne à null
            }
        } else {
            acteur.setDateNaissance(null);  // Si la date est vide, on l'assigne à null
        }

        LieuNaissance lieuNaissance = new LieuNaissanceParser(lieuNaissanceService).parse(getSafeValue(record, 3));
        acteur.setLieuNaissance(lieuNaissance);
        String taille = getSafeValue(record, 4);
        if (!taille.isEmpty()) {
            try {
                acteur.setTaille(extractNumericValue(taille));
            } catch (NumberFormatException e) {
                acteur.setTaille(0.0);  // Valeur par défaut si la taille est mal formatée
            }
        } else {
            acteur.setTaille(0.0);  // Valeur par défaut si la taille est manquante
        }
        acteur.setUrl(getSafeValue(record, 5));
        return acteur;
    }

    private static String getSafeValue(String[] record, int index) {
        return index < record.length && record[index] != null ? record[index].trim() : "";
    }

    private static double extractNumericValue(String value) {
        // Retirer tout ce qui n'est pas un chiffre ou un point (comme " m")
        String numericValue = value.replaceAll("[^0-9.]", "");
        return Double.parseDouble(numericValue); // Convertir en double
    }

}
