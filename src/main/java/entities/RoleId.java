package entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class RoleId implements Serializable {
    private Long film;
    private Long acteur;

    public RoleId() {}

    public RoleId(Long film, Long acteur) {
        this.film = film;
        this.acteur = acteur;
    }

    public Long getFilmId() { return film; }
    public void setFilmId(Long film) { this.film = film; }

    public Long getActeurId() { return acteur; }
    public void setActeurId(Long acteur) { this.acteur = acteur; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleId)) return false;
        RoleId that = (RoleId) o;
        return Objects.equals(film, that.film) &&
                Objects.equals(acteur, that.acteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, acteur);
    }
}
