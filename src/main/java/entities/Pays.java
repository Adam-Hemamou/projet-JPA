package entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * Représente un pays avec des détails tels que le nom, l'URL, avec les lieux de tournage, les lieux de naissance et les films associés.
 */
@Entity
@Table(name = "pays")
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String nom;

    @Lob
    private String url;

    @OneToMany(mappedBy = "pays")
    private List<Film> films;

    @OneToMany(mappedBy = "pays")
    private List<LieuTournage> lieuxTournage;

    @OneToMany(mappedBy = "pays")
    private List<LieuNaissance> lieuxNaissance;

    public Pays() {}

    /**
     * Constructeur pour la classe Pays avec le nom spécifié pour inseréer une valeur null si la liaison n'est pas indiquée.
     *
     * @param nom le nom du pays
     */
    public Pays(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'ID du pays.
     *
     * @return l'ID du pays
     */
    public Long getId() {
        return id;
    }

    /**
     * Retourne le nom du pays.
     *
     * @return le nom du pays
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du pays.
     *
     * @param nom le nom à définir
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'URL du pays.
     *
     * @return l'URL du pays
     */
    public String getUrl() {
        return url;
    }

    /**
     * Définit l'URL du pays.
     *
     * @param url l'URL à définir
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Retourne une représentation sous forme de chaîne de l'objet Pays.
     *
     * @return une représentation sous forme de chaîne du pays
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pays{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

