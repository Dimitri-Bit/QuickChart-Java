package me.dimitri.model.chart.impl.datapoint;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.chart.DataPoint;

@Builder
@Getter
@Setter
public class LocationDataPoint implements DataPoint {

    private Number x;
    private Number y;
    private Number r;
    private String label;

}
