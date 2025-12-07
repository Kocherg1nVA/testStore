package com.teststore;

import com.teststore.Config.CitrusConfig;
import org.citrusframework.TestCaseRunner;
import org.citrusframework.annotations.CitrusEndpoint;
import org.citrusframework.annotations.CitrusResource;
import org.citrusframework.context.TestContext;
import org.citrusframework.http.client.HttpClient;
import org.citrusframework.validation.json.JsonPathVariableExtractor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.citrusframework.http.actions.HttpActionBuilder.http;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CitrusConfig.class)
public class ApiCitrusTest2 {

    @CitrusResource
    private TestCaseRunner runner;

    @Autowired
    private HttpClient yandexClient;

    @Autowired
    private TestContext context;

    @Autowired
    private String authToken;

    private static final String responseName = "ОТВЕТ";

    @Test
    public void testGetRequest() {
        runner.run(http()
                .client(yandexClient)
                .send()
                .get("/v1/disk/")
                .message()
                .header("Authorization", authToken));

        Map<String, Object> expressions = new HashMap<>();
        expressions.put("$", "responseBody");
        JsonPathVariableExtractor extractor = new JsonPathVariableExtractor.Builder()
                .expressions(expressions)
                .build();

        runner.run(http()
                .client(yandexClient)
                .receive()
                .response()
                .message()
                .name(responseName)
                .extract(extractor));

//        var response = context.getMessageStore().getMessage(responseName);
//        System.out.println(response);

        String responseBody = context.getVariable("responseBody");
        System.out.println(responseBody);

    }
}
