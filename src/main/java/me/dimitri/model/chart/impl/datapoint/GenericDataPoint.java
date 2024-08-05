package me.dimitri.model.chart.impl.datapoint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dimitri.model.chart.DataPoint;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericDataPoint<T> implements DataPoint {

    private T value;

}
