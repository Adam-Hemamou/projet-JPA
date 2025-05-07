package AbstractClass;


import java.util.List;
import java.util.Optional;

/**
 * Classe abstraite générique pour les services CRUD.
 * Utilise un GenericDAO pour accéder aux opérations de base de données.
 *
 * @param <T> le type d'entité à gérer
 * @param <ID> le type de l'identifiant de l'entité
 */
public abstract class GenericService<T, ID> {

    private final GenericDAO<T, ID> dao;


    /**
     * Constructeur pour initialiser le DAO.
     *
     * @param dao le DAO à utiliser pour les opérations de base de données
     */
    protected GenericService(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }

    /**
     * Retourne le DAO utilisé par ce service.
     *
     * @return le DAO
     */
    protected GenericDAO<T, ID> getDAO() {
        return dao;
    }

    /**
     * Sauvegarde une entité via le DAO.
     *
     * @param entity l'entité à sauvegarder
     * @return l'entité sauvegardée
     */
    public T save(T entity) {
        return dao.save(entity);
    }

    /**
     * Trouve une entité par son identifiant via le DAO.
     *
     * @param id l'identifiant de l'entité à trouver
     * @return un Optional contenant l'entité trouvée ou vide si elle n'existe pas
     */
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(dao.findById(id));
    }

    /**
     * Retourne toutes les entités via le DAO.
     *
     * @return la liste de toutes les entités
     */
    public List<T> findAll() {
        return dao.findAll();
    }

    /**
     * Supprime une entité par son identifiant via le DAO.
     *
     * @param id l'identifiant de l'entité à supprimer
     */
    public void delete(ID id) {
        dao.delete(id);
    }
}
