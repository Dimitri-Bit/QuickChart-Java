package me.dimitri.model.options.v2.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.model.options.Options;
import me.dimitri.model.options.v2.TitleOption;

@Builder
@Getter
@Setter
public class OptionsImpl implements Options {

    private TitleOption title;

}
