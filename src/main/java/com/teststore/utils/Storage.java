package com.teststore.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Object> storage = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(Storage.class);

    public static <T> void put(String key, T value) {
        LOGGER.debug("Данные сохранены - Ключ: '{}', Значение: '{}', (Тип: {})",
                key, value, (value != null) ? value.getClass().getSimpleName() : "null");
        storage.put(key, value);
    }

    @SuppressWarnings("unchecked") // имеется контроль через метод put
    public static <T> T get(String key) {
        T value = (T) storage.get(key);

        if (value != null) {
            LOGGER.debug("Данные получены - Ключ: '{}', Значение: '{}' (Тип: {})",
                    key, value, value.getClass().getSimpleName());
        } else {
            LOGGER.warn("Попытка получить значение по несуществующему ключу: '{}'", key);
        }
        return value;
    }

    public static void clear() {
        LOGGER.info("Очистка хранилища. Текущий размер: {}", storage.size());
        storage.clear();
    }
}
