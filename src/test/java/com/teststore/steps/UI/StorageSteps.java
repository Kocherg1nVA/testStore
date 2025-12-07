package com.teststore.steps.UI;

import com.teststore.steps.AbstractSteps;
import com.teststore.utils.Storage;
import com.teststore.utils.StorageUtils;
import io.cucumber.java.ru.И;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StorageSteps extends AbstractSteps {

    @И("инициализировать тестовые данные")
    public void initializeTestData(List<List<String>> dataTable) {
        for (List<String> row : dataTable) {
            if (row.size() >= 2) {
                String key = row.get(0);
                String value = row.get(1);

                if (value != null && StorageUtils.containsVariable(value)) {
                    value = StorageUtils.resolveTemplate(value);
                }

                Object processedValue = parseValue(value);
                Storage.put(key, processedValue);

                LOGGER.info("Сохранено: ключ: {}, значение: {} (Тип: {})",
                        key, processedValue, processedValue.getClass().getSimpleName());
            }
        }
    }

    private Object parseValue(String value) {
        if (value == null) {
            return null;
        }
        if (value.matches("\\d+")) {
            return Integer.parseInt(value);
        }
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(value);
        }
        return value;
    }

//    @И("^инициализировать тестовые данные с подстановкой \"(.+)\"$")
//    public void initializeTestData(String dateValue, List<Map<String, String>> dataTable) {
//        for (Map<String, String> row : dataTable) {
//
//            String key = row.get("Ключ");
//            String value = row.get("Значение");
//
//            if (value != null && value.contains("<>")) {
//                value = value.replace("<>", Storage.get(dateValue));
//            }
//
//            try {
//                if (value.matches("\\d+")) {
//                    Storage.put(key, Integer.parseInt(value));
//                } else if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
//                    Storage.put(key, Boolean.parseBoolean(value));
//                } else {
//                    Storage.put(key, value);
//                }
//                LOGGER.info("Сохранено в хранилище: ключ: {}, значение: {} (Тип: {})",
//                        key, value, Storage.get(key).getClass().getSimpleName());
//            } catch (Exception e) {
//                LOGGER.error("Ошибка при обработке значения {}: {}", key, e.getMessage());
//                throw e;
//            }
//        }
//    }

    @И("^хранилище > сохранить текущую дату в хранилище с ключом \"(.+)\"$")
    public void storeCurrentDate(String key) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        String currentDateTime = LocalDateTime.now().format(formatter);
        Storage.put(key, currentDateTime);
        LOGGER.info("Текущая дата сохранена в хранилище: c ключом '{}' и значением '{}'",
                key, currentDateTime);
    }
    //TODO создать отдельный класс для манипуляций с датами
}
