package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pays")
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Pays(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pays{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
