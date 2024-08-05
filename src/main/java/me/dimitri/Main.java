package me.dimitri;

import me.dimitri.model.QuickChart;
import me.dimitri.model.chart.Chart;
import me.dimitri.model.chart.ChartData;
import me.dimitri.model.chart.ChartDataSet;
import me.dimitri.model.chart.DataPoint;
import me.dimitri.model.chart.impl.ChartDataImpl;
import me.dimitri.model.chart.impl.ChartDataSetImpl;
import me.dimitri.model.chart.impl.ChartImpl;
import me.dimitri.model.chart.impl.datapoint.GenericDataPoint;
import me.dimitri.model.options.Options;
import me.dimitri.model.options.v2.TitleOption;
import me.dimitri.model.options.v2.impl.OptionsImpl;
import me.dimitri.model.options.v2.impl.TitleOptionImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TitleOption titleOption = TitleOptionImpl.builder()
                .display(true)
                .text("Basic Chart Title")
                .build();

        Options options = OptionsImpl.builder()
                .title(titleOption)
                .build();

        ChartDataSet dataSet = ChartDataSetImpl.builder()
                .label("Users")
                .data(dataPoints(new Integer[]{50, 60, 70, 180}))
                .build();

        ChartData data = ChartDataImpl.builder()
                .labels(new String[]{"Q1", "Q2", "Q3", "Q4"})
                .datasets(new ChartDataSet[]{dataSet})
                .build();

        Chart chart = ChartImpl.builder()
                .type("bar")
                .data(data)
                .options(options)
                .build();

        QuickChart quickChart = new QuickChart();
        quickChart.setChart(chart);

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