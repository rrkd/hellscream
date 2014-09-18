package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.vo.AddressVO;
import com.google.appengine.api.search.GeoPoint;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 24/08/2014
 * Time: 8:36 AM
 */
public interface GeoSearchService {
    AddressVO formatAddress(String address);
}
