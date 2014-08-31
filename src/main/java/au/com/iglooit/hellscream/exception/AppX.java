package au.com.iglooit.hellscream.exception;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 11/08/2014
 * Time: 8:55 PM
 */
public class AppX extends RuntimeException {
    public AppX (String error) {
        super(error);
    }

    public AppX(String error, Throwable e) {
        super(error, e);
    }
}
