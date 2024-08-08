package me.dimitri;

import me.dimitri.model.chart.Chart;
import me.dimitri.model.chart.ChartData;
import me.dimitri.model.chart.ChartDataSet;
import me.dimitri.model.chart.DataPoint;
import me.dimitri.model.chart.impl.ChartDataImpl;
import me.dimitri.model.chart.impl.ChartDataSetImpl;
import me.dimitri.model.chart.impl.ChartImpl;
import me.dimitri.model.chart.impl.datapoint.GenericDataPoint;
import me.dimitri.model.options.Options;
import me.dimitri.model.options.v2.LegendOption;
import me.dimitri.model.options.v2.impl.LegendOptionImpl;
import me.dimitri.model.options.v2.impl.OptionsImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LegendOption legend = LegendOptionImpl.builder()
                .display(true)
                .position("right")
                .align("start")
                .build();

        Options options = OptionsImpl.builder()
                .legend(legend)
                .build();

        ChartDataSet dataSet1 = ChartDataSetImpl.builder()
                .label("Dollars")
                .data(dataPoints(new Integer[]{1000, 1234, 2020, 2005, 1300}))
                .build();

        ChartDataSet dataSet2 = ChartDataSetImpl.builder()
                .label("Users")
                .data(dataPoints(new Integer[]{50, 150, 250, 350, 400}))
                .build();

        ChartData data = ChartDataImpl.builder()
                .labels(new String[]{"2016", "2017", "2018", "2019", "2020"})
                .datasets(new ChartDataSet[]{dataSet1, dataSet2})
                .build();

        Chart chart = ChartImpl.builder()
                .type("line")
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