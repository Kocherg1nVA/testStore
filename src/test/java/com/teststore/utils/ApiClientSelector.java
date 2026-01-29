package com.teststore.utils;

import org.citrusframework.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ApiClientSelector {

    private final HttpClient yandexClient;
    private final HttpClient bookerClient;

    @Autowired
    public ApiClientSelector(
            @Qualifier("yandexClient") HttpClient yandexClient,
            @Qualifier("bookerClient") HttpClient bookerClient
    ) {
        this.yandexClient = yandexClient;
        this.bookerClient = bookerClient;
    }

    public HttpClient selectClient(String endpoint) {
        String clientUrl = ApiClientRouter.hostPath(endpoint);

        if (clientUrl == null) {
            throw new IllegalArgumentException("Не удалось определить клиент для пути: " + endpoint);
        }
        Stand.ClientType clientType = Stand.getClientTypeByUrl(clientUrl);
        return getHttpClientByType(clientType);
    }

    private HttpClient getHttpClientByType(Stand.ClientType clientType) {
        return switch (clientType) {
            case YANDEX -> yandexClient;
            case BOOKER -> bookerClient;
            default -> throw new IllegalArgumentException("Неподдерживаемый тип клиента: " + clientType);
        };
    }

    public HttpClient selectClientByUrl(String url) {
        if (Stand.isYandexUrl(url)) {
            return yandexClient;
        } else if (Stand.isBookerUrl(url)) {
            return bookerClient;
        }
        throw new IllegalArgumentException("Неизвестный URL клиента: " + url);
    }
}
