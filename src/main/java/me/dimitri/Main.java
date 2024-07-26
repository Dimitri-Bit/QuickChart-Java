package me.dimitri;

import me.dimitri.model.Chart;
import me.dimitri.model.ChartData;
import me.dimitri.model.ChartDataSet;
import me.dimitri.model.datapoint.SankeyDataPoint;
import me.dimitri.serializer.ChartSerializer;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        SankeyDataPoint dataPoint1 = SankeyDataPoint.builder()
                .from("Step A")
                .to("Step B")
                .flow(10)
                .build();

        SankeyDataPoint dataPoint2 = SankeyDataPoint.builder()
                .from("Step A")
                .to("Step C")
                .flow(5)
                .build();

        SankeyDataPoint dataPoint3 = SankeyDataPoint.builder()
                .from("Step B")
                .to("Step C")
                .flow(10)
                .build();

        SankeyDataPoint dataPoint4 = SankeyDataPoint.builder()
                .from("Step D")
                .to("Step C")
                .flow(7)
                .build();

        ChartDataSet dataSet = ChartDataSet.builder()
                .data(new SankeyDataPoint[]{dataPoint1, dataPoint2, dataPoint3, dataPoint4})
                .build();

        ChartData data = ChartData.builder()
                .datasets(new ChartDataSet[]{dataSet})
                .build();

        Chart chart = Chart.builder()
                .type("sankey")
                .data(data)
                .build();

        ChartSerializer serializer = new ChartSerializer();
        System.out.println(serializer.serializeChartObject(chart));
    }
}