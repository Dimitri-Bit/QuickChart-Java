package me.dimitri.model.datapoint;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SankeyDataPoint {

    private String from;
    private String to;
    private Number flow;

}
