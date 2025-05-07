package entities;
import jakarta.persistence.*;
import java.util.List;

/**
 * Représente une adresse avec des détails tels que le numéro et le libellé.
 */
@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    @Lob
    private String libelle;

    @OneToMany(mappedBy = "adresse")
    private List<LieuTournage> lieuxTournage;


    public Adresse() {}

    /**
     * Retourne l'ID de l'adresse.
     *
     * @return l'ID de l'adresse
     */
    public Long getId() { return id; }

    /**
     * Définit l'ID de l'adresse.
     *
     * @param id l'ID à définir
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Retourne le numéro de l'adresse.
     *
     * @return le numéro de l'adresse
     */
    public int getNumero() { return numero; }

    /**
     * Définit le numéro de l'adresse.
     *
     * @param numero le numéro à définir
     */
    public void setNumero(int numero) { this.numero = numero; }

    /**
     * Retourne le libellé de l'adresse.
     *
     * @return le libellé de l'adresse
     */
    public String getLibelle() { return libelle; }

    /**
     * Définit le libellé de l'adresse.
     *
     * @param libelle le libellé à définir
     */
    public void setLibelle(String libelle) { this.libelle = libelle; }

    /**
     * Retourne une représentation sous forme de chaîne de l'objet Adresse.
     *
     * @return une représentation sous forme de chaîne de l'adresse
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append("numero=").append(numero);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", lieuxTournage=").append(lieuxTournage);
        sb.append('}');
        return sb.toString();
    }
}
