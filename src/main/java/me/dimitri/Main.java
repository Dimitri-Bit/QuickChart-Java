package me.dimitri;

import me.dimitri.model.Chart;
import me.dimitri.model.ChartData;
import me.dimitri.model.ChartDatasets;
import me.dimitri.serializer.ChartConverter;

public class Main {

    public static void main(String[] args) {

        ChartDatasets datasets = new ChartDatasets();
        datasets.setData(new String[]{"70"});
        datasets.setBackgroundColor("green");

        ChartData data = new ChartData();
        data.setDatasets(new ChartDatasets[]{datasets});

        Chart chart = new Chart();
        chart.setType("radialGauge");
        chart.setData(data);

        ChartConverter chartConverter = new ChartConverter();
        System.out.println(chartConverter.convertToJson(chart));

    }

}