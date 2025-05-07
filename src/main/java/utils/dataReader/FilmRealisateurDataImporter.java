package utils.dataReader;

import services.FilmService;
import services.RealisateurService;
import entities.Film;
import entities.Realisateur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe utilitaire pour importer les données des réalisateurs de films à partir d'un fichier CSV.
 */
public class FilmRealisateurDataImporter {

    private final FilmService filmService;
    private final RealisateurService realisateurService;

    /**
     * Constructeur pour initialiser les services nécessaires.
     *
     * @param filmService le service pour gérer les opérations CRUD des films
     * @param realisateurService le service pour gérer les opérations CRUD des réalisateurs
     */
    public FilmRealisateurDataImporter(FilmService filmService, RealisateurService realisateurService) {
        this.filmService = filmService;
        this.realisateurService = realisateurService;
    }

    /**
     * Importe les réalisateurs de films à partir d'un fichier CSV.
     * Lit chaque ligne du fichier, vérifie les données et associe les réalisateurs aux films.
     *
     * @param filePath le chemin du fichier CSV à importer
     */
    public void importFilmRealisateurFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(";");
                String filmId = record[0].trim();
                String realisateurId = record[1].trim();

                Film film = filmService.findById(filmId).orElse(null);
                Realisateur realisateur = realisateurService.findById(realisateurId).orElse(null);

                if (film != null && realisateur != null) {
                    if (film.getRealisateurs() == null) {
                        film.setRealisateurs(new ArrayList<>());
                    }
                    film.getRealisateurs().add(realisateur);
                    filmService.save(film);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
