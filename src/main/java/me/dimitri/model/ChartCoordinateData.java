package me.dimitri.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChartCoordinateData {

    private Number x;
    private Number y;
    private Number r;

}
