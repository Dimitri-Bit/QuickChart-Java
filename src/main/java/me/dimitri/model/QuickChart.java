package me.dimitri.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.dimitri.serializer.ChartSerializer;

@Builder
@Getter
@Setter
public class QuickChart implements ChartObject {

    private Chart chart;
    private Integer width;
    private Integer height;
    private Integer devicePixelRatio;
    private String backgroundColor;
    private String version;
    private String format;
    private String encoding;

    public String toJson() throws IllegalAccessException {
        return ChartSerializer.serialize(this);
    }
}