package com.teststore.steps.API;

import com.teststore.Config.CitrusConfig;
import com.teststore.steps.AbstractSteps;
import com.teststore.utils.Storage;
import io.cucumber.java.ru.И;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CitrusConfig.class)
public class ApiSteps extends AbstractSteps {

    @Autowired
    private ApiUtils apiUtils;

    @И(value = "^json запрос > очистить заголовки запроса$")
    public void clearHeaders() {
        apiUtils.clearHeaders();
        LOGGER.info("Очищены заголовки запроса");
    }

    @И(value = "^json запрос > добавить заголовок \"(.+)\" со значением \"(.+)\"$")
    public void addHeader(String name, String value) {
        apiUtils.addHeader(name, value);
        LOGGER.info("Добавлен заголовок {} со значением {}", name, value);
    }

    @И(value = "^json запрос > добавить токен авторизации \"(.+)\"$")
    public void addAuthToken(String token) {
        apiUtils.addAuthToken(token);
        LOGGER.info("Добавлен заголовок с токеном авторизации");
    }

    @И(value = "^json запрос > отправить (GET|POST|PUT|PATCH|DELETE) запрос по пути \"(.+)\"$")
    public void sendJsonRequest(String httpMethod, String endpoint) {
        switch (httpMethod) {
            case "GET":
                LOGGER.debug("Отправляется GET запрос по пути {}", endpoint);
                apiUtils.sendGetRequest(endpoint);
                break;
            case "POST":
                LOGGER.debug("Отправляется POST запрос по пути {}", endpoint);
                apiUtils.sendPostRequest(endpoint);
                break;
            case "PUT":
                LOGGER.debug("Отправляется PUT запрос по пути {}", endpoint);
                apiUtils.sendPutRequest(endpoint);
                break;
            case "PATCH":
                LOGGER.debug("Отправляется PATCH запрос по пути {}", endpoint);
                apiUtils.sendPatchRequest(endpoint);
                break;
            case "DELETE":
                LOGGER.debug("Отправляется DELETE запрос по пути {}", endpoint);
                apiUtils.sendDeleteRequest(endpoint);
            default:
                throw new IllegalArgumentException("Неподдерживаемый тип запроса: " + httpMethod);
        }
        String url = apiUtils.getRequestFullUri(endpoint);
        String headers = apiUtils.getRequestHeaders();
        String body = apiUtils.getRequestBody();
        LOGGER.info("Успешно! {} запрос отправлен:\n{}\n{}\n{}", httpMethod, url, headers, body);
    }

    @И(value = "^json запрос > получить ответ$")
    public void getResponse() {
        apiUtils.getResponse();
        String body = apiUtils.getResponseBody();
        LOGGER.info("Успешно! Ответ сервера получен:\n{}", body);
    }

    @И(value = "^json запрос > проверить, что в ответе пришел код (\\d+)$")
    public void checkResponseStatusCode (int expectedCode) {
        int actualCode = apiUtils.getResponseStatusCode();
        Assert.assertEquals("Ошибка! Код ответа сервера не соответствует ожидаемому", expectedCode, actualCode);
        LOGGER.info("Успешно! Код ответа сервера '{}' соответствует ожидаемому: '{}'", actualCode, expectedCode);
    }

    @И(value = "^json запрос > добавить тело запроса:$")
    public void addRequestBody(String requestBody) {
        apiUtils.addBodyFromString(requestBody);
        LOGGER.info("Успешно! К запросу добавлено тело: \n {}", requestBody);
    }

    @И(value = "json запрос > создать запрос по шаблону \"(.+)\"$")
    public void createRequestByTemplate(String templatePath) {
        apiUtils.addBodyFromTemplate(templatePath);
        LOGGER.info("Успешно! Создан запрос по шаблону: {}", templatePath);
    }

    @И(value = "json запрос > сохранить заголовки ответа в Хранилище как \"(.+)\"$")
    public void saveResponseHeadersAs(String key) {
        String headers = apiUtils.getResponseHeaders();
        if (!headers.isEmpty()) {
            Storage.put(key, headers);
            LOGGER.info("Успешно! Заголовки ответа сохранены в Хранилище как {}", key);
        } else {
            LOGGER.info("Ошибка! В ответе отсутсвуют заголовки");
        }
    }

}
