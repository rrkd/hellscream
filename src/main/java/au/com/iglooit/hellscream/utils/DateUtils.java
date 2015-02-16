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

    public static Date getOneMonthAgo() {
        Calendar weekAgo = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        weekAgo.add(Calendar.MONTH, -1);
        return weekAgo.getTime();
    }

    public static String getMonth(Date date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        cal.setTime(date);
        return new SimpleDateFormat("MMM").format(cal.getTime());
    }

    public static String getDay(Date date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        cal.setTime(date);
        return new SimpleDateFormat("dd").format(cal.getTime());
    }

    public static Date getStartOfTime(Calendar calendar){
        return clearTime(calendar.getTime());
    }

    public static Date getStartOfThisWeek(){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.YEAR, year);
        return cal.getTime();
    }

    public static Date getEndOfThisWeek(){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        cal.add(Calendar.DAY_OF_YEAR, 7);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.YEAR, year);
        return cal.getTime();
    }

    /** Returns the given date with the time set to the start of the day. */
    public static Date getStartOfToday() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        return clearTime(cal.getTime());
    }

    /** Returns the given date with the time set to the start of the day. */
    public static Date getEndOfToday() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return clearTime(cal.getTime());
    }

    /** Returns the given date with the time values cleared. */
    public static Date clearTime(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

}
