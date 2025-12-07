package com.teststore.steps.API;

import com.teststore.Config.CitrusConfig;
import com.teststore.steps.AbstractSteps;
import io.cucumber.java.ru.И;
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

    @И(value = "^json запрос > отправить (GET|POST|PATCH|DELETE) запрос по пути \"(.+)\"$")
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
        LOGGER.info("Успешно! Запрос отправлен");
    }

    @И(value = "^json запрос > получить ответ$")
    public void getResponse() {
        apiUtils.getResponse();
        LOGGER.info("Ответ сервера получен");
    }

}
