package utils.parser;

import entities.*;
import services.GenreService;
import services.LangueService;
import services.LieuTournageService;
import services.PaysService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe utilitaire pour analyser les données des films à partir d'un tableau de chaînes.
 */
public class FilmParser {

    private final PaysService paysService;
    private final GenreService genreService;
    private final LangueService langueService;
    private final LieuTournageParser lieuTournageParser;

    /**
     * Constructeur pour initialiser les services nécessaires.
     *
     * @param paysService le service pour gérer les opérations CRUD des pays
     * @param genreService le service pour gérer les opérations CRUD des genres
     * @param langueService le service pour gérer les opérations CRUD des langues
     * @param lieuTournageService le service pour gérer les lieux de tournage
     */
    public FilmParser(PaysService paysService, GenreService genreService, LangueService langueService, LieuTournageService lieuTournageService) {
        this.paysService = paysService;
        this.genreService = genreService;
        this.langueService = langueService;
        this.lieuTournageParser = new LieuTournageParser(lieuTournageService);
    }

    /**
     * Analyse un tableau de chaînes pour créer une instance de Film.
     *
     * @param record le tableau de chaînes contenant les données du film
     * @return une instance de Film créée à partir des données analysées
     */
    public Film parse(String[] record) {
        System.out.println("Ligne analysée : " + Arrays.toString(record));
        Film film = new Film();
        film.setId(getSafeValue(record, 0));
        film.setNom(getSafeValue(record, 1));

        String anneeSortieStr = getSafeValue(record, 2).replace("â€“", "-").replace("–", "-");
        film.setAnneeSortie(extractYear(anneeSortieStr));

        String ratingStr = getSafeValue(record, 3);
        film.setRating(ratingStr.isEmpty() ? 0.0 : Double.parseDouble(ratingStr.replace(",", ".")));

        film.setUrl(getSafeValue(record, 4));
        film.setResume(getSafeValue(record, 8));
        film.setLieuTournage(lieuTournageParser.parse(getSafeValue(record, 5)));
        film.setGenres(parseGenres(getSafeValue(record, 6)));

        String langueNom = getSafeValue(record, 7);
        if (!langueNom.isEmpty()) {
            Langue langue = langueService.findByNom(langueNom).orElseGet(() -> {
                Langue newLangue = new Langue();
                newLangue.setNom(langueNom);
                return langueService.save(newLangue);
            });
            film.setLangue(langue);
        } else {
            film.setLangue(null);
        }

        String paysNom = getSafeValue(record, 9);
        if (!paysNom.isEmpty()) {
            Pays pays = PaysParser.parse(paysNom);
            film.setPays(pays);
        } else {

            film.setPays(null);
        }

        return film;
    }

    private String getSafeValue(String[] record, int index) {
        return index < record.length && record[index] != null ? record[index].trim() : "";
    }

    private int extractYear(String yearRange) {
        String[] years = yearRange.split("-");
        return Integer.parseInt(years[0].trim());
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

//    private Pays parsePays(String nomPays) {
//        if (nomPays == null || nomPays.trim().isEmpty()) {
//            System.out.println("Pays vide ou invalide, retour du pays par défaut.");
//            Pays paysDefault = new Pays();
//            paysDefault.setNom("Inconnu");
//            return paysDefault;
//        }
//        return paysService.findByNom(nomPays).orElseGet(() -> {
//            Pays pays = new Pays();
//            pays.setNom(nomPays);
//            return paysService.save(pays);
//        });
//    }
}
