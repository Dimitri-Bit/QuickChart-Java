package me.dimitri;

import me.dimitri.model.Chart;
import me.dimitri.model.ChartData;
import me.dimitri.model.ChartDatasets;
import me.dimitri.model.attribute.AdvancedData;
import me.dimitri.serializer.ChartSerializer;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        AdvancedData d1 = getData(1, 4, 9);
        AdvancedData d2 = getData(2 ,4 , 6);
        AdvancedData d3 = getData(3, 8, 30);
        AdvancedData d4 = getData(0, 10, 1);
        AdvancedData d5 = getData(10, 5, 5);

        AdvancedData[] dArr = {d1, d2, d3, d4, d5};

        ChartDatasets datasets = new ChartDatasets();
        datasets.setLabel("Data 1");
        datasets.setData(dArr);

        ChartData data = new ChartData();
        data.setDatasets(new ChartDatasets[]{datasets});

        Chart chart = new Chart();
        chart.setType("bubble");
        chart.setData(data);

        ChartSerializer chartSerializer = new ChartSerializer();
        System.out.println(chartSerializer.serializeChartObject(chart));
    }

    private static AdvancedData getData(int x, int y, int r) {
        AdvancedData advancedData = new AdvancedData();
        advancedData.setX(x);
        advancedData.setY(y);
        advancedData.setR(r);
        return advancedData;
    }
}