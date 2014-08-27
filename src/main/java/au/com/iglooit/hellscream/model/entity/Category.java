package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.search.Document;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/08/2014
 * Time: 11:55 PM
 */
@Entity
public class Category extends BaseEntity {
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
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

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("User can't support full text search");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("User can't support Geo search");
    }
}
