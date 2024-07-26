package me.dimitri.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChartData {

    private String[] labels;
    private ChartDatasets[] datasets;

}
