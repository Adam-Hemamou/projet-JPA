package dev;

import DAO.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import services.*;
import utils.dataReader.FilmDataImporter;
import utils.dataReader.ActeurDataImporter;
import utils.dataReader.RealisateurDataImporter;
import utils.dataReader.PaysDataImporter;
import utils.dataReader.RoleDataImporter;
import utils.dataReader.FilmRealisateurDataImporter;
import utils.dataReader.CastingPrincipalDataImporter;
import utils.parser.FilmParser;
import utils.parser.PaysParser;

import java.net.URL;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imdb-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        // Initialize services and DAOs
        FilmDAO filmDAO = new FilmDAO(em);
        ActeurDAO acteurDAO = new ActeurDAO(em);
        RealisateurDAO realisateurDAO = new RealisateurDAO(em);
        PaysDAO paysDAO = new PaysDAO(em);
        RoleDAO roleDAO = new RoleDAO(em);
        GenreDAO genreDAO = new GenreDAO(em);
        LangueDAO langueDAO = new LangueDAO(em);
        LieuTournageDAO lieuTournageDAO = new LieuTournageDAO(em);
        AdresseDAO addressDAO = new AdresseDAO(em);
        LieuNaissanceDAO lieuNaissanceDAO = new LieuNaissanceDAO(em);



        FilmService filmService = new FilmService(filmDAO);
        ActeurService acteurService = new ActeurService(acteurDAO);
        RealisateurService realisateurService = new RealisateurService(realisateurDAO);
        PaysService paysService = new PaysService(paysDAO);
        RoleService roleService = new RoleService(roleDAO);
        GenreService genreService = new GenreService(genreDAO);
        LangueService langueService = new LangueService(langueDAO);
        AdresseService adresseService = new AdresseService(addressDAO);
        LieuTournageService lieuTournageService = new LieuTournageService(lieuTournageDAO, adresseService);
        LieuNaissanceService lieuNaissanceService = new LieuNaissanceService(lieuNaissanceDAO);

        // Initialize data importers
        FilmParser filmParser = new FilmParser(paysService, genreService, langueService, lieuTournageService);
        FilmDataImporter filmDataImporter = new FilmDataImporter(filmService, filmParser);
        ActeurDataImporter acteurDataImporter = new ActeurDataImporter(acteurService, lieuNaissanceService);
        RealisateurDataImporter realisateurDataImporter = new RealisateurDataImporter(realisateurService, lieuNaissanceService);
        PaysDataImporter paysDataImporter = new PaysDataImporter(paysService);
        RoleDataImporter roleDataImporter = new RoleDataImporter(roleService);
        FilmRealisateurDataImporter filmRealisateurDataImporter = new FilmRealisateurDataImporter(filmService, realisateurService);
        CastingPrincipalDataImporter castingPrincipalDataImporter = new CastingPrincipalDataImporter(filmService, acteurService);

        // Import data from CSV files
        PaysParser.setPaysService(paysService);
        try {
            transaction.begin();
            paysDataImporter.importPaysFromCSV(getFilePath("csv/pays.csv"));
            filmDataImporter.importFilmsFromCSV(getFilePath("csv/films.csv"));
            acteurDataImporter.importActeursFromCSV(getFilePath("csv/acteurs.csv"));
            castingPrincipalDataImporter.importCastingPrincipalFromCSV(getFilePath("csv/castingPrincipal.csv"));
            roleDataImporter.importRolesFromCSV(getFilePath("csv/roles.csv"));
            realisateurDataImporter.importRealisateursFromCSV(getFilePath("csv/realisateurs.csv"));
            filmRealisateurDataImporter.importFilmRealisateurFromCSV(getFilePath("csv/film_realisateurs.csv"));

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private static String getFilePath(String resourceName) {
        URL resource = ClassLoader.getSystemClassLoader().getResource(resourceName);
        if (resource == null) {
            throw new IllegalArgumentException("Fichier introuvable : " + resourceName);
        }
        return resource.getFile();
    }
}
