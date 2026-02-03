public class TemperatureConverter {

    /**
     Converts Fahrenheit to Celsius.
     Formula: (Fahrenheit - 32) * 5 / 9
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    /**
     Converts Celsius to Fahrenheit.
     Formula: (Celsius * 9 / 5) + 32
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    /**
      Checks if a Celsius temperature is extreme.
      Extreme if below -40°C or above 50°C.
     */
    public static boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }
}
