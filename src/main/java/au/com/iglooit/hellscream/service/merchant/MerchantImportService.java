package au.com.iglooit.hellscream.service.merchant;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantImportVO;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 20/10/2014
 * Time: 9:16 AM
 */
public interface MerchantImportService {
    Merchant saveOrUpdateMerchant(MerchantImportVO vo);
}
