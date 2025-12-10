package com.teststore;

import com.teststore.Config.CitrusConfig;
import com.teststore.steps.API.ApiUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CitrusConfig.class)
public class SimpleApiTest {

    @Autowired
    private ApiUtils apiUtils;

    @Test
    public void testGetRequest() {
        apiUtils.sendGetRequest("/v1/disk/");
        apiUtils.getResponse();
//        apiUtils.getResponseStatusCode();
    }

//    @Test
//    public void testGetResponse() {
//        apiUtils.getResponse();
//    }
}
