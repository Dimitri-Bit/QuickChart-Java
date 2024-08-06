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
import me.dimitri.model.options.v2.AxesOption;
import me.dimitri.model.options.v2.GridLinesOption;
import me.dimitri.model.options.v2.ScalesOption;
import me.dimitri.model.options.v2.impl.AxesOptionImpl;
import me.dimitri.model.options.v2.impl.GridLinesOptionImpl;
import me.dimitri.model.options.v2.impl.OptionsImpl;
import me.dimitri.model.options.v2.impl.ScalesOptionImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        QuickChart quickChart = new QuickChart();
        quickChart.setChart(getChart());

        System.out.println(quickChart.toJson());

    }

    private static Chart getChart() {
        ChartDataSet dataSet = ChartDataSetImpl.builder()
                .data(dataPoints(new Integer[]{50, 60, 70, 180}))
                .label("Users")
                .build();

        ChartData data = ChartDataImpl.builder()
                .labels(new String[]{"Q1", "Q2", "Q3", "Q4"})
                .datasets(new ChartDataSet[]{dataSet})
                .build();

        return ChartImpl.builder()
                .data(data)
                .type("bar")
                .options(getOptions())
                .build();
    }

    private static Options getOptions() {
        GridLinesOption linesOption = GridLinesOptionImpl.builder()
                .display(false)
                .build();

        AxesOption yAxesOption = AxesOptionImpl.builder()
                .gridLines(linesOption)
                .build();

        ScalesOption scalesOption = ScalesOptionImpl.builder()
                .yAxes(new AxesOption[]{yAxesOption})
                .build();

        return OptionsImpl.builder()
                .scales(scalesOption)
                .build();
    }

    private static DataPoint[] dataPoints(Integer[] arr) {
        List<GenericDataPoint<Integer>> genericDataPoints = new ArrayList<>();

        for (Integer integer : arr) {
            genericDataPoints.add(new GenericDataPoint<>(integer));
        }

        return genericDataPoints.toArray(new DataPoint[0]);
    }
}