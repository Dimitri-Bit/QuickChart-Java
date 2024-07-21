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
    private String[] data;
    private Boolean fill;
    private Integer borderWidth;
    private Integer value;

}
