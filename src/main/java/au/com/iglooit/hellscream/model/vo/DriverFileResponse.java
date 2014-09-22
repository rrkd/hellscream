package au.com.iglooit.hellscream.model.vo;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 19/09/2014
 * Time: 6:25 AM
 */
public class DriverFileResponse extends JsonResponse {
    private String fileUrl;
    private String resourceId;

    public DriverFileResponse() {
        this("OK", "");
    }

    public DriverFileResponse(String status, String errorMessage) {
        super(status, errorMessage);
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
