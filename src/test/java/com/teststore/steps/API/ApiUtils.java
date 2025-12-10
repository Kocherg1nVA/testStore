package com.teststore.steps.API;

import jakarta.annotation.PostConstruct;
import org.citrusframework.DefaultTestCaseRunner;
import org.citrusframework.TestCaseRunner;
import org.citrusframework.context.TestContext;
import org.citrusframework.context.TestContextFactory;
import org.citrusframework.http.client.HttpClient;
import org.citrusframework.http.message.HttpMessageHeaders;
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

    @Autowired
    private Payload payload;

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
        payload.createFromTemplate(templatePath);
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
        System.out.println("Тело запроса: \n" + context.getMessageStore().getMessage("request").getPayload());
    }

    public void sendPostRequest(String endpoint) {
        runner.run(http()
                .client(yandexClient)
                .send()
                .post(endpoint)
                .message()
                .headers(headers)
                .body(body)
        );
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
                .name("messageName")
                .extract(extractor));

        Map<String, Object> headers = context.getMessageStore().getMessage("messageName").getHeaders();
        System.out.println("===== HEADERS ======");
        System.out.println(headers);
        System.out.println("===== END ======");

        String response = context.getVariable("responseBody");
        System.out.println("===== ОТВЕТ =====");
        System.out.println(response);
        System.out.println("===== КОНЕЦ =====");
        return response;
    }

    public int getResponseStatusCode() {
        int statusCode = (Integer) context.getMessageStore().getMessage("messageName").getHeader(HttpMessageHeaders.HTTP_STATUS_CODE);
        System.out.println("Статус код ответа: " + statusCode);
        return statusCode;
    }
}
