package AbstractClass;

import jakarta.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Classe abstraite générique pour les opérations de base de données CRUD.
 * Utilise un EntityManager pour interagir avec la base de données.
 *
 * @param <T> le type d'entité à gérer
 * @param <ID> le type de l'identifiant de l'entité
 */
public abstract class GenericDAO<T, ID> {

    protected EntityManager entityManager;
    private final Class<T> type;

    /**
     * Constructeur pour initialiser l'EntityManager et déterminer le type d'entité.
     *
     * Utilise la réflexion pour obtenir le type générique réel de la classe
     * à partir de la superclasse générique. Cela permet de déterminer le type
     * d'entité spécifique (T) à gérer par cette instance de DAO.
     *
     * @param entityManager l'EntityManager à utiliser pour les opérations de base de données
     */
    @SuppressWarnings("unchecked")
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Sauvegarde une entité dans la base de données.
     *
     * @param entity l'entité à sauvegarder
     * @return l'entité sauvegardée
     */
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    /**
     * Trouve une entité par son identifiant.
     *
     * @param id l'identifiant de l'entité à trouver
     * @return l'entité trouvée ou null si elle n'existe pas
     */
    public T findById(ID id) {
        return entityManager.find(type, id);
    }

    /**
     * Retourne toutes les entités de ce type.
     *
     * @return la liste de toutes les entités
     */
    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + type.getSimpleName() + " e", type).getResultList();
    }

    /**
     * Supprime une entité par son identifiant.
     *
     * @param id l'identifiant de l'entité à supprimer
     */
    public void delete(ID id) {
        T entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
