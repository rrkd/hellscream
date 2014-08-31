package au.com.iglooit.hellscream.utils;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 28/08/2014
 * Time: 7:48 AM
 */
public final class CategoryIdentifierConvert {
    private CategoryIdentifierConvert() {

    }

    public static String convertToURL(String tradeName) {
        return tradeName.replaceAll(" ", "-").replaceAll(",", "-").replaceAll("&", "and");
    }
}
