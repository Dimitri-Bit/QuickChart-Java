package me.dimitri.model.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.Chart;
import me.dimitri.model.ChartData;

@Builder
@Getter
@Setter
public class ChartImpl implements Chart {

    private String type;
    private ChartData data;

}
