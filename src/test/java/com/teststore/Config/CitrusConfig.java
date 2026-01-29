package com.teststore.Config;

import com.teststore.config.Config;
import org.citrusframework.context.TestContext;
import org.citrusframework.context.TestContextFactory;
import org.citrusframework.http.client.HttpClient;
import org.citrusframework.http.client.HttpClientBuilder;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.teststore")
public class CitrusConfig {

    @Bean(name = "yandexClient")
    public HttpClient yandexClient() {
        return new HttpClientBuilder()
                .requestUrl(Config.getYandexApiBaseUrl())
                .contentType("application/json")
                .charset("UTF-8")
                .timeout(60_000L)
                .build();
    }

    @Bean(name = "bookerClient")
    public HttpClient bookerClient() {
        return new HttpClientBuilder()
                .requestUrl(Config.getBookerApiBaseUrl())
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

}
