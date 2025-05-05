package entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Adresse {

    @Id
    private Long id;

    private int numero;

    @Lob
    private String libelle;

    @OneToMany(mappedBy = "adresse")
    private List<LieuTournage> lieuxTournage;

    public Adresse() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public List<LieuTournage> getLieuxTournage() { return lieuxTournage; }
    public void setLieuxTournage(List<LieuTournage> lieuxTournage) { this.lieuxTournage = lieuxTournage; }

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
