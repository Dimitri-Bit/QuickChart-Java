package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.LegendLabelsOption;
import me.dimitri.model.options.v2.LegendOption;

@Builder
@Getter
@Setter
public class LegendOptionImpl implements LegendOption {

    private Boolean display;
    private String position;
    private String align;
    private Boolean fullWidth;
    private Boolean reverse;
    private Boolean rtl;
    private String textDirection;
    private LegendLabelsOption labels;

}
