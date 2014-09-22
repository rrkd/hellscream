package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.repository.BaseRepository;
import au.com.iglooit.hellscream.security.AppRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 28/08/2014
 * Time: 8:42 AM
 */
@Repository
@Transactional
public class UserDAOImpl extends BaseRepository<IGUser> implements UserDAO {
    private static final Logger LOG = LoggerFactory.getLogger(UserDAOImpl.class);

    public UserDAOImpl() {
        super(IGUser.class);
    }

    @Override
    public void createNormalUser(IGUser user) {
        Set<AppRole> roles = EnumSet.of(AppRole.USER);
        user.setEnabled(true);
        user.setAuthorities(roles);
        add(user);
    }

    @Override
    public void createUser(IGUser user) {
        user.setEnabled(true);
        add(user);
    }

    @Override
    public IGUser findByEmail(String email) {
        Query q = getEntityManager().createQuery("select c from IGUser c where c.email=:email ")
                .setParameter("email", email);
        List<IGUser> result = q.getResultList();
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public void modifyUser(IGUser user) {
        update(user);
    }

    @Override
    public IGUser findByUserId(String userId) {
        Query q = getEntityManager().createQuery("select c from IGUser c where c.userId=:userId ")
                .setParameter("userId", userId);
        List<IGUser> result = q.getResultList();
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }
}
