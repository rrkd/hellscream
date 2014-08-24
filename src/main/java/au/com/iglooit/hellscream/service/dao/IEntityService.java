package au.com.iglooit.hellscream.service.dao;

import com.google.appengine.api.datastore.Key;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:53 AM
 */
public interface IEntityService<T extends Serializable> {
    T findByKey(Key key);
}
