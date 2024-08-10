package me.dimitri.util;

import lombok.experimental.UtilityClass;
import me.dimitri.model.chart.DataPoint;
import me.dimitri.model.chart.impl.datapoint.GenericDataPoint;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DataPointHelper {

    public static DataPoint[] dataPoints(Number[] arr) {
        List<GenericDataPoint<Number>> genericDataPoints = new ArrayList<>();

        for (Number number : arr) {
            genericDataPoints.add(new GenericDataPoint<>(number));
        }

        return genericDataPoints.toArray(new DataPoint[0]);
    }

    public static DataPoint[] dataPoints(String[] arr) {
        List<GenericDataPoint<String>> genericDataPoints = new ArrayList<>();

        for (String string : arr) {
            genericDataPoints.add(new GenericDataPoint<>(string));
        }

        return genericDataPoints.toArray(new DataPoint[0]);
    }

}
