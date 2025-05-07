package entities;
import jakarta.persistence.*;

import java.util.List;

/**
 * Représente une langue avec des détails tels que le nom et les films associés.
 */
@Entity
public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "langue")
    private List<Film> films;

    public Langue() {}

    /**
     * Retourne l'ID de la langue.
     *
     * @return l'ID de la langue
     */
    public Long getId() { return id; }

    /**
     * Définit l'ID de la langue.
     *
     * @param id l'ID à définir
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Retourne le nom de la langue.
     *
     * @return le nom de la langue
     */
    public String getNom() { return nom; }

    /**
     * Définit le nom de la langue.
     *
     * @param nom le nom à définir
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Retourne une représentation sous forme de chaîne de l'objet Langue.
     *
     * @return une représentation sous forme de chaîne de la langue
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Langue{");
        sb.append("nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
