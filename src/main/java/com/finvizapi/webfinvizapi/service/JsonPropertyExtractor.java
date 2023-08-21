package com.finvizapi.webfinvizapi.service;

import com.finvizapi.webfinvizapi.model.Stock;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JsonPropertyExtractor {

    public synchronized static ArrayList<String> getPropertyNames(Class<?> clazz) {
        ArrayList<String> propertyNames = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
            if (jsonProperty != null) {
                propertyNames.add(jsonProperty.value());
            }
        }
        return propertyNames;
    }

}
