import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private static final double DELTA = 0.0001;

    // ---------- fahrenheitToCelsius Tests ----------

    @Test
    void testFahrenheitToCelsius_FreezingPoint() {
        assertEquals(0.0,
                TemperatureConverter.fahrenheitToCelsius(32),
                DELTA);
    }

    @Test
    void testFahrenheitToCelsius_BoilingPoint() {
        assertEquals(100.0,
                TemperatureConverter.fahrenheitToCelsius(212),
                DELTA);
    }

    @Test
    void testFahrenheitToCelsius_NegativeForty() {
        assertEquals(-40.0,
                TemperatureConverter.fahrenheitToCelsius(-40),
                DELTA);
    }

    // ---------- celsiusToFahrenheit Tests ----------

    @Test
    void testCelsiusToFahrenheit_FreezingPoint() {
        assertEquals(32.0,
                TemperatureConverter.celsiusToFahrenheit(0),
                DELTA);
    }

    @Test
    void testCelsiusToFahrenheit_BoilingPoint() {
        assertEquals(212.0,
                TemperatureConverter.celsiusToFahrenheit(100),
                DELTA);
    }

    @Test
    void testCelsiusToFahrenheit_NegativeForty() {
        assertEquals(-40.0,
                TemperatureConverter.celsiusToFahrenheit(-40),
                DELTA);
    }

    // ---------- isExtremeTemperature Tests ----------

    @Test
    void testIsExtremeTemperature_BelowLowerBound() {
        assertTrue(TemperatureConverter.isExtremeTemperature(-41));
    }

    @Test
    void testIsExtremeTemperature_AboveUpperBound() {
        assertTrue(TemperatureConverter.isExtremeTemperature(51));
    }

    @Test
    void testIsExtremeTemperature_AtLowerBoundary() {
        assertFalse(TemperatureConverter.isExtremeTemperature(-40));
    }

    @Test
    void testIsExtremeTemperature_AtUpperBoundary() {
        assertFalse(TemperatureConverter.isExtremeTemperature(50));
    }

    @Test
    void testIsExtremeTemperature_NormalValue() {
        assertFalse(TemperatureConverter.isExtremeTemperature(20));
    }

    // ---------- kelvinToCelsius Tests ----------

    @Test
    void testKelvinToCelsius_ZeroKelvin() {
        assertEquals(-273.15,
                TemperatureConverter.kelvinToCelsius(0),
                DELTA);
    }

    @Test
    void testKelvinToCelsius_FreezingPointWater() {
        assertEquals(0.0,
                TemperatureConverter.kelvinToCelsius(273.15),
                DELTA);
    }

    @Test
    void testKelvinToCelsius_RoomTemperature() {
        assertEquals(26.85,
                TemperatureConverter.kelvinToCelsius(300),
                DELTA);
    }
}