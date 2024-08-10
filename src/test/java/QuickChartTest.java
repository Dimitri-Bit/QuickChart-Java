import me.dimitri.QuickChart;
import me.dimitri.model.chart.Chart;
import me.dimitri.model.chart.ChartData;
import me.dimitri.model.chart.ChartDataSet;
import me.dimitri.model.chart.impl.ChartDataImpl;
import me.dimitri.model.chart.impl.ChartDataSetImpl;
import me.dimitri.model.chart.impl.ChartImpl;
import me.dimitri.model.options.Options;
import me.dimitri.model.options.v2.LegendOption;
import me.dimitri.model.options.v2.impl.LegendOptionImpl;
import me.dimitri.model.options.v2.impl.OptionsImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static me.dimitri.util.DataPointHelper.dataPoints;

class QuickChartTest {

    @Test
    void toJsonTest() {
        QuickChart quickChart = new QuickChart();
        quickChart.setChart(makeChart());

        String expectedJson = "{\"chart\":{\"type\":\"line\",\"data\":{\"labels\":[\"2016\",\"2017\",\"2018\",\"2019\",\"2020\"],\"datasets\":[{\"label\":\"Dollars\",\"data\":[1000,1234,2020,2005,1300]},{\"label\":\"Users\",\"data\":[50,150,250,350,400]}]},\"options\":{\"legend\":{\"display\":true,\"position\":\"right\",\"align\":\"start\"}}},\"host\":\"quickchart.io\",\"path\":\"chart\",\"schema\":\"http\"}";
        String json = quickChart.toJson();
        Assertions.assertEquals(expectedJson, json);
    }

    Chart makeChart() {
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

        return ChartImpl.builder()
                .type("line")
                .data(data)
                .options(options)
                .build();
    }

}
