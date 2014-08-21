package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.exception.AppX;
import au.com.iglooit.hellscream.model.entity.Merchant;
import au.com.iglooit.hellscream.repository.BaseRepository;
import au.com.iglooit.hellscream.service.IndexServiceHelp;
import com.google.appengine.api.search.Index;
import com.google.appengine.api.search.IndexSpec;
import com.google.appengine.api.search.PutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/08/2014
 * Time: 11:55 AM
 */
@Component
public class MerchantManageServiceImpl extends BaseRepository<Merchant> implements MerchantManageService {
    private static final Logger LOG = LoggerFactory.getLogger(MerchantManageServiceImpl.class);
    public MerchantManageServiceImpl() {
        super(Merchant.class);
    }

    @Override
    public List<Merchant> findAllMerchants() {
        List<Merchant> result = findAll();
        LOG.info("size:" + result.size());
        return result;
    }

    @Override
    public Merchant findByTradeName(String tradeName) {
        return findAll().get(0);
    }

    @Override
    public void createMerchant(Merchant merchant) {
        add(merchant);
        // create index
        Index merchantIndex = IndexServiceHelp.getMerchantIndex();
        try {
            merchantIndex.put(merchant.toDocument());
        } catch (PutException e) {
            throw new AppX("Can't create document for " + merchant.getKey(), e);
        }
    }
}
