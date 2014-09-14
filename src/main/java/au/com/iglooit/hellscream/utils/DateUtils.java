package au.com.iglooit.hellscream.utils;

import au.com.iglooit.hellscream.exception.AppX;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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

    public static Date getNow() {
        Calendar ausNow = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        return ausNow.getTime();
    }

    public static Date getOneWeekAgo() {
        Calendar weekAgo = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        weekAgo.add(Calendar.WEEK_OF_YEAR, -1);
        return weekAgo.getTime();
    }
}
