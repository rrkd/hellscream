package au.com.iglooit.hellscream.service.webservice;

import au.com.iglooit.hellscream.model.vo.JsonResponse;
import au.com.iglooit.hellscream.model.vo.MerchantImportVO;
import au.com.iglooit.hellscream.service.merchant.MerchantImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 20/10/2014
 * Time: 9:32 AM
 */
@Controller
public class MerchantImportServiceWS {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantImportServiceWS.class);
    @Resource
    private MerchantImportService merchantImportService;

    @RequestMapping(value = "/ws/merchantImport",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public
    @ResponseBody
    JsonResponse addMerchant(@RequestBody MerchantImportVO vo) {
        merchantImportService.saveOrUpdateMerchant(vo);
        return new JsonResponse(JsonResponse.OK, "Import a merchant: " + vo.getTradeName());
    }
}
