package me.dimitri;

import me.dimitri.model.Chart;
import me.dimitri.model.Data;
import me.dimitri.model.Datasets;
import me.dimitri.serializer.ChartConverter;

public class Main {

    public static void main(String[] args) {

        Datasets datasets = new Datasets();
        datasets.setData(new String[]{"70"});
        datasets.setBackgroundColor("green");

        Data data = new Data();
        data.setDatasets(new Datasets[]{datasets});

        Chart chart = new Chart();
        chart.setType("radialGauge");
        chart.setData(data);

        ChartConverter chartConverter = new ChartConverter();

        try {
            System.out.println(chartConverter.convertToJson(chart));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

}