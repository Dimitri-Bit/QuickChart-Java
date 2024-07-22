package me.dimitri.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChartDatasets {

    private String type;
    private String label;
    private String backgroundColor;
    private String borderColor;
    private String color;
    private Boolean fill;
    private Boolean hidden;
    private Integer borderWidth;
    private Integer value;
    private Object[] data;

}
