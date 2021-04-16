package commons.view.filters;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NumberSpinnerParameters {
    private final Number initValue;
    private final Comparable min;
    private final Comparable max;
    private final Number step;
}
