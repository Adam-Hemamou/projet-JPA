package AbstractClass;


import java.util.List;
import java.util.Optional;

public abstract class GenericService<T, ID> {

    private final GenericDAO<T, ID> dao;

    protected GenericService(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }

    public T save(T entity) {
        return dao.save(entity);
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(dao.findById(id));
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public void delete(ID id) {
        dao.delete(id);
    }
}
