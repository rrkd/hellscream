package au.com.iglooit.hellscream.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 16/09/2014
 * Time: 11:32 AM
 */
public final class DescriptionUtils {
    private static final Integer MAX_LEN = 100;

    private DescriptionUtils() {

    }

    public static String build(String description) {
        if (!StringUtils.isBlank(description)) {
            return description.length() > MAX_LEN ? description.substring(0, MAX_LEN) + "..." : description;
        }
        return "";
    }
}
