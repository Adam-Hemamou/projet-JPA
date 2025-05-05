package entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "langue")
    private List<Film> films;

    public Langue() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Langue{");
        sb.append("nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
