package com.teststore.Config;

import org.citrusframework.context.TestContext;
import org.citrusframework.context.TestContextFactory;
import org.citrusframework.http.client.HttpClient;
import org.citrusframework.http.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan(basePackages = "com.teststore")
public class CitrusConfig {

    @Value("${api.base.url.yandex}")
    private String apiBaseUrlYandex;

    @Value("${api.auth.token.yandex}")
    private String authTokenYandex;

    @Value("${api.base.url.booker}")
    private String apiBaseUrlBooker;

    @Value("${api.auth.token.booker}")
    private String authTokenBooker;

    @Bean(name = "yandexClient")
    public HttpClient yandexClient() {
        return new HttpClientBuilder()
                .requestUrl(apiBaseUrlYandex)
                .contentType("application/json")
                .charset("UTF-8")
                .timeout(60_000L)
                .build();
    }

    @Bean(name = "restfulBooker")
    public HttpClient booker() {
        return new HttpClientBuilder()
                .requestUrl(apiBaseUrlBooker)
                .contentType("application/json")
                .charset("UTF-8")
                .timeout(60_000L)
                .build();
    }

    @Bean
    public TestContextFactory testContextFactory() {
        return TestContextFactory.newInstance();
    }

    @Bean
    public TestContext testContext() {
        return testContextFactory().getObject();
    }

    @Bean
    public String getAuthTokenYandex() {
        return  authTokenYandex;
    }

    @Bean
    public String getAuthTokenBooker() {
        return authTokenBooker;
    }

}
