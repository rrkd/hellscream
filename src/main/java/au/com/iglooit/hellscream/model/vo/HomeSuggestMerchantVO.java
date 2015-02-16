package au.com.iglooit.hellscream.model.vo;

import au.com.iglooit.hellscream.model.entity.Merchant;

import java.io.Serializable;

/**
 * Created by nicholaszhu on 16/02/2015.
 */
public class HomeSuggestMerchantVO implements Serializable {
    private Merchant bestOfToday;
    private Merchant recommendOfToday;
    private Merchant hottestOfWeek;
    private Merchant highOfRank;

    public Merchant getBestOfToday() {
        return bestOfToday;
    }

    public void setBestOfToday(Merchant bestOfToday) {
        this.bestOfToday = bestOfToday;
    }

    public Merchant getRecommendOfToday() {
        return recommendOfToday;
    }

    public void setRecommendOfToday(Merchant recommendOfToday) {
        this.recommendOfToday = recommendOfToday;
    }

    public Merchant getHottestOfWeek() {
        return hottestOfWeek;
    }

    public void setHottestOfWeek(Merchant hottestOfWeek) {
        this.hottestOfWeek = hottestOfWeek;
    }

    public Merchant getHighOfRank() {
        return highOfRank;
    }

    public void setHighOfRank(Merchant highOfRank) {
        this.highOfRank = highOfRank;
    }
}
