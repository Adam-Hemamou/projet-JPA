package DAO;

import AbstractClass.GenericDAO;
import entities.Adresse;
import entities.LieuTournage;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class LieuTournageDAO extends GenericDAO<LieuTournage, Long> {

    public LieuTournageDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Optional<LieuTournage> findByVilleAndRegionAndAdresse(String ville, String region, Adresse adresse) {
        return entityManager.createQuery(
                        "SELECT l FROM LieuTournage l WHERE l.ville = :ville AND l.region = :region AND l.adresse = :adresse",
                        LieuTournage.class)
                .setParameter("ville", ville)
                .setParameter("region", region)
                .setParameter("adresse", adresse)
                .getResultStream()
                .findFirst();
    }

}
