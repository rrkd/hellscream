package au.com.iglooit.hellscream.controller.merchant;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import au.com.iglooit.hellscream.service.dao.QuoteManageService;
import au.com.iglooit.hellscream.service.dao.QuoteTransactionManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 29/08/2014
 * Time: 7:27 AM
 */
@Controller
public class MerchantProfileController {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantProfileController.class);

    @Resource
    private QuoteManageService quoteManageService;

    @Resource
    private QuoteTransactionManageService quoteTransactionManageService;

    @Resource
    private MerchantManageService merchantManageService;

    @RequestMapping(value = "/merchant/msg", method = RequestMethod.GET)
    public ModelAndView messageBoxPage() {
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser)auth.getPrincipal();
        if( user == null) {
            LOG.error("You haven't login, please login firstly.");
            throw new AppX("User need to login ");
        }

        Merchant merchant = merchantManageService.findByKey(user.getMerchantKey());
        if( merchant == null) {
            LOG.error("You are not a user of Merchant.");
            throw new AppX("You are not a user of Merchant.");
        }

        ModelAndView modelAndView = new ModelAndView("merchant/quoteMessage");
        List<QuoteTransaction> quoteTransactionList = quoteTransactionManageService.findQuoteTransactionByMerchant(merchant, 10);
        modelAndView.addObject("latestMsgList", quoteTransactionList);
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/p", method = RequestMethod.GET)
    public ModelAndView merchantProfile() {
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser)auth.getPrincipal();
        if( user == null) {
            LOG.error("You haven't login, please login firstly.");
            throw new AppX("User need to login ");
        }

        Merchant merchant = merchantManageService.findByKey(user.getMerchantKey());
        if( merchant == null) {
            LOG.error("You are not a user of Merchant.");
            throw new AppX("You are not a user of Merchant.");
        }

        ModelAndView modelAndView = new ModelAndView("m/merchantProfile");
        List<QuoteTransaction> quoteTransactionList = quoteTransactionManageService.findQuoteTransactionByMerchant(merchant, 10);
        modelAndView.addObject("latestMsgList", quoteTransactionList);
        return modelAndView;
    }
}
