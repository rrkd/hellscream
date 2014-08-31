package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.BaseEntity;
import com.google.appengine.api.datastore.Key;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:53 AM
 */
public interface IEntityService<T extends BaseEntity> {
    T findByKey(Key key);
    void removeAll();
    void removeEntity(T entity);
    List<T> findAll();
    void update(T entity);
}
