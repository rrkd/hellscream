package au.com.iglooit.hellscream.service;

import au.com.iglooit.hellscream.properties.WebProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: nicholas.zhu
 * Date: 4/10/2014
 * Time: 4:16 PM
 */
@Component
public class DummyContentCfgService {
    private static final Logger LOG = LoggerFactory.getLogger(DummyContentCfgService.class);

    @PostConstruct
    public void init() throws Exception {
        WebProperties webProperties = WebProperties.getInstance();
        Boolean initData = Boolean.valueOf(webProperties.get("init.dummy.data"));
        if (initData) {
            LOG.info("init dummy data.");
            initDummyConfig();
        }
    }

    private void initDummyConfig(){

    }
}
