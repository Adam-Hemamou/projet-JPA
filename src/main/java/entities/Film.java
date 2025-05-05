package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Film {
    @Id
    private Long id;

    private String nom;

    private Integer annee;

    private double rating;

    @Lob
    private String url;

    @Lob
    private String resume;

    @ManyToMany
    @JoinTable(
            name = "film_realisateur",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "realisateur_id")
    )
    private List<Realisateur> realisateurs;

    @ManyToMany
    @JoinTable(
            name = "casting_principal",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id")
    )
    private List<Acteur> acteurs;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return nom; }
    public void setTitre(String nom) { this.nom = nom; }

    public Integer getAnneeSortie() { return annee; }
    public void setAnneeSortie(Integer annee) { this.annee = annee; }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

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

