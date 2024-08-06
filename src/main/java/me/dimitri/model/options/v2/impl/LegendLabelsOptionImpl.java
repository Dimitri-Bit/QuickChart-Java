package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.LegendLabelsOption;

@Builder
@Getter
@Setter
public class LegendLabelsOptionImpl implements LegendLabelsOption {

    private Number boxWidth;
    private Number fontSize;
    private String fontStyle;
    private String fontColor;
    private String fontFamily;
    private Number padding;
    private Boolean usePointStyle;
    // Functions
    private String generateLabels;
    private String filter;

}
