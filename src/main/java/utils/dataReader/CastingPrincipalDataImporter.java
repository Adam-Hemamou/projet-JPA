package utils.dataReader;

import services.FilmService;
import services.ActeurService;
import entities.Film;
import entities.Acteur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe utilitaire pour importer les données de casting principal à partir d'un fichier CSV.
 */
public class CastingPrincipalDataImporter {

    private final FilmService filmService;
    private final ActeurService acteurService;

    /**
     * Constructeur pour initialiser les services nécessaires.
     *
     * @param filmService le service pour gérer les opérations CRUD des films
     * @param acteurService le service pour gérer les opérations CRUD des acteurs
     */
    public CastingPrincipalDataImporter(FilmService filmService, ActeurService acteurService) {
        this.filmService = filmService;
        this.acteurService = acteurService;
    }

    /**
     * Importe le casting principal à partir d'un fichier CSV.
     * Lit chaque ligne du fichier, vérifie les données et associe les acteurs aux films.
     *
     * @param filePath le chemin du fichier CSV à importer
     */
    public void importCastingPrincipalFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || !line.contains(";")) {
                    System.err.println("Ligne mal formatée ou vide : " + line);
                    continue;  
                }
                String[] record = line.split(";");
                if (record.length != 2) {
                    System.err.println("Ligne mal formatée : " + line);
                    continue;
                }
                String filmId = record[0].trim();
                String acteurId = record[1].trim();

                Film film = filmService.findById(filmId).orElse(null);
                Acteur acteur = acteurService.findById(acteurId).orElse(null);

                if (film != null && acteur != null) {
                    if (film.getActeurs() == null) {
                        film.setActeurs(new ArrayList<>());
                    }
                    film.getActeurs().add(acteur);
                    filmService.save(film);
                } else {
                    if (film == null) {
                        System.err.println("Film introuvable : " + filmId + " pour la ligne : " + line);
                    }
                    if (acteur == null) {
                        System.err.println("Acteur introuvable : " + acteurId + " pour la ligne : " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

