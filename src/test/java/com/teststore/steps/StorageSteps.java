package com.teststore.steps;

import com.teststore.utils.Storage;
import io.cucumber.java.ru.Дано;

import java.util.List;
import java.util.Map;

public class StorageSteps extends AbstractSteps{

    @Дано("инициализация тестовых данных")
    public void initializeTestData(List<Map<String, String>> dataTable) {
        for (Map<String, String> row : dataTable) {

            String key = row.get("Ключ");
            String value = row.get("Значение");

            try {
                if (value.matches("\\d+")) {
                    Storage.put(key, Integer.parseInt(value));
                } else if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                    Storage.put(key, Boolean.parseBoolean(value));
                } else {
                    Storage.put(key, value);
                }
                LOGGER.info("Сохранено в хранилище: ключ: {}, значение: {} (Тип: {})",
                        key, value, Storage.get(key).getClass().getSimpleName());
            } catch (Exception e) {
                LOGGER.error("Ошибка при обработке значения {}: {}", key, e.getMessage());
                throw e;
            }
        }
    }
}
