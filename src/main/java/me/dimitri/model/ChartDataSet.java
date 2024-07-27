package me.dimitri.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ChartDataSet {

    private String type;
    private String label;
    private String backgroundColor;
    private String borderColor;
    private String color;
    private String yAxisID;
    private String xAxisID;
    private Boolean fill;
    private Boolean hidden;
    private Number borderWidth;
    private Number lineTension;
    private Number value;
    private Object[] data;

}
