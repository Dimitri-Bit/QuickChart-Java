package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.TitleOption;

@Builder
@Getter
@Setter
public class TitleOptionImpl implements TitleOption {

    private Boolean display;
    private String position;
    private Number fontSize;
    private String fontFamily;
    private String fontColor;
    private String fontStyle;
    private Number padding;
    private String lineHeight;
    private String text;

}
