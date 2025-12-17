import Calculator._
import RefactoredCalculatorTests.testCases
import org.scalatest.Assertion
import org.scalatest.TryValues.convertTryToSuccessOrFailure
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.prop.Tables.Table

import scala.util.Try

class RefactoredCalculatorTests
  extends AnyFunSuite
    with TableDrivenPropertyChecks {

  private val calculator = new Calculator()

  test("calculator should support supplied operators") {
    forAll(testCases) {
      (a, b, operator, expectedResult) =>
        assertSuccess(calculator.calculate(a, b, operator), expectedResult)
    }
  }

  private def assertSuccess(result: Try[Int], expectedValue: Int): Assertion =
    assert(result.success.value == expectedValue)

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

object RefactoredCalculatorTests {
  private val testCases =
    Table(
      ("a", "b", "operator", "expectedResult"),
      (9, 3, add, 12),
      (3, 76, multiply, 228),
      (9, 3, divide, 3),
      (9, 3, subtract, 6)
    )
}