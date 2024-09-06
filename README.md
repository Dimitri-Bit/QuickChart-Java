# About
Unofficial Java API Wrapper for [quickchart.io](quickchart.io/)

# Usage
This entire library is basically just loosely coupled Java objects that directly repressent ChartJS properties.
Lets go over a quick example.

A QuickChart or ChartJS config that looks like this:

```json
{
   "type":"bar",
   "data":{
      "labels":[
         "Q1",
         "Q2",
         "Q3",
         "Q4"
      ],
      "datasets":[
         {
            "label":"Users",
            "data":[
               50,
               60,
               70,
               180
            ]
         },
         {
            "label":"Revenue",
            "data":[
               100,
               200,
               300,
               400
            ]
         }
      ]
   }
}
```

Can be represented in Java like this:

```java
import me.dimitri.model.chart.Chart;
import me.dimitri.model.chart.ChartData;
import me.dimitri.model.chart.ChartDataSet;
import me.dimitri.model.chart.DataPoint;
import me.dimitri.model.chart.impl.ChartDataImpl;
import me.dimitri.model.chart.impl.ChartDataSetImpl;
import me.dimitri.model.chart.impl.ChartImpl;
import me.dimitri.util.DataPointHelper;

public class Main {

    public static void main(String[] args) {
        DataPoint[] dataPoint1 = DataPointHelper.dataPoints(new Integer[]{50, 60, 70, 180});
        ChartDataSet dataSet1 = ChartDataSetImpl.builder()
                .label("Users")
                .data(dataPoint1)
                .build();

        DataPoint[] dataPoint2 = DataPointHelper.dataPoints(new Integer[]{100, 200, 300, 400});
        ChartDataSet dataSet2 = ChartDataSetImpl.builder()
                .label("Revenue")
                .data(dataPoint2)
                .build();

        ChartData chartData = ChartDataImpl.builder()
                .labels(new String[]{"Q1", "Q2", "Q3", "Q4"})
                .datasets(new ChartDataSet[]{dataSet1, dataSet2})
                .build();

        Chart chart = ChartImpl.builder()
                .type("bar")
                .data(chartData)
                .build();
    }
}
```

It is much more verbose than just using string concatenation; however, this approach provides type safety and makes it easier to programmatically load data, while also reducing the likelihood of errors.
