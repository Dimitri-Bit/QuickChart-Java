package me.dimitri;

import me.dimitri.model.Chart;
import me.dimitri.model.ChartCoordinateData;
import me.dimitri.model.ChartData;
import me.dimitri.model.ChartDatasets;
import me.dimitri.serializer.ChartSerializer;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        ChartCoordinateData cords1 = ChartCoordinateData.builder()
                .x(2)
                .y(4)
                .build();

        ChartDatasets datasets = ChartDatasets.builder()
                .label("Data 1")
                .data(new ChartCoordinateData[]{cords1})
                .build();

        ChartData chartData = ChartData.builder()
                .datasets(new ChartDatasets[]{datasets})
                .build();

        Chart chart = Chart.builder()
                .type("scatter")
                .data(chartData)
                .build();

        ChartSerializer serializer = new ChartSerializer();
        System.out.println(serializer.serializeChartObject(chart));

        // TODO: look into Number class
    }
}