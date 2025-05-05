package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAO<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public GenericDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T findById(ID id) {
        return entityManager.find(type, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + type.getSimpleName() + " e", type).getResultList();
    }

    public void delete(ID id) {
        T entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
