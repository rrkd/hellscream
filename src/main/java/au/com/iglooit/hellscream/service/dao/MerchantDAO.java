package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.model.vo.MerchantVO;
import au.com.iglooit.hellscream.model.vo.SearchResultVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:50 AM
 */
public interface MerchantDAO extends IEntityService<Merchant> {
    List<Merchant> findAllMerchants();

    List<Merchant> findMerchants(int pos, int size);

    Merchant findByTradeName(String tradeName);

    void createMerchant(Merchant merchant);

    void modifyMerchant(Merchant merchant);

    List<Merchant> findByCategoryName(String categoryName);

    List<Merchant> findByCategoryName(List<String> categoryName);

    Boolean checkExistMerchant(String tradeName, String email);

    SearchResultVO findMerchants(Integer pageNumber);

    Merchant findByURL(String canonicalSlugId);

    SearchResultVO<MerchantVO> findMerchants(String prefix, Integer pageNumber);

    List<Merchant> findLatestMerchant(Integer size);

    Long countMerchant();

    Merchant findBestOfToday();
    Merchant findHighOfRank();
    Merchant findHottestOfWeek();
    Merchant findRecommendOfToday();
}
