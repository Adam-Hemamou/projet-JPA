package entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

/**
 * Représente l'identifiant composite pour la classe Role.
 */
@Embeddable
public class RoleId implements Serializable {
    private String film;
    private String acteur;

    public RoleId() {}

    /**
     * Constructeur pour la classe RoleId avec les IDs spécifiés.
     *
     * @param film l'ID du film
     * @param acteur l'ID de l'acteur
     */
    public RoleId(String film, String acteur) {
        this.film = film;
        this.acteur = acteur;
    }

    /**
     * Vérifie l'égalité entre deux objets RoleId.
     *
     * @param o l'objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleId)) return false;
        RoleId that = (RoleId) o;
        return Objects.equals(film, that.film) &&
                Objects.equals(acteur, that.acteur);
    }

}
