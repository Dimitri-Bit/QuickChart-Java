package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.Options;
import me.dimitri.model.options.v2.LegendOption;
import me.dimitri.model.options.v2.ScalesOption;
import me.dimitri.model.options.v2.TitleOption;

@Builder
@Getter
@Setter
public class OptionsImpl implements Options {

    private TitleOption title;
    private ScalesOption scales;
    private LegendOption legend;
    private String circumference;
    private String rotation;
    private Number cutoutPercentage;

}
