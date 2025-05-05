package utils.dataReader;

import services.FilmService;
import services.ActeurService;
import entities.Film;
import entities.Acteur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CastingPrincipalDataImporter {

    private final FilmService filmService;
    private final ActeurService acteurService;

    public CastingPrincipalDataImporter(FilmService filmService, ActeurService acteurService) {
        this.filmService = filmService;
        this.acteurService = acteurService;
    }

    public void importCastingPrincipalFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                String filmId = record[0].trim();
                String acteurId = record[1].trim();

                Film film = filmService.findById(filmId).orElse(null);
                Acteur acteur = acteurService.findById(acteurId).orElse(null);

                if (film != null && acteur != null) {
                    film.getActeurs().add(acteur);
                    filmService.save(film);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

