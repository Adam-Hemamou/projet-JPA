package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Acteur {
    @Id
    private Long id;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }


    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

