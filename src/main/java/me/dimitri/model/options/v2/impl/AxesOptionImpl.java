package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.AxesOption;
import me.dimitri.model.options.v2.GridLinesOption;
import me.dimitri.model.options.v2.ScaleLabelOption;

@Builder
@Getter
@Setter
public class AxesOptionImpl implements AxesOption {

    private String id;
    private String type;
    private String position;
    private Boolean display;
    private Boolean stacked;
    private Number min;
    private Number max;
    private GridLinesOption gridLines;
    private ScaleLabelOption scaleLabel;

}
