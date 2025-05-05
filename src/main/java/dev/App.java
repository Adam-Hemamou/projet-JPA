package dev;

import DAO.*;
import services.*;
import utils.dataReader.FilmDataImporter;
import utils.dataReader.ActeurDataImporter;
import utils.dataReader.RealisateurDataImporter;
import utils.dataReader.PaysDataImporter;
import utils.dataReader.RoleDataImporter;
import utils.dataReader.FilmRealisateurDataImporter;
import utils.dataReader.CastingPrincipalDataImporter;
import utils.parser.FilmParser;

public class App {

    public static void main(String[] args) {
        // Initialize services and DAOs
        FilmDAO filmDAO = new FilmDAO();
        ActeurDAO acteurDAO = new ActeurDAO();
        RealisateurDAO realisateurDAO = new RealisateurDAO();
        PaysDAO paysDAO = new PaysDAO();
        RoleDAO roleDAO = new RoleDAO();
        GenreDAO genreDAO = new GenreDAO();
        LangueDAO langueDAO = new LangueDAO();

        FilmService filmService = new FilmService(filmDAO);
        ActeurService acteurService = new ActeurService(acteurDAO);
        RealisateurService realisateurService = new RealisateurService(realisateurDAO);
        PaysService paysService = new PaysService(paysDAO);
        RoleService roleService = new RoleService(roleDAO);
        GenreService genreService = new GenreService(genreDAO);
        LangueService langueService = new LangueService(langueDAO);

        // Initialize data importers
        FilmParser filmParser = new FilmParser(paysService,  genreService, langueService);
        FilmDataImporter filmDataImporter = new FilmDataImporter(filmService, filmParser);
        ActeurDataImporter acteurDataImporter = new ActeurDataImporter(acteurService);
        RealisateurDataImporter realisateurDataImporter = new RealisateurDataImporter(realisateurService);
        PaysDataImporter paysDataImporter = new PaysDataImporter(paysService);
        RoleDataImporter roleDataImporter = new RoleDataImporter(roleService);
        FilmRealisateurDataImporter filmRealisateurDataImporter = new FilmRealisateurDataImporter(filmService, realisateurService);
        CastingPrincipalDataImporter castingPrincipalDataImporter = new CastingPrincipalDataImporter(filmService, acteurService);

        // Import data from CSV files
        filmDataImporter.importFilmsFromCSV("path/to/films.csv");
        acteurDataImporter.importActeursFromCSV("path/to/acteurs.csv");
        realisateurDataImporter.importRealisateursFromCSV("path/to/realisateurs.csv");
        paysDataImporter.importPaysFromCSV("path/to/pays.csv");
        roleDataImporter.importRolesFromCSV("path/to/roles.csv");
        filmRealisateurDataImporter.importFilmRealisateurFromCSV("path/to/film_realisateur.csv");
        castingPrincipalDataImporter.importCastingPrincipalFromCSV("path/to/casting_principal.csv");
    }
}
