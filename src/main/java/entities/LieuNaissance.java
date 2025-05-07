package entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * Représente un lieu de naissance avec des détails tels que la commune, la ville, avec les pays, les réalisateurs et les acteurs associés.
 */
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

    /**
     * Retourne l'ID du lieu de naissance.
     *
     * @return l'ID du lieu de naissance
     */
    public Long getId() { return id; }

    /**
     * Définit l'ID du lieu de naissance.
     *
     * @param id l'ID à définir
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Retourne la commune du lieu de naissance.
     *
     * @return la commune du lieu de naissance
     */
    public String getCommune() {
        return commune;
    }

    /**
     * Définit la commune du lieu de naissance.
     *
     * @param commune la commune à définir
     */
    public void setCommune(String commune) {
        this.commune = commune;
    }

    /**
     * Retourne la ville du lieu de naissance.
     *
     * @return la ville du lieu de naissance
     */
    public String getVille() { return ville; }

    /**
     * Définit la ville du lieu de naissance.
     *
     * @param ville la ville à définir
     */
    public void setVille(String ville) { this.ville = ville; }

    /**
     * Retourne la région du lieu de naissance.
     *
     * @return la région du lieu de naissance
     */
    public String getRegion() { return region; }

    /**
     * Définit la région du lieu de naissance.
     *
     * @param region la région à définir
     */
    public void setRegion(String region) { this.region = region; }

    /**
     * Retourne le pays du lieu de naissance.
     *
     * @return le pays du lieu de naissance
     */
    public Pays getPays() {
        return pays;
    }

    /**
     * Définit le pays du lieu de naissance.
     *
     * @param pays le pays à définir
     */
    public void setPays(Pays pays) { this.pays = pays; }

    /**
     * Retourne une représentation sous forme de chaîne de l'objet LieuNaissance.
     *
     * @return une représentation sous forme de chaîne du lieu de naissance
     */
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
