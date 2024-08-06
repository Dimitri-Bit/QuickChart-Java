package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.AxesOption;
import me.dimitri.model.options.v2.ScalesOption;
import me.dimitri.model.options.v2.TicksOption;

@Builder
@Getter
@Setter
public class ScalesOptionImpl implements ScalesOption {

    private AxesOption[] xAxes;
    private AxesOption[] yAxes;
    private TicksOption ticks;

}
