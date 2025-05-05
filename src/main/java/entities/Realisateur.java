package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }


    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

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

