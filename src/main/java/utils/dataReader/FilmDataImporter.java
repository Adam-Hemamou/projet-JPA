package utils.dataReader;


import services.FilmService;
import entities.Film;
import utils.parser.FilmParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe utilitaire pour importer des données de films à partir d'un fichier CSV.
 */
public class FilmDataImporter {

    private final FilmService filmService;
    private final FilmParser filmParser;

    /**
     * Constructeur pour initialiser les services nécessaires.
     *
     * @param filmService le service pour gérer les opérations CRUD des films
     * @param filmParser le parser pour analyser les données des films
     */
    public FilmDataImporter(FilmService filmService, FilmParser filmParser) {
        this.filmService = filmService;
        this.filmParser = filmParser;
    }

    /**
     * Importe les films à partir d'un fichier CSV.
     * Lit chaque ligne du fichier, analyse les données et enregistre les films dans la base de données.
     *
     * @param filePath le chemin du fichier CSV à importer
     */
    public void importFilmsFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(";");
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
