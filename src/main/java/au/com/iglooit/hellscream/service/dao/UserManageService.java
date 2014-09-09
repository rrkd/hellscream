package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.IGUser;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 28/08/2014
 * Time: 8:41 AM
 */
public interface UserManageService extends IEntityService<IGUser> {
    void createUser(IGUser user);
    void createNormalUser(IGUser user);
    IGUser findByEmail(String email);
    void modifyUser(IGUser IGUser);
    IGUser findByUserId(String userId);
}
