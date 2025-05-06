package AbstractClass;

import jakarta.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDAO<T, ID> {

    protected EntityManager entityManager;
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
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
