package utils.dataReader;

import services.FilmService;
import services.ActeurService;
import entities.Film;
import entities.Acteur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || !line.contains(";")) {
                    System.err.println("Ligne mal formatée ou vide : " + line);
                    continue;  // Ignore les lignes vides ou mal formatées
                }
                String[] record = line.split(";");
                if (record.length != 2) {
                    System.err.println("Ligne mal formatée : " + line);
                    continue;  // Ignore les lignes qui ne contiennent pas exactement deux éléments
                }
                String filmId = record[0].trim();
                String acteurId = record[1].trim();

                Film film = filmService.findById(filmId).orElse(null);
                Acteur acteur = acteurService.findById(acteurId).orElse(null);

                if (film != null && acteur != null) {
                    // Vérifie si la liste des acteurs est null, sinon initialise-la
                    if (film.getActeurs() == null) {
                        film.setActeurs(new ArrayList<>());
                    }
                    film.getActeurs().add(acteur); // Ajoute l'acteur au film
                    filmService.save(film);  // Sauvegarde le film avec l'acteur ajouté
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

