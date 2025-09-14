package com.teststore.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StorageUtils {

    private static final Logger LOGGER = LogManager.getLogger(StorageUtils.class);
    private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\$\\{(.+?)\\}");

    public static String resolveTemplate(String template) {
        if (template == null) {
            return null;
        }

        Matcher matcher = VARIABLE_PATTERN.matcher(template);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String variableName = matcher.group(1);
            LOGGER.debug("Найдена переменная заключенная в '${ }'");
            Object value = Storage.get(variableName);

            if (value != null) {
                matcher.appendReplacement(result, value.toString());
                LOGGER.info("Произведена замена ${ } на переменную из хранилища: " + value);
            } else {
                matcher.appendReplacement(result, matcher.group(0));
            }
        }
        matcher.appendTail(result);
        LOGGER.info("Переменная '{}' преобразована в : '{}'", template, result.toString());
        return result.toString();
    }

    public static boolean containsVariable(String text) {
        return text != null && VARIABLE_PATTERN.matcher(text).find();
    }
}
