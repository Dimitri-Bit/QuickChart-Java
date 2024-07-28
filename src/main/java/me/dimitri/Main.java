package me.dimitri;

import me.dimitri.model.Chart;
import me.dimitri.model.ChartData;
import me.dimitri.model.ChartDataSet;
import me.dimitri.model.DataPoint;
import me.dimitri.model.impl.ChartDataImpl;
import me.dimitri.model.impl.ChartDataSetImpl;
import me.dimitri.model.impl.ChartImpl;
import me.dimitri.model.impl.datapoint.GenericDataPoint;
import me.dimitri.serializer.ChartSerializer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        ChartDataSet dataSet1 = ChartDataSetImpl.builder()
                .type("line")
                .label("Dataset 1")
                .borderColor("rgb(54, 162, 235)")
                .borderWidth(2)
                .fill(false)
                .data(dataPoints(new Integer[]{-42, 73, -69, -94, -81, 18, 87}))
                .build();

        ChartDataSet dataSet3 = ChartDataSetImpl.builder()
                .label("Dataset 3")
                .backgroundColor("rgb(75, 192, 192)")
                .data(dataPoints(new Integer[]{93, 60, -15, 77, -59, 82, -44}))
                .build();

        ChartData data = ChartDataImpl.builder()
                .labels(new String[]{"January", "February", "March", "April", "May", "June", "July"})
                .datasets(new ChartDataSet[]{dataSet1, dataSet3})
                .build();

        Chart chart = ChartImpl.builder()
                .type("bar")
                .data(data)
                .build();

        ChartSerializer serializer = new ChartSerializer();
        System.out.println(serializer.serialize(chart));
    }

    private static DataPoint[] dataPoints(Integer[] arr) {
        List<GenericDataPoint<Integer>> genericDataPoints = new ArrayList<>();

        for (Integer integer : arr) {
            genericDataPoints.add(new GenericDataPoint<>(integer));
        }

        return genericDataPoints.toArray(new DataPoint[0]);
    }
}