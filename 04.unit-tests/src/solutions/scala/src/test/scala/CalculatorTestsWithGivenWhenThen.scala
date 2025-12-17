import Calculator._
import org.scalatest.GivenWhenThen
import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalatest.funsuite.AnyFunSuite

class CalculatorTestsWithGivenWhenThen
  extends AnyFunSuite
    with GivenWhenThen{

  test("calculator should support add") {
    // Arrange
    Given("two operands 9 and 3")
    val calculator = new Calculator()
    val firstOperand = 9
    val secondOperand = 3

    // Act
    When("I want to add them")
    val result = calculator.calculate(firstOperand, secondOperand, add)

    // Assert
    Then("I get 12")
    assert(result.success.value == 12)
  }

  test("calculator should support multiply") {
    // Arrange
    Given("two operands 3 and 76")
    val calculator = new Calculator()
    val firstOperand = 3
    val secondOperand = 76

    // Act
    When("I want to multiply them")
    val result = calculator.calculate(firstOperand, secondOperand, multiply)

    // Assert
    Then("I get 228")
    assert(result.success.value == 228)
  }

  test("calculator should support divide") {
    // Arrange
    Given("two operands 9 and 3")
    val calculator = new Calculator()
    val firstOperand = 9
    val secondOperand = 3

    // Act
    When("I want to divide them")
    val result = calculator.calculate(firstOperand, secondOperand, divide)

    // Assert
    Then("I get 3")
    assert(result.success.value == 3)
  }

  test("calculator should support subtract") {
    // Arrange
    Given("two operands 9 and 3")
    val calculator = new Calculator()
    val firstOperand = 9
    val secondOperand = 3

    // Act
    When("I want to subtract them")
    val result = calculator.calculate(firstOperand, secondOperand, subtract)

    // Assert
    Then("I get 6")
    assert(result.success.value == 6)
  }

  test("calculator should fail when operator not supported") {
    val calculator = new Calculator()
    assert(
      calculator
        .calculate(9, 3, operator = "UnsupportedOperator")
        .failure
        .exception
        .getMessage == "Not supported operator"
    )
  }
}
