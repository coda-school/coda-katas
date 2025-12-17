package unit.tests.intro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTests {
    @Test
    void supportAdd() {
        // Arrange
        var calculator = new Calculator();

        // Act
        var result = calculator.calculate(9, 3, Calculator.ADD);

        // Assert
        assertEquals(12, result);
    }


    @Test
    void supportMultiply() {
        // Arrange
        var calculator = new Calculator();

        // Act
        var result = calculator.calculate(3, 76, Calculator.MULTIPLY);

        // Assert
        assertEquals(228, result);
    }

    @Test
    void supportDivide() {
        // Arrange
        var calculator = new Calculator();

        // Act
        var result = calculator.calculate(9, 3, Calculator.DIVIDE);

        // Assert
        assertEquals(3, result);
    }

    @Test
    void supportSubtract() {
        // Arrange
        var calculator = new Calculator();

        // Act
        var result = calculator.calculate(9, 3, Calculator.SUBTRACT);

        // Assert
        assertEquals(6, result);
    }

    @Test
    void failWhenOperatorNotSupported() {
        var calculator = new Calculator();
        var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculate(9, 3, "UnsupportedOperator"));
        assertEquals("Not supported operator", exception.getMessage());
    }
}