package au.com.iglooit.hellscream.controller.merchant;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.IGUser;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;
import au.com.iglooit.hellscream.security.GaeUserAuthentication;
import au.com.iglooit.hellscream.service.dao.CategoryGroupDAO;
import au.com.iglooit.hellscream.service.dao.MerchantDAO;
import au.com.iglooit.hellscream.service.dao.QuoteDAO;
import au.com.iglooit.hellscream.service.dao.QuoteTransactionDAO;
import au.com.iglooit.hellscream.service.quote.QuoteService;
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
 * Date: 29/08/2014
 * Time: 7:27 AM
 */
@Controller
public class MerchantProfileController {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantProfileController.class);

    @Resource
    private QuoteDAO quoteDAO;
    @Resource
    private QuoteTransactionDAO quoteTransactionDAO;
    @Resource
    private MerchantDAO merchantDAO;
    @Resource
    private QuoteService quoteService;
    @Resource
    private CategoryGroupDAO categoryGroupDAO;

    @RequestMapping(value = "/merchant/msg", method = RequestMethod.GET)
    public ModelAndView messageBoxPage() {
        Merchant merchant = getLoginMerchant();

        ModelAndView modelAndView = new ModelAndView("merchant/quoteMessage");
        SearchResultVO quoteTransactionList = quoteTransactionDAO.findQuoteTransactionByMerchant(merchant, 10);
        modelAndView.addObject("latestMsgList", quoteTransactionList);
        modelAndView.addObject("merchant", merchant);
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/p", method = RequestMethod.GET)
    public ModelAndView merchantProfile() {
        Merchant merchant = getLoginMerchant();

        ModelAndView modelAndView = new ModelAndView("merchant/merchantProfile");
        modelAndView.addObject("merchant", merchant);
        SearchResultVO<QuoteTransaction> quoteTransactionList = quoteTransactionDAO.findQuoteTransactionByMerchant(
                merchant, 10);
        modelAndView.addObject("latestMsgList", quoteTransactionList);
        return modelAndView;
    }

    @RequestMapping(value = "/m/q", method = RequestMethod.GET)
    public ModelAndView merchantQuoteListPage() {
        ModelAndView modelAndView = new ModelAndView("merchant/quoteList");
        Merchant merchant = getLoginMerchant();
        // find the quote by merchant

        modelAndView.addObject("merchant", merchant);
        modelAndView.addObject("latestQuote", quoteService.findQuoteTransactionByMerchant(merchant, 1));
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/modify", method = RequestMethod.GET)
    public ModelAndView updatePage() {
        ModelAndView modelAndView = new ModelAndView("merchant/updateMerchant");
        modelAndView.addObject("vo", getLoginMerchant());
        modelAndView.addObject("categoryGroupList", categoryGroupDAO.loadAll());
        return modelAndView;
    }

    @RequestMapping(value = "/merchant/payFeeCB", method = RequestMethod.GET)
    public ModelAndView payFeeCallback() {
        ModelAndView modelAndView = new ModelAndView("merchant/merchant-fee-paid");
        modelAndView.addObject("vo", getLoginMerchant());
        return modelAndView;
    }

    private Merchant getLoginMerchant() {
        GaeUserAuthentication auth = (GaeUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
        IGUser user = (IGUser) auth.getPrincipal();
        if (user == null) {
            LOG.error("You haven't login, please login firstly.");
            throw new AppX("User need to login ");
        }

        Merchant merchant = merchantDAO.findByKey(user.getMerchantKey());
        if (merchant == null) {
            LOG.error("You are not a user of Merchant.");
            throw new AppX("You are not a user of Merchant.");
        }
        return merchant;
    }

}
