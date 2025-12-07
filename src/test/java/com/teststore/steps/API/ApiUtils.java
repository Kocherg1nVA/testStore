package com.teststore.steps.API;

import jakarta.annotation.PostConstruct;
import org.citrusframework.DefaultTestCaseRunner;
import org.citrusframework.TestCaseRunner;
import org.citrusframework.context.TestContext;
import org.citrusframework.context.TestContextFactory;
import org.citrusframework.http.client.HttpClient;
import org.citrusframework.validation.json.JsonPathVariableExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.citrusframework.http.actions.HttpActionBuilder.http;

@Component
public class ApiUtils {

    @Autowired
    private HttpClient yandexClient;

    @Autowired
    private String authTokenYandex;

    @Autowired
    private TestContextFactory factory;

    @Autowired
    private TestContext context;

    private TestCaseRunner runner;

    private Map<String, Object> headers = new HashMap<>();
    private Map<String, String> queryParams = new HashMap<>();
    private String responseName = "ОТВЕТ";

    @PostConstruct
    public void init() {
        resetContext();
    }

    private void resetContext() {
        this.runner = new DefaultTestCaseRunner(context);
    }

    public void clearHeaders() {
        headers.clear();
    }

    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    public void addAuthToken(String token) {
        headers.put(HttpHeaders.AUTHORIZATION, token);
    }


    public void sendGetRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .get(endpoint)
                .message()
                .headers(headers));
    }

    public void sendPostRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .post(endpoint)
                .message()
                .headers(headers));
    }

    public void sendPatchRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .patch(endpoint)
                .message()
                .headers(headers));
    }

    public void sendDeleteRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .delete(endpoint)
                .message()
                .headers(headers));
    }

    public String getResponse() {
        Map<String, Object> expressions = new HashMap<>();
        expressions.put("$", "responseBody");
        JsonPathVariableExtractor extractor = new JsonPathVariableExtractor.Builder()
                .expressions(expressions)
                        .build();

        runner.run(http()
                .client(yandexClient)
                .receive()
                .response()
                .name(responseName)
                .message()
                .extract(extractor));


        String response = context.getVariable("responseBody");
        System.out.println("===== ОТВЕТ =====");
        System.out.println(response);
        System.out.println("===== КОНЕЦ =====");
        return response;

    }
}
