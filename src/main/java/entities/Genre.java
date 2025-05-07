package entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * Représente un genre de film avec des détails tels que le nom et les films associés.
 */
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "genres")
    private List<Film> films;

    public Genre() {}

    /**
     * Retourne l'ID du genre.
     *
     * @return l'ID du genre
     */
    public Long getId() { return id; }

    /**
     * Définit l'ID du genre.
     *
     * @param id l'ID à définir
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Retourne le nom du genre.
     *
     * @return le nom du genre
     */
    public String getNom() { return nom; }

    /**
     * Définit le nom du genre.
     *
     * @param nom le nom à définir
     */
    public void setNom(String nom) { this.nom = nom; }

}
