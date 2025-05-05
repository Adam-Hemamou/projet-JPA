package utils.parser;

import entities.Acteur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ActeurParser {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM d yyyy");

    public static Acteur parse(String[] record) {
        Acteur acteur = new Acteur();
        acteur.setId(record[0].trim());
        acteur.setNom(record[1].trim());
        acteur.setDateNaissance(LocalDate.parse(record[2].trim(), DATE_FORMATTER));
        acteur.setLieuNaissance(LieuNaissanceParser.parse(record[3].trim()));
        acteur.setTaille(Double.parseDouble(record[4].trim()));
        acteur.setUrl(record[5].trim());
        return acteur;
    }
}
