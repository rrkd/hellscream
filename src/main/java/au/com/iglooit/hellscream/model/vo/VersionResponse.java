package au.com.iglooit.hellscream.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 31/08/2014
 * Time: 11:13 AM
 */
public class VersionResponse extends JsonResponse {
    private String version;

    public VersionResponse(String version) {
        super("OK", "");
        this.version = version;
    }

    public VersionResponse() {
        super("OK", "");
    }

    public VersionResponse(String status, String errorMessage) {
        super(status, errorMessage);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
