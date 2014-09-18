package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.entity.Merchant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 21/08/2014
 * Time: 4:40 PM
 */
public interface MerchantFTSearchService {
    public List<Merchant> searchByKeyWord(String keyword);
    public List<Merchant> searchByKeyWordAndLocal(String keyword, String local);
}
