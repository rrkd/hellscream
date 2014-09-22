package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.Merchant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 22/09/2014
 * Time: 8:07 PM
 */
public class MerchantSearchResult implements Serializable {
    private List<MerchantVO> merchantList = new ArrayList<>();
    private Integer total;
    private Integer pageNum;

    public MerchantSearchResult() {

    }

    public List<MerchantVO> getMerchantList() {
        return merchantList;
    }

    public void setMerchantList(List<MerchantVO> merchantList) {
        this.merchantList = merchantList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
