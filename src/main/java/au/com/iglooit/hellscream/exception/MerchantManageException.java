package au.com.iglooit.hellscream.exception;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 23/09/2014
 * Time: 4:05 PM
 */
public class MerchantManageException extends Exception {
    public MerchantManageException(String message) {
        super(message);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public MerchantManageException(String message, Throwable cause) {
        super(message, cause);
    }
}
