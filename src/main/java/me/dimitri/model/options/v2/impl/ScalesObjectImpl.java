package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.AxesOption;
import me.dimitri.model.options.v2.ScalesOption;

@Builder
@Getter
@Setter
public class ScalesObjectImpl implements ScalesOption {

    private final AxesOption[] xAxes;
    private final AxesOption[] yAxes;

}
