package au.com.iglooit.hellscream.utils;

import com.google.appengine.api.datastore.Key;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 18/08/2014
 * Time: 4:41 PM
 */

/**
 * Merchant Identifier
 * tradeName Nicholas Zhu
 * url: Nicholas-Zhu.html
 */
public final class MerchantIdentifierConvert {
    private MerchantIdentifierConvert() {

    }

    public static String convertToURL(String tradeName) {
        return tradeName.replaceAll(" ", "-");
    }

    public static String convertToTradeName(String url) {
        return url.replaceAll("-", " ");
    }
}
