package utils.parser;

import entities.Film;
import entities.Genre;
import entities.Langue;
import entities.Pays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilmParser {

    public static Film parse(String[] record) {
        Film film = new Film();
        film.setId(record[0].trim()); // ID IMDB
        film.setNom(record[1].trim());
        film.setAnneeSortie(Integer.parseInt(record[2].trim()));
        film.setRating(Double.parseDouble(record[3].trim()));
        film.setUrl(record[4].trim());
        film.setResume(record[8].trim());

        // Parse LieuTournage
        film.setLieuTournage(LieuTournageParser.parse(record[5].trim()));

        // Parse Genres
        film.setGenres(parseGenres(record[6].trim()));

        // Parse Langue
        Langue langue = new Langue();
        langue.setNom(record[7].trim());
        film.setLangue(langue);

        // Parse Pays
        Pays pays = PaysParser.parse(record[9].trim());
        film.setPays(pays);

        return film;
    }

    private static List<Genre> parseGenres(String genresData) {
        return Arrays.stream(genresData.split(","))
                .map(String::trim)
                .map(genreName -> {
                    Genre genre = new Genre();
                    genre.setNom(genreName);
                    return genre;
                })
                .collect(Collectors.toList());
    }
}
