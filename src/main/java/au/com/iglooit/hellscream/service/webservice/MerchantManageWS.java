package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.service.dao.MerchantManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/08/2014
 * Time: 1:01 PM
 */
@Controller
public class MerchantManageWS {
    @Resource
    private MerchantManageService merchantManageService;

    @RequestMapping(value = "/ws/merchant", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Merchant> findUser() {
        return merchantManageService.findAllMerchants();
    }

    @RequestMapping(value = "/ws/merchant",
            method = RequestMethod.PUT,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addMerchant(@RequestBody Merchant merchant) {
        merchant.setPostDate(new Date());
        merchantManageService.createMerchant(merchant);
        return new JsonResponse("OK", "");
    }
}
