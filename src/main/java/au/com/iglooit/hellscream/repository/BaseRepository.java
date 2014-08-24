package au.com.iglooit.hellscream.repository;

import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Repository
public abstract class BaseRepository<T extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public BaseRepository(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final Long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        Query q = entityManager.createQuery("select c from " + clazz.getName() + " c");
        return q.getResultList();

    }

    public void add(final T entity) {
        entityManager.persist(entity);
    }

    public void update(final T entity) {
        entityManager.merge(entity);
    }

    public void remove(final Long id) {
        T entity = findOne(id);
        entityManager.remove(entity);
    }

    public T findByKey(final Key key) {
        return findOne(key.getId());
    }

}
