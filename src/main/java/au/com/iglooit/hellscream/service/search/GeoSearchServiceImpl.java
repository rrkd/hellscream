package au.com.iglooit.hellscream.service.search;

import au.com.iglooit.hellscream.model.vo.AddressVO;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 24/08/2014
 * Time: 8:36 AM
 */
@Component
public class GeoSearchServiceImpl implements GeoSearchService {
    private static final Logger LOG = LoggerFactory.getLogger(GeoSearchServiceImpl.class);

    @Override
    public AddressVO formatAddress(String address) {
        LOG.info("Convert Geo Point from [" + address + "]");
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
            AddressVO vo = new AddressVO();
            GeocoderResult data = resultList.get(0);
            GeocoderGeometry data_2 = data.getGeometry();
            BigDecimal latitude = data_2.getLocation().getLat();
            BigDecimal longitude = data_2.getLocation().getLng();
            LOG.info("Get Geo Point[" + latitude + "," + longitude + "]" + " from [" + address + "]");
            vo.setGeoPoint(new GeoPoint(latitude.doubleValue(), longitude.doubleValue()));
            for (int i = 0; i < data.getAddressComponents().size(); i++) {
                if (checkType(data.getAddressComponents().get(i).getTypes(), "locality", "political")) {
                    vo.setSuburb(data.getAddressComponents().get(i).getLongName());
                }
                if (checkType(data.getAddressComponents().get(i).getTypes(), "postal_code")) {
                    vo.setPostcode(data.getAddressComponents().get(i).getLongName());
                }
            }
            vo.setFormatAddress(data.getFormattedAddress());
            return vo;
        }
        LOG.info("Can NOT find Geo inforamtion for " + address);
        return null;
    }

    private Boolean checkType(List<String> types, String... keys) {
        Set<String> set = new HashSet<String>(types);
        for (String key : keys) {
            if (!set.contains(key)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
