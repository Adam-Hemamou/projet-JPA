package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LieuNaissance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commune;

    private String ville;

    private String region;

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @OneToMany(mappedBy = "lieuNaissance")
    private List<Acteur> acteurs;

    @OneToMany(mappedBy = "lieuNaissance")
    private List<Realisateur> realisateurs;

    public LieuNaissance() {}

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LieuNaissance{");
        sb.append("region='").append(region).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append(", commune='").append(commune).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
