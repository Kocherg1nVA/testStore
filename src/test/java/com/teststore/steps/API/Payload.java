package com.teststore.steps.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Component
public class Payload {
    private String payload = "";
    private final ObjectMapper mapper = new ObjectMapper();

    public Payload() {}

    public Payload(String payload) {
        this.payload = payload;
    }

    /**
     * Создать JSON из шаблона
     */
    public void createFromTemplate(String templatePath, Map<String, String> variables) {
        try {
            String templateContent = new String(Files.readAllBytes(Paths.get(templatePath)));
            Map<String, Object> jsonMap = mapper.readValue(templateContent, Map.class);
            if (variables != null && !variables.isEmpty()) {
                jsonMap.putAll(variables);
            }
            this.payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка создания JSON", e);
        }
    }

    public void createFromTemplate(String templatePath) {
        createFromTemplate(templatePath, null);
    }

    /**
     * Получить JSON как строку
     */
    public String getPayload() {
        return this.payload;
    }

    /**
     * Установить JSON строку
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     * Проверить пустой ли JSON
     */
    public boolean isJsonEmpty() {
        return payload == null || payload.isEmpty();
    }

    /**
     * Очистить payload
     */
    public void clearPayload() {
        this.payload = "";
    }
}
