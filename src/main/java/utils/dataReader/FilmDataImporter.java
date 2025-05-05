package utils.dataReader;


import services.FilmService;
import entities.Film;
import utils.parser.FilmParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilmDataImporter {

    private final FilmService filmService;
    private final FilmParser filmParser;

    public FilmDataImporter(FilmService filmService, FilmParser filmParser) {
        this.filmService = filmService;
        this.filmParser = filmParser;
    }

    public void importFilmsFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                Film film = filmParser.parse(record);
                if (filmService.findById(film.getId()).isEmpty()) {
                    filmService.save(film);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
