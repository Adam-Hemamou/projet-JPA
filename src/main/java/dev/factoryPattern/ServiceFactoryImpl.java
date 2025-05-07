package dev.factoryPattern;

import DAO.*;
import jakarta.persistence.EntityManager;
import services.*;
import utils.parser.*;

/**
 * Implémentation de l'interface ServiceFactory pour la création de services.
 * Utilise un EntityManager pour initialiser les DAO nécessaires.
 */
public class ServiceFactoryImpl implements ServiceFactory {

    private final EntityManager entityManager;

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public ServiceFactoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public FilmService createFilmService() {
        FilmDAO filmDAO = new FilmDAO(entityManager);
        return new FilmService(filmDAO);
    }

    @Override
    public ActeurService createActeurService() {
        ActeurDAO acteurDAO = new ActeurDAO(entityManager);
        return new ActeurService(acteurDAO);
    }

    @Override
    public RealisateurService createRealisateurService() {
        RealisateurDAO realisateurDAO = new RealisateurDAO(entityManager);
        return new RealisateurService(realisateurDAO);
    }

    @Override
    public PaysService createPaysService() {
        PaysDAO paysDAO = new PaysDAO(entityManager);
        return new PaysService(paysDAO);
    }

    @Override
    public RoleService createRoleService() {
        RoleDAO roleDAO = new RoleDAO(entityManager);
        return new RoleService(roleDAO);
    }

    @Override
    public GenreService createGenreService() {
        GenreDAO genreDAO = new GenreDAO(entityManager);
        return new GenreService(genreDAO);
    }

    @Override
    public LangueService createLangueService() {
        LangueDAO langueDAO = new LangueDAO(entityManager);
        return new LangueService(langueDAO);
    }

    @Override
    public AdresseService createAdresseService() {
        AdresseDAO adresseDAO = new AdresseDAO(entityManager);
        return new AdresseService(adresseDAO);
    }

    @Override
    public LieuTournageService createLieuTournageService() {
        LieuTournageDAO lieuTournageDAO = new LieuTournageDAO(entityManager);
        AdresseService adresseService = createAdresseService();
        return new LieuTournageService(lieuTournageDAO, adresseService);
    }

    @Override
    public LieuNaissanceService createLieuNaissanceService() {
        LieuNaissanceDAO lieuNaissanceDAO = new LieuNaissanceDAO(entityManager);
        return new LieuNaissanceService(lieuNaissanceDAO);
    }
}
