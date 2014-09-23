package au.com.iglooit.hellscream.utils;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
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
        char[] source = tradeName.trim().toLowerCase().toCharArray();
        char[] dest = new char[source.length];
        int destIndex = 0;
        for (char aSource : source) {
            if (aSource == ' ') {
                dest[destIndex++] = '-';
            } else if (aSource >= 'a' && aSource <= 'z') {
                dest[destIndex++] = aSource;
            } else if (aSource >= '0' && aSource <= '9') {
                dest[destIndex++] = aSource;
            }
        }
        return String.valueOf(dest).trim();
    }

    public static String convertToTradeName(String url) {
        throw new UnsupportedOperationException("Can't decode trade name. User search service instead.");
    }
}
