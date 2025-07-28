package com.teststore.steps;

import com.teststore.utils.Storage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class StorageSteps extends AbstractSteps{

    @Дано("инициализация тестовых данных")
    @И("инициализировать тестовые данные")
    public void initializeTestData(List<Map<String, String>> dataTable) {
        initializeTestData(null, dataTable);
    }

    @И("^инициализировать тестовые данные с подстановкой \"(.+)\"$")
    public void initializeTestData(String dateValue, List<Map<String, String>> dataTable) {
        for (Map<String, String> row : dataTable) {

            String key = row.get("Ключ");
            String value = row.get("Значение");

            if (value != null && value.contains("<>")) {
                value = value.replace("<>", Storage.get(dateValue));
            }

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

    @И("^хранилище > сохранить текущую дату в хранилище с ключом \"(.+)\"$")
    public void storeCurrentDate(String key) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        String currentDateTime = LocalDateTime.now().format(formatter);
        Storage.put(key, currentDateTime);
        LOGGER.info("Текущая дата сохранена в хранилище: c ключом '{}' и значением '{}'",
                key, currentDateTime);
    }
}
