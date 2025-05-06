package utils.parser;

import entities.LieuNaissance;
import entities.Realisateur;
import services.ActeurService;
import services.LieuNaissanceService;
import services.RealisateurService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class RealisateurParser {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
    private final LieuNaissanceService lieuNaissanceService;

    public RealisateurParser( LieuNaissanceService lieuNaissanceService) {
        this.lieuNaissanceService = lieuNaissanceService;
    }


    public Realisateur parse(String[] record) {
        Realisateur realisateur = new Realisateur();
        String id = getSafeValue(record, 0);
        if (id.isEmpty()) {
            throw new IllegalArgumentException("ID du réalisateur manquant !");
        }
        realisateur.setId(id);
        realisateur.setNom(getSafeValue(record, 1));

        String dateNaissanceStr = getSafeValue(record, 2);
        if (!dateNaissanceStr.isEmpty()) {
            try {
                realisateur.setDateNaissance(parseDateSafely(dateNaissanceStr));
            } catch (DateTimeParseException e) {
                System.err.println("Date invalide pour le réalisateur : " + dateNaissanceStr);
                realisateur.setDateNaissance(null);
            }
        }

        LieuNaissanceParser lieuNaissanceParser = new LieuNaissanceParser(lieuNaissanceService);
        LieuNaissance lieuNaissance = lieuNaissanceParser.parse(getSafeValue(record, 3));
        realisateur.setLieuNaissance(lieuNaissance);        realisateur.setUrl(getSafeValue(record, 4));
        return realisateur;
    }

    private static String getSafeValue(String[] record, int index) {
        return index < record.length && record[index] != null ? record[index].trim() : "";
    }

    private static LocalDate parseDateSafely(String dateStr) {
        dateStr = dateStr.trim();
        try {
            // Cas 1 : uniquement une année
            if (dateStr.matches("\\d{4}")) {
                return LocalDate.of(Integer.parseInt(dateStr), 1, 1); // Jan 1 de cette année
            }

            // Cas 2 : mois + jour (on complète avec année par défaut)
            if (dateStr.matches("[A-Za-z]+\\s\\d{1,2}")) {
                dateStr += " 1900"; // année par défaut
            }

            // Cas 3 : format complet (mois jour année)
            DateTimeFormatter[] formatters = new DateTimeFormatter[] {
                    DateTimeFormatter.ofPattern("MMM d yyyy", Locale.ENGLISH),
                    DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH)
            };

            for (DateTimeFormatter formatter : formatters) {
                try {
                    return LocalDate.parse(dateStr, formatter);
                } catch (DateTimeParseException ignored) {}
            }
        } catch (Exception e) {
            // ignore
        }

        throw new DateTimeParseException("Format de date non reconnu", dateStr, 0);
    }

}
