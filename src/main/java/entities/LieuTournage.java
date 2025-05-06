package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LieuTournage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;

    private String ville;

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @OneToMany(mappedBy = "lieuTournage")
    private List<Film> films;

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    public LieuTournage() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }

    public Pays getPays() { return pays; }
    public void setPays(Pays pays) { this.pays = pays; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LieuTournage{");
        sb.append("region='").append(region).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append(", adresse=").append(adresse);
        sb.append('}');
        return sb.toString();
    }
}


