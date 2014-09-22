package au.com.iglooit.hellscream.service.drive;

import au.com.iglooit.hellscream.model.vo.ClientFile;
import au.com.iglooit.hellscream.model.vo.DriverFileResponse;
import au.com.iglooit.hellscream.properties.WebProperties;
import com.google.api.services.drive.model.ParentReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static javax.servlet.http.HttpServletResponse.SC_OK;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 20/09/2014
 * Time: 10:57 AM
 */
@Component
public class DriveDocService {
    private static final Logger LOG = LoggerFactory.getLogger(DriveDocService.class);
    private static final Integer TIME_OUT = 60;
    @Resource
    private HttpClient httpClient;

    public DriverFileResponse storeFileToDrive(ClientFile file) {
        // set time out
        HttpParams httpParams = httpClient.getParams();
        httpParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TIME_OUT * 1000);
        httpParams.setParameter(CoreConnectionPNames.SO_TIMEOUT, TIME_OUT * 1000);

        // set default folder
        ParentReference parentReference = new ParentReference();
        parentReference.setId("0BzJHza5vMzgvNDA5N0xoMXZudU0");
        file.parents.add(parentReference);

        WebProperties webProperties = WebProperties.getInstance();
        String svcUrl = webProperties.get("driver.svc");
        DriverFileResponse result = new DriverFileResponse();
        HttpPost post = null;
        try {
            post = new HttpPost(svcUrl);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            StringEntity params = new StringEntity(gson.toJson(file), "UTF-8");
            post.addHeader("content-type", "application/json");
            post.setEntity(params);
            HttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == SC_OK) {

                // update resource id
                result.setResourceId(IOUtils.toString(response.getEntity().getContent(), "UTF-8").replaceAll("\"", ""));
                result.setFileUrl(file.title);
                LOG.info("New entity created. Id:" + result.getResourceId());
            } else {
                LOG.error("Can't save merchant logo.");
                result.setStatus("Error");
                result.setErrorMessage("Can't save merchant logo.");
            }
            HttpEntity re = response.getEntity();
            EntityUtils.consume(re);
        } catch (Exception e) {
            LOG.error("Can't save file", e);
        } finally {
            if (null != post) {
                post.releaseConnection();
            }
        }
        return result;
    }
}
