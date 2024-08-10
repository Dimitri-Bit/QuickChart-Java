package me.dimitri;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dimitri.exception.ChartPostException;
import me.dimitri.model.ChartObject;
import me.dimitri.model.chart.Chart;
import me.dimitri.serializer.ChartSerializer;
import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.net.URIBuilder;

import java.io.File;
import java.io.IOException;

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

    private String host = "quickchart.io";
    private String path = "chart";
    private String schema = "http";

    /**
     * Generate a URL to display your chart
     *
     * @return URL that returns your chart
     */
    public String getUrl() {
        URIBuilder builder = buildURI();

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

    /**
     *
     * @return Your QuickChart object in JSON form
     */
    public String toJson() {
        return ChartSerializer.serialize(this);
    }

    /**
     * Save your chart as a PNG
     *
     * @param path File path, make sure to include the file name with .png
     * @throws IOException Thrown when file could not be created
     */
    public void toFile(String path) throws IOException {
        byte[] bytes = postChart();
        FileUtils.writeByteArrayToFile(new File(path), bytes);
    }

    /**
     * POST your chart and get it in a byte array
     *
     * @return Your chart image in a byte array
     * @throws IOException When HTTP request is not successful
     * @throws ChartPostException When the API endpoint doesn't return an okay response
     */
    public byte[] postChart() throws IOException, ChartPostException {
        String url = buildURI().toString();

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            ClassicHttpRequest httpPost = ClassicRequestBuilder.post(url)
                    .setEntity(this.toJson())
                    .setHeader("Content-Type", "application/json")
                    .build();

            CloseableHttpResponse response = client.execute(httpPost);
            validateResponse(response);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toByteArray(entity);
        }
    }

    private void validateResponse(CloseableHttpResponse response) throws ChartPostException {
        int status = response.getCode();
        if (status != 200) {
            String message = getErrorHeader(response);
            throw new ChartPostException(String.format("Unable to POST chart, status code %d, error message: %s", status, message));
        }
    }

    private String getErrorHeader(CloseableHttpResponse response) {
        String headerName = "X-quickchart-error";
        if (response.containsHeader(headerName)) {
            return response.getFirstHeader(headerName).getValue();
        } else {
            return "No API endpoint message received";
        }
    }

    private URIBuilder buildURI() {
        return new URIBuilder()
                .setScheme(this.schema)
                .setHost(this.host)
                .setPath(this.path);
    }

}