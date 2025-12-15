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
    private String requestName = "ЗАПРОС";
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
                .name(requestName)
                .headers(headers)
                .body(body));
    }

    public void sendPostRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .post(endpoint)
                .message()
                .name(requestName)
                .headers(headers)
                .body(body));
    }

    public void sendPutRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .put(endpoint)
                .message()
                .name(requestName)
                .headers(headers)
                .body(body));
    }

    public void sendPatchRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .patch(endpoint)
                .message()
                .name(requestName)
                .headers(headers)
                .body(body));
    }

    public void sendDeleteRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .delete(endpoint)
                .name(requestName)
                .message()
                .name(requestName)
                .headers(headers)
                .body(body));
    }

    public void getResponse() {
        runner.run(http()
                .client(yandexClient)
                .receive()
                .response()
                .message()
                .name(responseName));

        String responseBody = getResponseBody();
        responseMsg = new ResponseMsg(responseBody);
    }

    public String getRequestBody() {
        return context.getMessageStore().getMessage(requestName).getPayload().toString();
    }

    public String getResponseBody() {
        return (String) context.getMessageStore().getMessage(responseName).getPayload();
    }

    public String getRequestFullUri(String endpoint) {
        return yandexClient.getEndpointConfiguration().getRequestUrl() + endpoint;
    }

    public int getResponseStatusCode() {
        return (int) (Integer) context.getMessageStore().getMessage(responseName).getHeader(HttpMessageHeaders.HTTP_STATUS_CODE);
    }

    public String getResponseHeaders() {
        return context.getMessageStore().getMessage(responseName).getHeaders().toString();
    }
    public String getRequestHeaders() {
        return context.getMessageStore().getMessage(requestName).getHeaders().toString();
    }
}
