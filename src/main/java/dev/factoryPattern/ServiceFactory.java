package dev.factoryPattern;

import services.*;

/**
 * Interface pour la création de services via un pattern Factory.
 * Cette interface définit les méthodes pour créer différents services utilisés dans l'application.
 */
public interface ServiceFactory {

    /**
     * Crée une instance de FilmService.
     *
     * @return une nouvelle instance de FilmService
     */
    FilmService createFilmService();

    /**
     * Crée une instance de ActeurService.
     *
     * @return une nouvelle instance de ActeurService
     */
    ActeurService createActeurService();

    /**
     * Crée une instance de RealisateurService.
     *
     * @return une nouvelle instance de RealisateurService
     */
    RealisateurService createRealisateurService();

    /**
     * Crée une instance de PaysService.
     *
     * @return une nouvelle instance de PaysService
     */
    PaysService createPaysService();

    /**
     * Crée une instance de RoleService.
     *
     * @return une nouvelle instance de RoleService
     */
    RoleService createRoleService();

    /**
     * Crée une instance de GenreService.
     *
     * @return une nouvelle instance de GenreService
     */
    GenreService createGenreService();

    /**
     * Crée une instance de LangueService.
     *
     * @return une nouvelle instance de LangueService
     */
    LangueService createLangueService();

    /**
     * Crée une instance de AdresseService.
     *
     * @return une nouvelle instance de AdresseService
     */
    AdresseService createAdresseService();

    /**
     * Crée une instance de LieuTournageService.
     *
     * @return une nouvelle instance de LieuTournageService
     */
    LieuTournageService createLieuTournageService();

    /**
     * Crée une instance de LieuNaissanceService.
     *
     * @return une nouvelle instance de LieuNaissanceService
     */
    LieuNaissanceService createLieuNaissanceService();
}
