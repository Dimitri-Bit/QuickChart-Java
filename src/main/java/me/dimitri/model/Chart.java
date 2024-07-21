package me.dimitri.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Chart {

    private String type;
    private ChartData data;

}
