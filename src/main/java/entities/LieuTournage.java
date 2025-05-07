package entities;

import jakarta.persistence.*;

import java.util.List;

/**
 * Représente un lieu de tournage avec des détails tels que la région, la ville, avec les films, les adresses et les pays asssociés.
 */
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

    /**
     * Retourne l'ID du lieu de tournage.
     *
     * @return l'ID du lieu de tournage
     */
    public Long getId() { return id; }

    /**
     * Définit l'ID du lieu de tournage.
     *
     * @param id l'ID à définir
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Retourne la région du lieu de tournage.
     *
     * @return la région du lieu de tournage
     */
    public String getRegion() { return region; }

    /**
     * Définit la région du lieu de tournage.
     *
     * @param region la région à définir
     */
    public void setRegion(String region) { this.region = region; }

    /**
     * Retourne la ville du lieu de tournage.
     *
     * @return la ville du lieu de tournage
     */
    public String getVille() { return ville; }

    /**
     * Définit la ville du lieu de tournage.
     *
     * @param ville la ville à définir
     */
    public void setVille(String ville) { this.ville = ville; }

    /**
     * Retourne l'adresse du lieu de tournage.
     *
     * @return l'adresse du lieu de tournage
     */
    public Adresse getAdresse() { return adresse; }

    /**
     * Définit l'adresse du lieu de tournage.
     *
     * @param adresse l'adresse à définir
     */
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }

    /**
     * Retourne le pays du lieu de tournage.
     *
     * @return le pays du lieu de tournage
     */
    public Pays getPays() { return pays; }

    /**
     * Définit le pays du lieu de tournage.
     *
     * @param pays le pays à définir
     */
    public void setPays(Pays pays) { this.pays = pays; }

    /**
     * Retourne une représentation sous forme de chaîne de l'objet LieuTournage.
     *
     * @return une représentation sous forme de chaîne du lieu de tournage
     */
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


