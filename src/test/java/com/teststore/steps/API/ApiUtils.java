package com.teststore.steps.API;

import jakarta.annotation.PostConstruct;
import org.citrusframework.DefaultTestCaseRunner;
import org.citrusframework.TestCaseRunner;
import org.citrusframework.context.TestContext;
import org.citrusframework.context.TestContextFactory;
import org.citrusframework.http.client.HttpClient;
import org.citrusframework.http.message.HttpMessageHeaders;
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

    @Autowired
    private Payload payload;

    @Autowired
    private ResponseMsg responseMsg;

    private TestCaseRunner runner;

    private Map<String, Object> headers = new HashMap<>();
    private Map<String, String> queryParams = new HashMap<>();
    private String body;
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

    public void addBodyFromString(String body) {
        payload.clearPayload();
        payload.setPayload(body);
        this.body = payload.getPayload();
    }

    public void addBodyFromTemplate(String templatePath) {
        payload.clearPayload();
        payload.createFromTemplate("src/test/resources/" + templatePath);
        this.body = payload.getPayload();
    }


    public void sendGetRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .get(endpoint)
                .message()
                        .name("request")
                .headers(headers)
                .body(body)
        );

    }

    public void sendPostRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .post(endpoint)
                .message()
                .headers(headers)
                .body(body));
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
        runner.run(http()
                .client(yandexClient)
                .receive()
                .response()
                .message()
                .name(responseName));

        String responseBody = (String) context.getMessageStore().getMessage(responseName).getPayload();
        responseMsg = new ResponseMsg(responseBody);
        return responseBody;
    }

    public int getResponseStatusCode() {
        return (int) (Integer) context.getMessageStore().getMessage(responseName).getHeader(HttpMessageHeaders.HTTP_STATUS_CODE);
    }

    public String getResponseHeaders() {
        return context.getMessageStore().getMessage(responseName).getHeaders().toString();
    }
}
