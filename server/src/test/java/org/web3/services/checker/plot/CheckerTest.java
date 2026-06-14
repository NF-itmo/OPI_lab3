package org.web3.services.checker.plot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("Checker - проверка попадания точек в область")
class CheckerTest {
    private Checker checker;

    @BeforeEach
    void setUp() {
        checker = new Checker();
    }

    @ParameterizedTest(name = "Квадрант {0}: ({1}, {2}) с r={3} -> {4}")
    @DisplayName("Проверка точек во всех четвертях")
    @CsvSource({
        "1, 0.5, 1.0, 2, true",
        "1, 1.0, 2.0, 2, true",
        "1, 2.0, 1.0, 2, false",
        "1, 0.5, 3.0, 2, false",
        
        "2, -0.5, 1.0, 2, true",
        "2, -0.5, 1.0, 2, true",
        "2, -1.1, 1.0, 2, true",
        "2, -1.0, 1.0, 1, false",
        
        "3, -0.5, -0.5, 2, false",
        "3, -1.0, -1.0, 10, false",
        "3, -0.001, -0.001, 100, false",
        
        "4, 0.3, -0.3, 2, true",
        "4, 0.3, -0.3, 1, true",
        "4, 1.5, -1.5, 1, false",
        "4, 1.0, -1.0, 1, false"
    })
    void testAllQuadrants(int quadrant, float x, float y, float r, boolean expected) {
        assertEquals(
            expected,
            checker.check(x, y, r),
            String.format("Quadrant %d: (%.3f, %.3f) with r=%.3f", quadrant, x, y, r)
        );
    }
    
    @ParameterizedTest(name = "Точка ({0}, {1})")
    @DisplayName("Нулевое значения радиуса")
    @CsvSource({
        "0, 0, 0, true",
        "0, 0.001, 0, false",
    })
    void testVariousRadii(float x, float y, float r, boolean expected) {
        assertEquals(expected, checker.check(x, y, r));
    }

    @ParameterizedTest(name = "Точка ({0}, {1})")
    @DisplayName("Точки на осях координат")
    @CsvSource({
        "1.0, 0, 2, true",
        "0, 2.0, 2, true",
        "-1.0, 0, 2, true",
        "0, -1.0, 2, true",
        "0, 0, 1, true"
    })
    void testAxisPoints(float x, float y, float r, boolean expected) {
        assertEquals(expected, checker.check(x, y, r));
    }

    @ParameterizedTest(name = "Точка ({0}, {1})")
    @DisplayName("Проверка точности на границах")
    @CsvSource({
        "0.4999, 1.0, 1, true",
        "0.5001, 1.0, 1, false",
        "-0.499, 0.749, 1, true",
        "-0.501, 0.751, 1, true"
    })
    void testPrecision(float x, float y, float r, boolean expected) {
        assertEquals(expected, checker.check(x, y, r));
    }
}