// java.laskin;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
/*
 * JUnit 5
 */

public class CalculatorTest { // The class name must end with Test

    // Fixture: all tests use the same calculator,
    // which is reset before each test.
    private Calculator calculator = new Calculator();
    private final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        calculator.reset();
    }

    // The test method name can be anything, as long as it has the @Test annotation
    @Test
    public void testAdd() {
        calculator.add(1);
        calculator.add(2);
        assertEquals(3, calculator.getResult(), "The sum of numbers 1 and 2 is incorrect");
    }

    @Test
    public void testSubtract() {
        calculator.add(10);
        calculator.subtract(2);
        assertEquals(8, calculator.getResult(), "The difference between 10 and 2 is incorrect");
    }

    @Test
    @DisplayName("Test division 8 / 2")
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult(), "Division 8/2 is incorrect");
    }

    // The correct result of this test is that division by zero throws an exception,
    // the caller then handles it in the desired way
    @Test
    @DisplayName("Test division by zero")
    public void testDivideByZero() {
        ArithmeticException exception =
                assertThrows(ArithmeticException.class, () -> calculator.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Test multiply ")
    public void testMultiply() {
        calculator.add(6);
        calculator.multiply(4);
        assertEquals(24, calculator.getResult(), "The product of numbers 6 and 4 is correct");
    }

    @Test
    public void testSquareRoot() {
        calculator.squareRoot(16);
        assertEquals(4, calculator.getResult(), "Square root of 16 should be 4");

        calculator.squareRoot(25);
        assertEquals(5, calculator.getResult(), "Square root of 25 should be 5");

        calculator.squareRoot(0);
        assertEquals(0, calculator.getResult(), "Square root of 0 should be 0");
    }

    @Test
    public void testSquareRootOfNegative() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.squareRoot(-9)
        );
        assertEquals("Cannot take square root of negative number", exception.getMessage());
    }
    @Test
    public void testPowerOnResetsResult() {
        // Simulate previous calculation
        calculator.add(10);
        calculator.subtract(5);
        assertEquals(5, calculator.getResult(), "Initial calculation is correct");

        // Power on should reset result
        calculator.powerOn();
        assertEquals(0, calculator.getResult(), "PowerOn should reset result to 0");
    }

    @Test
    public void testPowerOffDoesNothing() {
        // Just ensure calling powerOff does not throw an exception
        calculator.add(7);
        calculator.powerOff();
        assertEquals(7, calculator.getResult(), "PowerOff should not change the result");
    }
}

