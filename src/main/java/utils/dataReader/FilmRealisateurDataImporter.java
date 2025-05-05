package utils.dataReader;

import services.FilmService;
import services.RealisateurService;
import entities.Film;
import entities.Realisateur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilmRealisateurDataImporter {

    private final FilmService filmService;
    private final RealisateurService realisateurService;

    public FilmRealisateurDataImporter(FilmService filmService, RealisateurService realisateurService) {
        this.filmService = filmService;
        this.realisateurService = realisateurService;
    }

    public void importFilmRealisateurFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                String filmId = record[0].trim();
                String realisateurId = record[1].trim();

                Film film = filmService.findById(filmId).orElse(null);
                Realisateur realisateur = realisateurService.findById(realisateurId).orElse(null);

                if (film != null && realisateur != null) {
                    film.getRealisateurs().add(realisateur);
                    filmService.save(film);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
