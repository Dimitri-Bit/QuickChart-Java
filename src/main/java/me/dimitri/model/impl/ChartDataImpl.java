package me.dimitri.model.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.ChartData;
import me.dimitri.model.ChartDataSet;

@Builder
@Getter
@Setter
public class ChartDataImpl implements ChartData {

    private String[] labels;
    private ChartDataSet[] datasets;

}
