package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.search.Document;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 28/10/2014
 * Time: 8:18 AM
 */
@Entity
public class Statistic extends BaseEntity {
    private String statisticName;
    private Long statisticCount;
    private Date updateDate;

    public Statistic() {

    }

    @Override
    public Document toFullTextDocument() {
        throw new UnsupportedOperationException("");
    }

    @Override
    public Document toGeoDocument() {
        throw new UnsupportedOperationException("");
    }

    public String getStatisticName() {
        return statisticName;
    }

    public void setStatisticName(String statisticName) {
        this.statisticName = statisticName;
    }

    public Long getStatisticCount() {
        return statisticCount;
    }

    public void setStatisticCount(Long statisticCount) {
        this.statisticCount = statisticCount;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
