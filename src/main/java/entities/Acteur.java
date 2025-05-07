package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


/**
 * Représente un acteur avec des détails tels que le nom, la date de naissance, la taille, l'url, avec les lieux de naissance et les films associés.
 */
@Entity
public class Acteur {
    @Id
    private String id;

    private String nom;

    private LocalDate dateNaissance;

    private double taille;

    @Lob
    private String url;

    @ManyToMany(mappedBy = "acteurs")
    private List<Film> films;

    @ManyToOne
    @JoinColumn(name = "lieu_naissance_id")
    private LieuNaissance lieuNaissance;

    public Acteur() {}

    /**
     * Retourne l'ID de l'acteur.
     *
     * @return l'ID de l'acteur
     */
    public String getId() { return id; }

    /**
     * Définit l'ID de l'acteur.
     *
     * @param id l'ID à définir
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retourne le nom de l'acteur.
     *
     * @return le nom de l'acteur
     */
    public String getNom() { return nom; }

    /**
     * Définit le nom de l'acteur.
     *
     * @param nom le nom à définir
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Retourne la date de naissance de l'acteur.
     *
     * @return la date de naissance de l'acteur
     */
    public LocalDate getDateNaissance() { return dateNaissance; }

    /**
     * Définit la date de naissance de l'acteur.
     *
     * @param dateNaissance la date de naissance à définir
     */
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    /**
     * Retourne la taille de l'acteur.
     *
     * @return la taille de l'acteur
     */
    public double getTaille() {
        return taille;
    }

    /**
     * Définit la taille de l'acteur.
     *
     * @param taille la taille à définir
     */
    public void setTaille(double taille) {
        this.taille = taille;
    }

    /**
     * Retourne l'URL de l'acteur.
     *
     * @return l'URL de l'acteur
     */
    public String getUrl() {
        return url;
    }

    /**
     * Définit l'URL de l'acteur.
     *
     * @param url l'URL à définir
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Retourne le lieu de naissance de l'acteur.
     *
     * @return le lieu de naissance de l'acteur
     */
    public LieuNaissance getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * Définit le lieu de naissance de l'acteur.
     *
     * @param lieuNaissance le lieu de naissance à définir
     */
    public void setLieuNaissance(LieuNaissance lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /**
     * Retourne une représentation sous forme de chaîne de l'objet Acteur.
     *
     * @return une représentation sous forme de chaîne de l'acteur
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Acteur{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", taille=").append(taille);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

