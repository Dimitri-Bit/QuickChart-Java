package me.dimitri.util;

import lombok.experimental.UtilityClass;
import me.dimitri.model.chart.DataPoint;
import me.dimitri.model.chart.impl.datapoint.GenericDataPoint;

import java.util.Arrays;

@UtilityClass
public class DataPointHelper {

    public static <T> DataPoint[] dataPoints(T[] arr) {
        return Arrays.stream(arr)
                .map(GenericDataPoint::new)
                .toArray(DataPoint[]::new);
    }

}
