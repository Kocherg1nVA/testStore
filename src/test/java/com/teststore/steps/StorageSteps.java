package com.teststore.steps;

import com.teststore.pages.AbstractPage;
import com.teststore.pages.PageFactory;
import com.teststore.utils.Storage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;

import java.util.List;
import java.util.Map;

public class StorageSteps extends AbstractSteps{
    AbstractPage currentPage;

    @Дано("инициализация тестовых данных")
    public void initializeTestData(List<Map<String, String>> dataTable) {
        for (Map<String, String> row : dataTable) {
            String key = row.get("Ключ");
            String type = row.get("Тип");
            String value = row.get("Значение");

            switch (type.toLowerCase()) {
                case "int":
                    Storage.put(key, Integer.parseInt(value));
                    break;
                case "boolean":
                    Storage.put(key, Boolean.parseBoolean(value));
                    break;
                default:
                    Storage.put(key, value);
            }
        }
    }
}
