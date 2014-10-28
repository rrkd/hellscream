package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.search.Document;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 24/08/2014
 * Time: 11:55 PM
 */
@Entity
public class Category extends BaseEntity {
    // must be english
    private String name;
    // can be chinese
    private String tradeName;
    private String description;
    private String url;
    private Long merchantCount = 0L;
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryGroup group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryGroup getGroup() {
        return group;
    }

    public void setGroup(CategoryGroup group) {
        this.group = group;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public Long getMerchantCount() {
        return merchantCount == null ? 0L : merchantCount;
    }

    public void setMerchantCount(Long merchantCount) {
        this.merchantCount = merchantCount;
    }

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("IGUser can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("IGUser can't support Geo search");
    }
}
