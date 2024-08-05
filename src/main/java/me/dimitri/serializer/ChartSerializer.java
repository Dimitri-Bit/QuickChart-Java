package me.dimitri.serializer;

import lombok.experimental.UtilityClass;
import me.dimitri.model.chart.ChartObject;
import me.dimitri.model.chart.impl.datapoint.GenericDataPoint;

import java.lang.reflect.Field;

@UtilityClass
public class ChartSerializer {

    // TODO: Add logging

    public static String serialize(Object object) {
        StringBuilder json = new StringBuilder();

        if (object instanceof ChartObject chartObject) {
            if (object instanceof GenericDataPoint<?> genericDataPoint) {
                json.append(serialize(genericDataPoint.getValue()));
                return json.toString();
            }

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

    private static String serializeChartObj(ChartObject chartObject) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = chartObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Object fieldValue;
            try {
                fieldValue = field.get(chartObject);
            } catch (IllegalAccessException e) {
                fieldValue = "";
            }

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

    private static String serializeArray(Object object) {
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
