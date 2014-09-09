package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.entity.Quote;
import au.com.iglooit.hellscream.model.entity.QuoteStatus;
import au.com.iglooit.hellscream.model.entity.QuoteTransaction;
import au.com.iglooit.hellscream.model.entity.QuoteTransactionStatus;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.QuoteTransactionVO;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import au.com.iglooit.hellscream.service.dao.QuoteManageService;
import au.com.iglooit.hellscream.service.dao.QuoteTransactionManageService;
import au.com.iglooit.hellscream.service.mail.EMailService;
import au.com.iglooit.hellscream.service.quote.QuoteHelper;
import au.com.iglooit.hellscream.utils.DateUtils;
import com.google.appengine.api.datastore.KeyFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 2/09/2014
 * Time: 9:18 PM
 */
@Controller
public class QuoteManageWS {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteManageWS.class);
    @Resource
    private QuoteManageService quoteManageService;
    @Resource
    private QuoteTransactionManageService quoteTransactionManageService;
    @Resource
    private MerchantManageService merchantManageService;
    @Resource
    private EMailService eMailService;

    @RequestMapping(value = "/ws/quote",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse postQuote(@RequestBody Quote quote) {
        // update post date
        quote.setPostDate(DateUtils.getNow());
        quote.setStatus(QuoteStatus.Quoting);
        quoteManageService.createQuote(quote);
        LOG.info("create quote " + quote.getTitle());
        return new JsonResponse("OK", "");
    }

    @RequestMapping(value = "/ws/quoteTransaction/{quoteKey}",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addQuoteTransaction(@PathVariable String quoteKey,
                                     @RequestBody QuoteTransactionVO quoteTransactionVO) {
        if (StringUtils.isBlank(quoteKey)) {
            return new JsonResponse("Error", "Quote Miss");
        }
        if (quoteTransactionVO == null) {
            return new JsonResponse("Error", "Quote Transaction Miss");
        }
        QuoteTransaction quoteTransaction = new QuoteTransaction();
        quoteTransaction.convertFromVO(quoteTransactionVO);

        Merchant merchant = merchantManageService.findByKey(KeyFactory.stringToKey(
                quoteTransactionVO.getMerchantKeyString()));
        if (merchant == null) {
            return new JsonResponse("Error", "Merchant doesn't exist");
        }
        quoteTransaction.setMerchant(merchant);

        Quote quote = quoteManageService.loadQuote(KeyFactory.stringToKey(quoteKey));
        quote.setUpdateDate(DateUtils.getNow());
        quote.getQuoteTransactions().add(quoteTransaction);
        quoteManageService.update(quote);
        LOG.info("[nick] update quote");
        return new JsonResponse("OK", "");
    }

    @RequestMapping(value = "/ws/quoteTransaction/a/{transactionKeyString}",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse approveQuoteTransaction(@PathVariable String transactionKeyString) {
        // change quote transaction
        QuoteTransaction quoteTransaction =
                quoteTransactionManageService.findByKey(KeyFactory.stringToKey(transactionKeyString));
        if (quoteTransaction == null) {
            LOG.error("quote transaction not exist");
            return new JsonResponse("Error", "quote transaction not exist");
        }
        quoteTransaction.setQuoteTransactionStatus(QuoteTransactionStatus.Contacting);
        quoteTransactionManageService.update(quoteTransaction);
        // send email

        eMailService.sendUserContactEmail(QuoteHelper.generateUserContactEmailVO(quoteTransaction));
        return new JsonResponse("OK", "");
    }
}
