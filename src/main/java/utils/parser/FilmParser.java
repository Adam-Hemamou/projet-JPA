package utils.parser;

import entities.*;
import services.GenreService;
import services.LangueService;
import services.PaysService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilmParser {

    private final PaysService paysService;
    private final GenreService genreService;
    private final LangueService langueService;

    public FilmParser(PaysService paysService, GenreService genreService, LangueService langueService) {
        this.paysService = paysService;
        this.genreService = genreService;
        this.langueService = langueService;
    }

    public Film parse(String[] record) {
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
        Langue langue = langueService.findByNom(record[7].trim()).orElseGet(() -> {
            Langue newLangue = new Langue();
            newLangue.setNom(record[7].trim());
            return langueService.save(newLangue);
        });
        film.setLangue(langue);

        // Parse Pays
        Pays pays = parsePays(record[9].trim());
        film.setPays(pays);

        return film;
    }

    private List<Genre> parseGenres(String genresData) {
        return Arrays.stream(genresData.split(","))
                .map(String::trim)
                .map(genreName -> genreService.findByNom(genreName).orElseGet(() -> {
                    Genre genre = new Genre();
                    genre.setNom(genreName);
                    return genreService.save(genre);
                }))
                .collect(Collectors.toList());
    }

    private Pays parsePays(String nomPays) {
        return paysService.findByNom(nomPays).orElseGet(() -> {
            Pays pays = new Pays();
            pays.setNom(nomPays);
            return paysService.save(pays);
        });
    }
}
