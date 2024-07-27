package me.dimitri.model.impl.datapoint;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.ChartObject;

@Builder
@Getter
@Setter
public class LocationDataPoint implements ChartObject {

    private Number x;
    private Number y;
    private Number r;

}
