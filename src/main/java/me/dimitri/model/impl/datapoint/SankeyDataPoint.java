package me.dimitri.model.impl.datapoint;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.ChartObject;

@Builder
@Getter
@Setter
public class SankeyDataPoint implements ChartObject {

    private String from;
    private String to;
    private Number flow;

}
