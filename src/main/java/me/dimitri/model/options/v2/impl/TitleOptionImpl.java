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
    private String text;

}
