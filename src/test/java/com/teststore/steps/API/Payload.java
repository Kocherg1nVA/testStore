package com.teststore.steps.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("cucumber-glue")
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
            Map<String, Object> jsonMap = new HashMap<>();
            if (templatePath != null && !templatePath.isEmpty()) {
                jsonMap = mapper.readValue(templatePath, Map.class);
            }
//            for (Map.Entry<String, String> entry : variables.entrySet()) {
//                jsonMap.put(entry.getKey(), entry.getValue());
//            }
            jsonMap.putAll(variables);
            this.payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка создания JSON", e);
        }
    }

    /**
     * Создать простой JSON из map
     */
    public void createFromMap(Map<String, String> data) {
        try {
            this.payload = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка создания JSON", e);
        }
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
