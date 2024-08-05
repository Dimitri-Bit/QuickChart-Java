package me.dimitri.model.chart.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.chart.Chart;
import me.dimitri.model.chart.ChartData;

@Builder
@Getter
@Setter
public class ChartImpl implements Chart {

    private String type;
    private ChartData data;

}
