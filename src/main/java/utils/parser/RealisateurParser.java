package utils.parser;

import entities.LieuNaissance;
import entities.Realisateur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RealisateurParser {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM d yyyy");

    public static Realisateur parse(String[] record) {
        Realisateur realisateur = new Realisateur();
        realisateur.setId(record[0].trim()); // ID IMDB
        realisateur.setNom(record[1].trim());
        realisateur.setDateNaissance(LocalDate.parse(record[2].trim(), DATE_FORMATTER));
        realisateur.setLieuNaissance(LieuNaissanceParser.parse(record[3].trim()));
        realisateur.setUrl(record[4].trim());
        return realisateur;
    }
}
