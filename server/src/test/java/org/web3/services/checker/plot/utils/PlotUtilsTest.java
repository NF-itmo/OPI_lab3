package org.web3.services.checker.plot.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@DisplayName("PlotUtils - определение четверти")
class PlotUtilsTest {

    @ParameterizedTest
    @DisplayName("Определение четверти для различных координат")
    @CsvSource({
            "1.0, 1.0, FIRST_QUADRANT",
            "0.5, 0.5, FIRST_QUADRANT",
            "-1.0, 1.0, FOURTH_QUADRANT",
            "-0.5, 0.5, FOURTH_QUADRANT",
            "-1.0, -1.0, THIRD_QUADRANT",
            "-0.5, -0.5, THIRD_QUADRANT",
            "1.0, -1.0, SECOND_QUADRANT",
            "0.5, -0.5, SECOND_QUADRANT",
    })
    void testGetQuarter(float x, float y, String expectedQuarter) {
        PlotQuarters expected = PlotQuarters.valueOf(expectedQuarter);
        PlotQuarters actual = PlotUtils.getQuarter(x, y);
        assertEquals(
                expected,
                actual,
                String.format(
                        "Для координат (%.3f, %.3f) ожидается четверть %s, получен %s",
                        x, y, expected, actual
                )
        );
    }
}
