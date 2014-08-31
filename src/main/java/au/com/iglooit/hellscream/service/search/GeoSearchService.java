package au.com.iglooit.hellscream.service.search;

import com.google.appengine.api.search.GeoPoint;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 24/08/2014
 * Time: 8:36 AM
 */
public interface GeoSearchService {
    GeoPoint convertGeoPoint(String address);
}
