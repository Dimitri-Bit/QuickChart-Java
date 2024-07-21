package me.dimitri.serializer;

import lombok.SneakyThrows;
import me.dimitri.exception.InvalidChartException;

import java.lang.reflect.Field;

public class ChartConverter {

    private static final String PACKAGE_NAME = "me.dimitri.model";

    @SneakyThrows
    public String convertToJson(Object object) {
        if (object == null) {
            throw new NullPointerException("Null chart provided");
        }

        if (!object.getClass().getPackageName().equals(PACKAGE_NAME)) {
            throw new InvalidChartException("Object is not from the valid package");
        }

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Object value = field.get(object);
            if (value == null) {
                continue;
            }

            if (jsonBuilder.length() > 1) {
                jsonBuilder.append(",");
            }

            jsonBuilder.append("\"").append(field.getName()).append("\":").append(serializeValue(field, object));
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    @SneakyThrows
    private String serializeValue(Field field, Object object) {
        StringBuilder sb = new StringBuilder();

        Object value = field.get(object);

        if (value instanceof String) {
            sb.append(serializeString(value));
            return sb.toString();
        }

        if (value instanceof Double || value instanceof Integer || value instanceof Boolean) {
            sb.append(value);
            return sb.toString();
        }

        if (value.getClass().isArray()) {
            sb.append(serializeArray(value));
            return sb.toString();
        }

        return convertToJson(value);
    }

    private String serializeArray(Object object) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Object[] arr = (Object[]) object;
        for (int i = 0; i < arr.length; i++) {

            Object arrElement = arr[i];
            if (arrElement instanceof String) {
                sb.append("\"");
                sb.append(arrElement);
                sb.append("\"");
            } else {
                sb.append(convertToJson(arrElement));
            }

            if (i < (arr.length - 1))
                sb.append(",");
        }

        sb.append("]");
        return sb.toString();
    }

    private String serializeString(Object object) {
        return "\"" + object + "\"";
    }

}
