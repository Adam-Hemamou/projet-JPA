package dev;

import DAO.*;
import dev.factoryPattern.ServiceFactory;
import dev.factoryPattern.ServiceFactoryImpl;
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

        // Utiliser la factory pour créer les services
        ServiceFactory serviceFactory = new ServiceFactoryImpl(em);

        FilmService filmService = serviceFactory.createFilmService();
        ActeurService acteurService = serviceFactory.createActeurService();
        RealisateurService realisateurService = serviceFactory.createRealisateurService();
        PaysService paysService = serviceFactory.createPaysService();
        RoleService roleService = serviceFactory.createRoleService();
        GenreService genreService = serviceFactory.createGenreService();
        LangueService langueService = serviceFactory.createLangueService();
        LieuTournageService lieuTournageService = serviceFactory.createLieuTournageService();
        LieuNaissanceService lieuNaissanceService = serviceFactory.createLieuNaissanceService();

        // Initialiser les data importers
        FilmParser filmParser = new FilmParser(paysService, genreService, langueService, lieuTournageService);
        FilmDataImporter filmDataImporter = new FilmDataImporter(filmService, filmParser);
        ActeurDataImporter acteurDataImporter = new ActeurDataImporter(acteurService, lieuNaissanceService);
        RealisateurDataImporter realisateurDataImporter = new RealisateurDataImporter(realisateurService, lieuNaissanceService);
        PaysDataImporter paysDataImporter = new PaysDataImporter(paysService);
        RoleDataImporter roleDataImporter = new RoleDataImporter(roleService);
        FilmRealisateurDataImporter filmRealisateurDataImporter = new FilmRealisateurDataImporter(filmService, realisateurService);
        CastingPrincipalDataImporter castingPrincipalDataImporter = new CastingPrincipalDataImporter(filmService, acteurService);

        // Importer les données à partir des fichiers CSV en utilsant les data importers
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

    /**
     * Obtient le chemin du fichier à partir des ressources.
     *
     * @param resourceName le nom de la ressource
     * @return le chemin du fichier
     * @throws IllegalArgumentException si le fichier est introuvable
     */
    private static String getFilePath(String resourceName) {
        URL resource = ClassLoader.getSystemClassLoader().getResource(resourceName);
        if (resource == null) {
            throw new IllegalArgumentException("Fichier introuvable : " + resourceName);
        }
        return resource.getFile();
    }
}
