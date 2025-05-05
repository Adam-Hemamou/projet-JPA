package entities;

import jakarta.persistence.*;

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

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }

    public Acteur getActeur() { return acteur; }
    public void setActeur(Acteur acteur) { this.acteur = acteur; }
}
