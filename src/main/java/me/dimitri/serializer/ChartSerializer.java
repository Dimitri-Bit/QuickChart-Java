package me.dimitri.serializer;

import me.dimitri.exception.InvalidChartException;
import me.dimitri.model.ChartObject;

import java.lang.reflect.Field;

public class ChartSerializer {

    public String serializeChartObject(Object object) throws IllegalAccessException {

        if (object == null) {
            throw new NullPointerException("Null chart provided");
        }

        if (!(object instanceof ChartObject)) {
            throw new InvalidChartException("Only Chart Objects can be serialized");
        }

        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Object fieldValue = field.get(object);
            if (fieldValue == null) {
                continue;
            }

            if (json.length() > 1) {
                json.append(",");
            }

            String serializedObject = serializeObject(fieldValue);
            json.append("\"").append(field.getName()).append("\":").append(serializedObject);
        }

        json.append("}");
        return json.toString();
    }

    public String serializeObject(Object value) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();

        if (value instanceof String) {
            json.append("\"").append(value).append("\"");
            return json.toString();
        }

        if (value instanceof Number || value instanceof Boolean) {
            json.append(value);
            return json.toString();
        }

        if (value.getClass().isArray()) {
            json.append(serializeArray(value));
            return json.toString();
        }

        return serializeChartObject(value);
    }

    private String serializeArray(Object object) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();
        json.append("[");

        Object[] arr = (Object[]) object;
        for (int i = 0; i < arr.length; i++) {
            json.append(serializeObject(arr[i]));

            if (i < (arr.length - 1)) {
                json.append(",");
            }
        }

        json.append("]");
        return json.toString();
    }
}
