package au.com.iglooit.hellscream.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 13/10/2014
 * Time: 8:31 PM
 */
public final class ListUtils {
    private ListUtils() {

    }

    public static List getSubList(List list, int from, int size) {
        if (list.size() <= from) {
            return new ArrayList();
        } else if ((size - from) >= list.size()) {
            return list.subList(from, list.size() - 1);
        } else {
            return list.subList(from, from + size);
        }
    }
}
