package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Représente un réalisateur avec des détails tels que le nom, la date de naissance, l'url, avec les lieux de naissance et les films associés.
 */
@Entity
public class Realisateur {
    @Id
    private String id;

    private String nom;

    private LocalDate dateNaissance;

    @Lob
    private String url;

    @ManyToOne
    @JoinColumn(name = "lieu_naissance_id")
    private LieuNaissance lieuNaissance;

    @ManyToMany(mappedBy = "realisateurs")
    private List<Film> films;

    public Realisateur() {}

    /**
     * Retourne l'ID du réalisateur.
     *
     * @return l'ID du réalisateur
     */
    public String getId() { return id; }

    /**
     * Définit l'ID du réalisateur.
     *
     * @param id l'ID à définir
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retourne le nom du réalisateur.
     *
     * @return le nom du réalisateur
     */
    public String getNom() { return nom; }

    /**
     * Définit le nom du réalisateur.
     *
     * @param nom le nom à définir
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Retourne la date de naissance du réalisateur.
     *
     * @return la date de naissance du réalisateur
     */
    public LocalDate getDateNaissance() { return dateNaissance; }

    /**
     * Définit la date de naissance du réalisateur.
     *
     * @param dateNaissance la date de naissance à définir
     */
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    /**
     * Retourne l'URL du réalisateur.
     *
     * @return l'URL du réalisateur
     */
    public String getUrl() { return url; }

    /**
     * Définit l'URL du réalisateur.
     *
     * @param url l'URL à définir
     */
    public void setUrl(String url) { this.url = url; }

    /**
     * Retourne le lieu de naissance du réalisateur.
     *
     * @return le lieu de naissance du réalisateur
     */
    public LieuNaissance getLieuNaissance() {
        return lieuNaissance;
    }

    /**
     * Définit le lieu de naissance du réalisateur.
     *
     * @param lieuNaissance le lieu de naissance à définir
     */
    public void setLieuNaissance(LieuNaissance lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    /**
     * Retourne une représentation sous forme de chaîne de l'objet Realisateur.
     *
     * @return une représentation sous forme de chaîne du réalisateur
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Realisateur{");
        sb.append("url='").append(url).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

