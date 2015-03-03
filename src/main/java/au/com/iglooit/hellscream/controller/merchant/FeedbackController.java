package au.com.iglooit.hellscream.controller.merchant;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import com.google.appengine.api.datastore.KeyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/09/2014
 * Time: 11:26 AM
 */
@Controller
public class FeedbackController {
    private static final Logger LOG = LoggerFactory.getLogger(FeedbackController.class);

    @Resource
    private MerchantDAO merchantDAO;

    @RequestMapping(value = "/fd/m/{keyString}", method = RequestMethod.GET)
    public ModelAndView messageBoxPage(@PathVariable String keyString) {
        ModelAndView modelAndView = new ModelAndView("feedback/merchantFeedback");
        modelAndView.addObject("merchant", merchantDAO.findByKey(KeyFactory.stringToKey(keyString)));
        modelAndView.addObject("user", currentUser());
        return modelAndView;
    }

    private IGUser currentUser() {
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser) auth.getPrincipal();
        if (user == null) {
            LOG.error("You haven't login, please login firstly.");
            return null;
        }
        if(user.getIsUser() && !user.getIsMerchant()) {
            return user;
        }else {
            return null;
        }
    }
}
