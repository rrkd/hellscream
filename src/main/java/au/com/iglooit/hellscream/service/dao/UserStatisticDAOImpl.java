package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.UserStatistic;
import au.com.iglooit.hellscream.repository.BaseRepository;
import com.google.appengine.api.datastore.Key;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by nicholaszhu on 21/02/2015.
 */
@Repository
@Transactional
public class UserStatisticDAOImpl extends BaseRepository<UserStatistic> implements UserStatisticDAO {
    public UserStatisticDAOImpl() {
        super(UserStatistic.class);
    }

    @Override
    public void createUserStatistic(UserStatistic userStatistic) {
        add(userStatistic);
    }

    @Override
    public UserStatistic findByEmail(String email) {
        Query q = getEntityManager().createQuery("select c from UserStatistic c where c.email=:email ")
            .setParameter("email", email);
        List<UserStatistic> result = q.getResultList();
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public UserStatistic findByUserKey(Key userKey) {
        Query q = getEntityManager().createQuery("select c from UserStatistic c where c.userKey=:userKey ")
            .setParameter("userKey", userKey);
        List<UserStatistic> result = q.getResultList();
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }


}
