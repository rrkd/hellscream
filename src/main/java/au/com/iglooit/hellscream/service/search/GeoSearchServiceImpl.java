package au.com.iglooit.hellscream.service.search;

import com.google.appengine.api.search.GeoPoint;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderGeometry;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 24/08/2014
 * Time: 8:36 AM
 */
@Component
public class GeoSearchServiceImpl implements GeoSearchService {
    private static final Logger LOG = LoggerFactory.getLogger(GeoSearchServiceImpl.class);

    @Override
    public GeoPoint convertGeoPoint(String address) {
        final Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address)
                .setLanguage("en").getGeocoderRequest();
        GeocodeResponse geocoderResponse = null;
        try {
            geocoderResponse = geocoder.geocode(geocoderRequest);
        } catch (IOException e) {
            LOG.error("Can NOT find Geo inforamtion for " + address, e);
            return null;
        }
        List<GeocoderResult> resultList = geocoderResponse.getResults();
        if (resultList != null && resultList.size() > 0) {
            GeocoderResult data = resultList.get(0);
            GeocoderGeometry data_2 = data.getGeometry();
            BigDecimal latitude = data_2.getLocation().getLat();
            BigDecimal longitude = data_2.getLocation().getLng();
            return new GeoPoint(latitude.doubleValue(), longitude.doubleValue());
        }
        LOG.info("Can NOT find Geo inforamtion for " + address);
        return null;
    }
}
