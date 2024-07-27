package me.dimitri.serializer;

import me.dimitri.model.ChartObject;

import java.lang.reflect.Field;

public class ChartSerializer {

    public String serialize(Object object) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();

        if (object instanceof ChartObject chartObject) {
            json.append(serializeChartObj(chartObject));
            return json.toString();
        }

        if (object instanceof String) {
            json.append("\"").append(object).append("\"");
            return json.toString();
        }

        if (object instanceof Number || object instanceof Boolean) {
            json.append(object);
            return json.toString();
        }

        if (object.getClass().isArray()) {
            json.append(serializeArray(object));
            return json.toString();
        }

        return "";
    }

    private String serializeChartObj(ChartObject chartObject) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = chartObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Object fieldValue = field.get(chartObject);
            if (fieldValue == null) {
                continue;
            }

            if (json.length() > 1) {
                json.append(",");
            }

            String key = field.getName();
            String serializedValue = serialize(fieldValue);
            json.append("\"").append(key).append("\":").append(serializedValue);
        }

        json.append("}");
        return json.toString();
    }

    private String serializeArray(Object object) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();
        json.append("[");

        Object[] arr = (Object[]) object;
        for (int i = 0; i < arr.length; i++) {
            json.append(serialize(arr[i]));

            if (i < (arr.length - 1)) {
                json.append(",");
            }
        }

        json.append("]");
        return json.toString();
    }
}
