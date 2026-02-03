import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    // Initialize an instance of TemperatureConverter
    private final TemperatureConverter converter = new TemperatureConverter();

    @Test
    void fahrenheitToCelsius_shouldConvertCorrectly() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), 0.001);
    }

    @Test
    void celsiusToFahrenheit_shouldConvertCorrectly() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), 0.001);
    }

    @Test
    void isExtremeTemperature_shouldReturnTrueForExtremeValues() {
        assertTrue(converter.isExtremeTemperature(-50));
        assertTrue(converter.isExtremeTemperature(60));
    }

    @Test
    void isExtremeTemperature_shouldReturnFalseForNormalValues() {
        assertFalse(converter.isExtremeTemperature(-10));
        assertFalse(converter.isExtremeTemperature(25));
        assertFalse(converter.isExtremeTemperature(50));
    }
}
