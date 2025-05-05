package utils;

import entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVParserUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM d yyyy");

    public static Film parseFilm(String[] record) {
        Film film = new Film();
        film.setId(record[0].trim()); // ID IMDB
        film.setNom(record[1].trim());
        film.setAnneeSortie(Integer.parseInt(record[2].trim()));
        film.setRating(Double.parseDouble(record[3].trim()));
        film.setUrl(record[4].trim());

        // Parse LieuTournage
        film.setLieuTournage(parseLieuTournage(record[5].trim()));

        // Parse Genres
        film.setGenres(parseGenres(record[6].trim()));

        // Parse Langue
        Langue langue = new Langue();
        langue.setNom(record[7].trim());
        film.setLangue(langue);

        // Parse Resume and Pays
        film.setResume(record[8].trim());
        Pays pays = new Pays();
        pays.setNom(record[9].trim());
        film.setPays(pays);

        return film;
    }

    public static LieuTournage parseLieuTournage(String lieuTournageData) {
        LieuTournage lieuTournage = new LieuTournage();
        String[] parts = lieuTournageData.split(",");
        if (parts.length > 0) {
            lieuTournage.setRegion(parts[0].trim());
        }
        if (parts.length > 1) {
            lieuTournage.setVille(parts[1].trim());
        }
        // Add logic to parse and set Adresse and Pays if needed
        return lieuTournage;
    }

    public static List<Genre> parseGenres(String genresData) {
        return Arrays.stream(genresData.split(","))
                .map(String::trim)
                .map(genreName -> {
                    Genre genre = new Genre();
                    genre.setNom(genreName);
                    return genre;
                })
                .collect(Collectors.toList());
    }

    public static Acteur parseActeur(String[] record) {
        Acteur acteur = new Acteur();
        acteur.setId(record[0].trim());
        acteur.setNom(record[1].trim());
        acteur.setDateNaissance(LocalDate.parse(record[2].trim(), DATE_FORMATTER));
        acteur.setLieuNaissance(parseLieuNaissance(record[3].trim()));
        acteur.setTaille(Double.parseDouble(record[4].trim()));
        acteur.setUrl(record[5].trim());
        return acteur;
    }

    public static LieuNaissance parseLieuNaissance(String lieuNaissanceData) {
        LieuNaissance lieuNaissance = new LieuNaissance();
        String[] parts = lieuNaissanceData.split(",");
        if (parts.length > 0) {
            lieuNaissance.setVille(parts[0].trim());
        }
        if (parts.length > 1) {
            lieuNaissance.setRegion(parts[1].trim());
        }
        // Add logic to parse and set Pays if needed
        return lieuNaissance;
    }

    public static Realisateur parseRealisateur(String[] record) {
        Realisateur realisateur = new Realisateur();
        realisateur.setId(record[0].trim()); // ID IMDB
        realisateur.setNom(record[1].trim());
        realisateur.setDateNaissance(LocalDate.parse(record[2].trim(), DATE_FORMATTER));
        realisateur.setLieuNaissance(parseLieuNaissance(record[3].trim()));
        realisateur.setUrl(record[4].trim());
        return realisateur;
    }

    public static Pays parsePays(String[] record) {
        Pays pays = new Pays();
        pays.setNom(record[0].trim());
        pays.setUrl(record[1].trim());
        return pays;
    }

    public static Role parseRole(String[] record) {
        Role role = new Role();
        Film film = new Film();
        film.setId(record[0].trim());
        role.setFilm(film);

        Acteur acteur = new Acteur();
        acteur.setId(record[1].trim());
        role.setActeur(acteur);

        role.setNom(record[2].trim());
        return role;
    }

}
