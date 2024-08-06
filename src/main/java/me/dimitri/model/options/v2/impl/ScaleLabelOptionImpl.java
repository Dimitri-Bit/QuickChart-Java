package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.ScaleLabelOption;

@Builder
@Getter
@Setter
public class ScaleLabelOptionImpl implements ScaleLabelOption {

    private Boolean display;
    private String labelString;
    private String lineHeight;
    private String fontColor;
    private String fontFamily;
    private Number fontSize;
    private String fontStyle;
    private Number padding;

}
