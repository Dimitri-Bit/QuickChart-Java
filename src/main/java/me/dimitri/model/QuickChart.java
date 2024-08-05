package me.dimitri.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dimitri.model.chart.Chart;
import me.dimitri.model.chart.ChartObject;
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

    public String toJson() {
        return ChartSerializer.serialize(this);
    }

    public String getUrl(String host, String path, String schema) {
        URIBuilder builder = new URIBuilder()
                .setScheme(schema)
                .setHost(host)
                .setPath(path);

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