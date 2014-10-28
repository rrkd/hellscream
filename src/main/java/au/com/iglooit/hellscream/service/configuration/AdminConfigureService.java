package au.com.iglooit.hellscream.service.configuration;

import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.properties.WebProperties;
import au.com.iglooit.hellscream.security.AppRole;
import au.com.iglooit.hellscream.service.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.EnumSet;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 3/10/2014
 * Time: 2:09 PM
 */
@Component
public class AdminConfigureService {
    private static final Logger LOG = LoggerFactory.getLogger(AdminConfigureService.class);
    private static final String ADMIN_EMAIL = "develop.iglooit@gmail.com";
    @Resource
    private UserDAO userDAO;

    @PostConstruct
    public void init() throws Exception {
        WebProperties webProperties = WebProperties.getInstance();
        Boolean initData = Boolean.valueOf(webProperties.get("init.admin.data"));
        if (initData) {
            LOG.info("init admin user - create default admin user.");
            initAdminConfig();
        }

    }

    private void initAdminConfig() {
        IGUser user = userDAO.findByEmail(ADMIN_EMAIL);
        if (user == null) {
            // create a new admin user
            IGUser adminUser = new IGUser();
            adminUser.setEmail(ADMIN_EMAIL);
            adminUser.setNickname("Admin");
            adminUser.setForename("Admin");
            adminUser.setAuthorities(EnumSet.of(AppRole.ADMIN));
            adminUser.setEnabled(true);
            userDAO.createUser(adminUser);
        }
    }
}
