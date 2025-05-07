package DAO;

import AbstractClass.GenericDAO;
import entities.Adresse;
import entities.LieuTournage;
import jakarta.persistence.EntityManager;

import java.util.Optional;

/**
 * Classe DAO pour les opérations CRUD sur les entités LieuTournage.
 */
public class LieuTournageDAO extends GenericDAO<LieuTournage, Long> {

    /**
     * Constructeur pour initialiser l'EntityManager.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    public LieuTournageDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Trouve un lieu de tournage par sa ville, sa région et son adresse.
     *
     * @param ville la ville du lieu de tournage
     * @param region la région du lieu de tournage
     * @param adresse l'adresse du lieu de tournage
     * @return un Optional contenant le lieu de tournage trouvé ou vide si elle n'existe pas
     */
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
