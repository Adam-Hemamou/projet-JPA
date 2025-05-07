package entities;

import jakarta.persistence.*;

/**
 * Représente un rôle attribué à un acteur dans un film, avec le nom de son rôle.
 */
@Entity
@IdClass(RoleId.class)
public class Role {

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @Id
    @ManyToOne
    @JoinColumn(name = "acteur_id")
    private Acteur acteur;

    private String nom;

    public Role() {}

    /**
     * Retourne le nom du rôle.
     *
     * @return le nom du rôle
     */
    public String getNom() { return nom; }

    /**
     * Définit le nom du rôle.
     *
     * @param nom le nom à définir
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Retourne le film associé au rôle.
     *
     * @return le film associé
     */
    public Film getFilm() { return film; }

    /**
     * Définit le film associé au rôle.
     *
     * @param film le film à définir
     */
    public void setFilm(Film film) { this.film = film; }

    /**
     * Retourne l'acteur associé au rôle.
     *
     * @return l'acteur associé
     */
    public Acteur getActeur() { return acteur; }

    /**
     * Définit l'acteur associé au rôle.
     *
     * @param acteur l'acteur à définir
     */
    public void setActeur(Acteur acteur) { this.acteur = acteur; }
}
