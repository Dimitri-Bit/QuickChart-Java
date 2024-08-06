package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.v2.AxesOption;
import me.dimitri.model.options.v2.GridLinesOption;

@Builder
@Getter
@Setter
public class AxesOptionImpl implements AxesOption {

    private final GridLinesOption gridLines;

}
