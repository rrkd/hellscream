package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.repository.BaseRepository;
import au.com.iglooit.hellscream.security.AppRole;
import org.apache.commons.lang.StringUtils;
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
    private static final Integer PAGE_COUNT = 10;
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

    @Override
    public SearchResultVO<IGUser> findUserByPrefix(String keyword, Integer pageNumber) {
        assert StringUtils.isNotBlank(keyword);
        Integer startPage = pageNumber == null ? 1 : pageNumber;
        Query q = getEntityManager().createQuery("select c from IGUser c " +
                "where c.nickname>=:key1 and c.nickname<:key2 ")
                .setParameter("key1", keyword)
                .setParameter("key2", keyword + "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ")
                .setMaxResults(PAGE_COUNT)
                .setFirstResult((startPage - 1) * PAGE_COUNT);
        Query countQuery = getEntityManager().createQuery("select count(c) from IGUser c " +
                "where c.nickname>=:key1 and c.nickname<:key2 ")
                .setParameter("key1", keyword)
                .setParameter("key2", keyword + "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");

        SearchResultVO<IGUser> resultVO = new SearchResultVO<IGUser>();
        for (IGUser user : (List<IGUser>) q.getResultList()) {
            resultVO.getVoList().add(user);
        }
        resultVO.setPageNum(startPage);
        resultVO.setTotal(((Long)countQuery.getSingleResult()).intValue() / PAGE_COUNT + 1);
        return resultVO;
    }

    @Override
    public SearchResultVO<IGUser> findUserByPrefix(Integer page) {
        Integer startPage = page == null ? 1 : page;
        Query q = getEntityManager().createQuery("select c from IGUser c " +
                "where c.nickname>=:key1 and c.nickname<:key2 ")
                .setMaxResults(PAGE_COUNT)
                .setFirstResult((startPage - 1) * PAGE_COUNT);
        Query countQuery = getEntityManager().createQuery("select count(c) from IGUser c " +
                "where c.nickname>=:key1 and c.nickname<:key2 ");

        SearchResultVO<IGUser> resultVO = new SearchResultVO<IGUser>();
        for (IGUser user : (List<IGUser>) q.getResultList()) {
            resultVO.getVoList().add(user);
        }
        resultVO.setPageNum(startPage);
        resultVO.setTotal(((Long)countQuery.getSingleResult()).intValue() / PAGE_COUNT + 1);
        return resultVO;
    }

    @Override
    public Boolean validUser(String email, String password) {
        Query q = getEntityManager().createQuery("select c from IGUser c " +
                "where c.email=:email and c.password=:password ")
                .setParameter("email",email)
                .setParameter("password", password);
        if(q.getResultList().size() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public IGUser signUpAsNewDefaultUser(IGUser user) {
        user.setNickname(user.getEmail());
        user.setAuthorities(EnumSet.of(AppRole.USER));
        add(user);
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
