package me.dimitri.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dimitri.serializer.ChartSerializer;
import org.apache.hc.core5.net.URIBuilder;

@Getter
@Setter
@NoArgsConstructor
public class QuickChart implements ChartObject {

    private Chart chart;
    private Integer width;
    private Integer height;
    private Integer devicePixelRatio;
    private String backgroundColor;
    private String version;

    private String schema = "http";
    private String host = "quickchart.io";
    private String path = "chart";

    public String toJson() {
        return ChartSerializer.serialize(this);
    }

    public String getUrl() {
        URIBuilder builder = new URIBuilder()
                .setScheme(this.schema)
                .setHost(this.host)
                .setPath(this.path);

        if (width != null)
            builder.addParameter("width", width.toString());

        if (height != null)
            builder.addParameter("height", height.toString());

        if (devicePixelRatio != null)
            builder.addParameter("devicePixelRatio", devicePixelRatio.toString());

        if (backgroundColor != null && !backgroundColor.isEmpty())
            builder.addParameter("backgroundColor", backgroundColor);

        if (version != null && !version.isEmpty())
            builder.addParameter("version", version);

        if (chart != null) {
            String chartString = ChartSerializer.serialize(chart);
            builder.addParameter("chart", chartString);
        }

        return builder.toString();
    }

}