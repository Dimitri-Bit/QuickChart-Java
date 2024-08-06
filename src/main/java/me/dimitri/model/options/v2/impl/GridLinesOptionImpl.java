package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.GridLinesOption;

@Builder
@Getter
@Setter
public class GridLinesOptionImpl implements GridLinesOption {

    private Boolean display;
    private Boolean circular;
    private String color;
    private Number[] borderDash;
    private Number borderDashOffset;
    private Number lineWidth;
    private Boolean drawBorder;
    private Boolean drawOnChartArea;
    private Boolean drawTicks;
    private Number tickMarkLength;
    private Number zeroLineWidth;
    private String zeroLineColor;
    private Number[] zeroLineBorderDash;
    private Number zeroLineBorderDashOffset;
    private Boolean offsetGridLines;
    private Number z;

}
