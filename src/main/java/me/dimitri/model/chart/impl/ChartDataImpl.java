package me.dimitri.model.chart.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.chart.ChartData;
import me.dimitri.model.chart.ChartDataSet;

@Builder
@Getter
@Setter
public class ChartDataImpl implements ChartData {

    private String[] labels;
    private ChartDataSet[] datasets;

}
