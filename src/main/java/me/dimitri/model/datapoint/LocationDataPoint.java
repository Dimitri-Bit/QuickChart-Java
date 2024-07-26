package me.dimitri.model.datapoint;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LocationDataPoint {

    private Number x;
    private Number y;
    private Number r;

}
