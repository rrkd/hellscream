package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.UserStatistic;
import com.google.appengine.api.datastore.Key;

/**
 * Created by nicholaszhu on 21/02/2015.
 */
public interface UserStatisticDAO extends IEntityService<UserStatistic> {

    void createUserStatistic(UserStatistic userStatistic);

    UserStatistic findByEmail(String email);

    UserStatistic findByUserKey(Key userKey);
}
