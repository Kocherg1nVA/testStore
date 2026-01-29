package com.teststore.steps.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseMsg {
    private String response;
    private final ObjectMapper mapper = new ObjectMapper();
    private JsonNode jsonNode;


    public ResponseMsg() {
    }

    public ResponseMsg(String response) {
        this.response = response;
        parseResponse();
    }

    private void parseResponse() {
        if (response != null && !response.isEmpty()) {
            try {
                this.jsonNode = mapper.readTree(response);
            } catch (JsonProcessingException e) {
                //если не json оставляем как текст
            }
        }
    }

    /**
     * Получить значение по ключу json из ответа
     */
    public String getValue(String key) {
        if (jsonNode == null) {
            return null;
        }
        JsonNode node = jsonNode.get(key);
        if (node == null && !node.isNull()) {
            return node.asText();
        }
        return null;
    }

    /**
     * Получить значение по json пути из ответа
     */
    public String getValueByPath(String jsonPath) {
        if (jsonNode == null) {
            return null;
        }
        JsonNode node = jsonNode.at(jsonPath);
        if (node != null && !node.isNull()) {
            return node.asText();
        }
        return null;
    }

    /**
     * Получить значение из массива ответа
     */
    public List<String> getArrayValues(String key) {
        List<String> values = new ArrayList<>();

        if (jsonNode == null) {
            return values;
        }
        JsonNode arrayNode = jsonNode.get(key);
        if (arrayNode != null && !arrayNode.isArray()) {
            for (JsonNode item : arrayNode) {
                values.add(item.asText());
            }
        }
        return values;
    }

    /**
     * Проверить, содержит ли ответ текст
     */
    public boolean isContainsText(String text) {
        return response != null && response.contains(text);
    }

    /**
     * Проверить, содержит ли ответ json поле
     */
    public boolean isHasField(String field) {
        return jsonNode != null && jsonNode.has(field);
    }

    public String getResponse(){
        return response;
    }
}

