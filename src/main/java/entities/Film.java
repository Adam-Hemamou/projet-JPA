package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un film avec des détails tels que le titre, l'année de sortie, la note, l'url, le resumé, avec les pays, les langues, les genres, les lieux de tournage, les relisateurs et les acteurs associés.
 */
@Entity
public class Film {
    @Id
    private String id;

    private String nom;

    private Integer annee;

    private double rating;

    @Lob
    private String url;

    @Lob
    @Column(length = 2000)
    private String resume;

    @ManyToMany
    @JoinTable(
            name = "film_realisateur",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "realisateur_id")
    )
    private List<Realisateur> realisateurs = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "casting_principal",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id")
    )
    private List<Acteur> acteurs = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "lieu_tournage_id")
    private LieuTournage lieuTournage;

    @ManyToOne
    @JoinColumn(name = "langue_id")
    private Langue langue;

    @ManyToOne
    @JoinColumn(name = "pays_id", nullable = true)
    private Pays pays;

    public Film() {}

    /**
     * Retourne l'ID du film.
     *
     * @return l'ID du film
     */
    public String getId() { return id; }

    /**
     * Définit l'ID du film.
     *
     * @param id l'ID à définir
     */
    public void setId(String id) { this.id = id; }

    /**
     * Retourne le nom du film.
     *
     * @return le nom du film
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du film.
     *
     * @param nom le nom à définir
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne l'année de sortie du film.
     *
     * @return l'année de sortie du film
     */
    public Integer getAnneeSortie() { return annee; }

    /**
     * Définit l'année de sortie du film.
     *
     * @param annee l'année de sortie à définir
     */
    public void setAnneeSortie(Integer annee) { this.annee = annee; }

    /**
     * Retourne la note du film.
     *
     * @return la note du film
     */
    public double getRating() {
        return rating;
    }

    /**
     * Définit la note du film.
     *
     * @param rating la note à définir
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Retourne l'URL du film.
     *
     * @return l'URL du film
     */
    public String getUrl() {
        return url;
    }

    /**
     * Définit l'URL du film.
     *
     * @param url l'URL à définir
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Retourne le résumé du film.
     *
     * @return le résumé du film
     */
    public String getResume() {
        return resume;
    }

    /**
     * Définit le résumé du film.
     *
     * @param resume le résumé à définir
     */
    public void setResume(String resume) {
        this.resume = resume;
    }

    /**
     * Retourne le lieu de tournage du film.
     *
     * @return le lieu de tournage du film
     */
    public LieuTournage getLieuTournage() {
        return lieuTournage;
    }

    /**
     * Définit le lieu de tournage du film.
     *
     * @param lieuTournage le lieu de tournage à définir
     */
    public void setLieuTournage(LieuTournage lieuTournage) {
        this.lieuTournage = lieuTournage;
    }

    /**
     * Retourne la liste des réalisateurs du film.
     *
     * @return la liste des réalisateurs
     */
    public List<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    /**
     * Définit la liste des réalisateurs du film.
     *
     * @param realisateurs la liste des réalisateurs à définir
     */
    public void setRealisateurs(List<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    /**
     * Retourne la liste des acteurs du film.
     *
     * @return la liste des acteurs
     */
    public List<Acteur> getActeurs() {
        return acteurs;
    }

    /**
     * Définit la liste des acteurs du film.
     *
     * @param acteurs la liste des acteurs à définir
     */
    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    /**
     * Retourne la liste des genres du film.
     *
     * @return la liste des genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * Définit la liste des genres du film.
     *
     * @param genres la liste des genres à définir
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * Retourne la langue du film.
     *
     * @return la langue du film
     */
    public Langue getLangue() {
        return langue;
    }

    /**
     * Définit la langue du film.
     *
     * @param langue la langue à définir
     */
    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    /**
     * Retourne le pays du film.
     *
     * @return le pays du film
     */
    public Pays getPays() {
        return pays;
    }

    /**
     * Définit le pays du film.
     *
     * @param pays le pays à définir
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    /**
     * Retourne une représentation sous forme de chaîne de l'objet Film.
     *
     * @return une représentation sous forme de chaîne du film
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("resume='").append(resume).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", rating=").append(rating);
        sb.append(", annee=").append(annee);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

