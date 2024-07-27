package me.dimitri;

import me.dimitri.model.Chart;
import me.dimitri.model.ChartData;
import me.dimitri.model.impl.ChartDataImpl;
import me.dimitri.model.impl.ChartImpl;
import me.dimitri.serializer.ChartSerializer;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        ChartData chartData = ChartDataImpl.builder()
                .labels(new String[]{"a", "b", "c"})
                .build();

        Chart chart = ChartImpl.builder()
                .type("bar")
                .data(chartData)
                .build();

        ChartSerializer serializer = new ChartSerializer();

        System.out.println(serializer.serializeChartObject(chart));
    }
}