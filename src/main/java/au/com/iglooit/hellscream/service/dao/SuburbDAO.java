package au.com.iglooit.hellscream.service.dao;

import au.com.iglooit.hellscream.model.entity.Suburb;
import au.com.iglooit.hellscream.model.vo.SuburbVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/09/2014
 * Time: 9:16 PM
 */
public interface SuburbDAO extends IEntityService<Suburb> {
    void createSuburb(Suburb suburb);

    Suburb findByName(String name);

    Suburb findByPostcode(String postcode);

    List<SuburbVO> findByKeyword(String keyWord);
}
