package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.TicksOption;

@Builder
@Getter
@Setter
public class TicksOptionImpl implements TicksOption {

    private String backdropColor;
    private Number backdropPaddingX;
    private Number backdropPaddingY;
    private Boolean beginAtZero;
    private Number min;
    private Number max;
    private Number maxTicksLimit;
    private Number precision;
    private Number stepSize;
    private Number suggestedMax;
    private Number suggestedMin;
    private Boolean showLabelBackdrop;
    private Number sampleSize;
    private Boolean autoSkip;
    private Boolean autoSkipPadding;
    private Number labelOffset;
    private Number maxRotation;
    private Number minRotation;
    private Boolean mirror;
    private Number padding;
    private String type;
    private String[] labels;

}
