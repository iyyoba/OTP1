import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerOn() {
        System.out.println("@BeforeAll Power ON (before the first test)");
        calculator.powerOn();
    }

    @AfterAll
    public static void testPowerOff() {
        System.out.println("@AfterAll Power OFF (all tests executed).");
        calculator.powerOff();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        System.out.println("  Reset calculator.");
        calculator.reset();
        assertEquals(0, calculator.getResult(), "Reset failed");
    }

    @ParameterizedTest(name = "square({0}) = {1}")
    @CsvSource({
            "2, 4",
            "4, 16",
            "5, 25"
    })
    public void testSquare(int input, int expected) {
        calculator.square(input);
        assertEquals(expected, calculator.getResult(), "Squaring number " + input + " is incorrect");
    }

    @ParameterizedTest(name = "squareRoot({0}) = {1}")
    @CsvSource({
            "2, 1.41421356237",   // (int) Math.sqrt(2) = 1
            "4, 2",
            "9, 3",
            "16, 4"
    })
    public void testSquareRoot(double input, double expected) {
        calculator.squareRoot(input);
        assertEquals(expected, calculator.getResult(), 0.0001, "Square root of " + input + " is incorrect");
    }

    @Test
    @DisplayName("Square root of negative number throws exception")
    public void testSquareRootNegative() {
        assertThrows(
                ArithmeticException.class,
                () -> calculator.squareRoot(-9),
                "Square root of negative number should throw ArithmeticException"
        );
    }
}
