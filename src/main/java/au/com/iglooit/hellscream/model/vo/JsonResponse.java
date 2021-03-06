package au.com.iglooit.hellscream.model.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * IGUser: nicholas.zhu
 * Date: 19/08/2014
 * Time: 4:06 PM
 */
public class JsonResponse implements Serializable {
    public static final String OK = "OK";
    public static final String Error = "Error";
    private String status = "";
    private String errorMessage = "";

    public JsonResponse(String status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
