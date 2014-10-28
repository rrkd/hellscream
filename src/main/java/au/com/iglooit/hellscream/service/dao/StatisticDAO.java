package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Statistic;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 28/10/2014
 * Time: 11:08 AM
 */
public interface StatisticDAO extends IEntityService<Statistic> {
    void createStatistic(Statistic statistic);
    Statistic findByName(String name);
    void addMerchant();
    Long countMerchant();
}
