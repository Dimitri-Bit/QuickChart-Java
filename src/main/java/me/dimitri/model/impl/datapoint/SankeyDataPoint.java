package me.dimitri.model.impl.datapoint;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.DataPoint;

@Builder
@Getter
@Setter
public class SankeyDataPoint implements DataPoint {

    private String from;
    private String to;
    private Number flow;

}
