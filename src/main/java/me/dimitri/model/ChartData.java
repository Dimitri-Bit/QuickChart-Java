package me.dimitri.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChartData {

    private String[] labels;
    private ChartDatasets[] datasets;

}
