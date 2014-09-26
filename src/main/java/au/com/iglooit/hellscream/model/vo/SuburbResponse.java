package au.com.iglooit.hellscream.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 25/09/2014
 * Time: 1:33 PM
 */
public class SuburbResponse implements Serializable {
    List<SuburbVO> suburbVOList;

    public SuburbResponse() {
    }

    public List<SuburbVO> getSuburbVOList() {
        return suburbVOList;
    }

    public void setSuburbVOList(List<SuburbVO> suburbVOList) {
        this.suburbVOList = suburbVOList;
    }
}
