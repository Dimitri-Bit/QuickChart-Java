package me.dimitri.model.chart.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.chart.ChartDataSet;
import me.dimitri.model.chart.DataPoint;

@Builder
@Getter
@Setter
public class ChartDataSetImpl implements ChartDataSet {


    private String backgroundColor;
    private String borderCapStyle;
    private String borderColor;
    private Number[] borderDash;
    private Number borderDashOffset;
    private String borderJoinStyle;
    private Number borderWidth;
    private String cubicInterpolationMode;
    private Number clip;
    private Boolean fill;
    private String label;
    private Number lineTension;
    private Number order;
    private String pointBackgroundColor;
    private String pointBorderColor;
    private Number pointBorderWidth;
    private Number pointHitRadius;
    private Number pointRadius;
    private Number pointRotation;
    private String pointStyle;
    private Boolean showLine;
    private Boolean spanGaps;
    private Boolean steppedLine;
    private String xAxisID;
    private String yAxisID;
    private String type;
    private String color;
    private Boolean hidden;
    private Number value;
    private DataPoint[] data;

}
