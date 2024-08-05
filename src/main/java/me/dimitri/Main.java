package me.dimitri;

import me.dimitri.model.chart.Chart;
import me.dimitri.model.chart.ChartData;
import me.dimitri.model.chart.ChartDataSet;
import me.dimitri.model.chart.DataPoint;
import me.dimitri.model.QuickChart;
import me.dimitri.model.chart.impl.ChartDataImpl;
import me.dimitri.model.chart.impl.ChartDataSetImpl;
import me.dimitri.model.chart.impl.ChartImpl;
import me.dimitri.model.chart.impl.datapoint.GenericDataPoint;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
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

        QuickChart quickChart = new QuickChart();
        quickChart.setChart(chart);
        quickChart.setVersion("2");

        System.out.println(quickChart.getUrl("quickchart.io", "chart", "http"));
    }

    private static DataPoint[] dataPoints(Integer[] arr) {
        List<GenericDataPoint<Integer>> genericDataPoints = new ArrayList<>();

        for (Integer integer : arr) {
            genericDataPoints.add(new GenericDataPoint<>(integer));
        }

        return genericDataPoints.toArray(new DataPoint[0]);
    }
}