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
    private String[] data;
    private Boolean fill;
    private String borderColor;
    private Integer borderWidth;

}
