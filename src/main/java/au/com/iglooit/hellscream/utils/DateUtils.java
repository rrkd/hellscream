package au.com.iglooit.hellscream.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 22/08/2014
 * Time: 2:51 PM
 */
public final class DateUtils {
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    private DateUtils() {

    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DATE_PATTERN).format(date);
    }
}
