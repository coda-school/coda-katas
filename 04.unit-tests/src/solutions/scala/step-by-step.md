# Step-by-step - Test it or Die Trying (35')
## Calculator
- We start by a first simple test case : `9 + 3 = 12`
  - We create a `CalculatorTests` class that extends `AnyFunSuite`
  - We use the 3A pattern to describe it
  - We assert the expected result

```scala
class CalculatorTests
  extends AnyFunSuite {

  test("calculator should support add") {
    // Arrange
    val calculator = new Calculator()

    // Act
    val result = calculator.calculate(9, 3, operator = Calculator.add)

    // Assert
    assert(result.success.value == 12)
  }
}
```
- Now that we have 1 test case we can repeat for others
```text
✅ 9 + 3 = 12
3 x 76 = 228
9 / 3 = 3
9 - 3 = 9
Unsupported operator should fail
```

- Other test cases
```scala
  test("calculator should support multiply") {
    // Arrange
    val calculator = new Calculator()

    // Act
    val result = calculator.calculate(3, 76, operator = Calculator.multiply)

    // Assert
    assert(result.success.value == 228)
  }

  test("calculator should support divide") {
    // Arrange
    val calculator = new Calculator()

    // Act
    val result = calculator.calculate(9, 3, operator = Calculator.divide)

    // Assert
    assert(result.success.value == 3)
  }

  test("calculator should support subtract") {
    // Arrange
    val calculator = new Calculator()

    // Act
    val result = calculator.calculate(9, 3, operator = Calculator.subtract)

    // Assert
    assert(result.success.value == 6)
  }
```
- Update our test cases
```text
✅ 9 + 3 = 12
✅ 3 x 76 = 228
✅ 9 / 3 = 3
✅ 9 - 3 = 9
Unsupported operator should fail
```

- Let's implement the failure test
```scala
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
```

### Refactor the tests
> You should pay the same attention to your tests as to your production code.

- Let's remove duplication
  - assertion code is duplicated
  - we instantiate 1 `Calculator` per test, but we can use the same (no state inside)
- In `scalatest` for this kind of test we can use `Parameterized tests`
  - We use `TableDrivenPropertyChecks` trait for that  (`forAll`)
    - Documentation available [here](https://www.scalatest.org/user_guide/table_driven_property_checks)
  - We define a `Table` that hosts our test cases
  - We adapt the test method as well to deal with this table and make assertions on each row

```scala
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
```

> There is one Edge case not yet supported, what happens if we divide by 0? 

```text
✅ 9 + 3 = 12
✅ 3 x 76 = 228
✅ 9 / 3 = 3
✅ 9 - 3 = 9
✅ Unsupported operator should fail
Divide by 0 should fail
```

## Time
- Write at least one test for it

```scala
```scala
object TimeUtility {
  def timeOfDay: String = {
    LocalTime.now() match {
      case night if night.getHour >= 0 && night.getHour < 6 => "Night"
      case morning if morning.getHour >= 6 && morning.getHour < 12 => "Morning"
      case afternoon if afternoon.getHour >= 12 && afternoon.getHour < 18 => "Afternoon"
      case _ => "Evening"
    }
  }
}
```

- Here is the simplest test we can write
  - Which problem will you encounter?
```scala
class TimeUtilityTests
  extends AnyFlatSpec
    with Matchers {

  "time description" should "be Afternoon" in {
    TimeUtility.timeOfDay should be("Afternoon")
  }
}
```

- This test is not repeatable because the design is coupled to `LocalTime.now()`
    - We need to isolate it to be able to test this unitary
    - A few solutions here :
        - Pass a `LocalTime` as method arg
        - Pass a `Clock` which will provide a `time()`method that we will be able to substitute
        - Pas a function `clock: Unit => LocalTime`
- Identify some examples
```text
6:05AM -> Morning
1:00AM -> Night
1PM -> Afternoon
11PM -> Evening
```
        
### Use a Clock trait
- Adapt the `TimeUtility` to inject a `Clock` collaborator
  - Generate your code from usage

```scala
object TimeUtility {
  def timeOfDay(clock: Clock) : String = {
    clock.time() match {
      case night if night.getHour >= 0 && night.getHour < 6 => "Night"
      case morning if morning.getHour >= 6 && morning.getHour < 12 => "Morning"
      case afternoon if afternoon.getHour >= 12 && afternoon.getHour < 18 => "Afternoon"
      case _ => "Evening"
    }
  }
}

trait Clock {
  def time(): LocalTime = LocalTime.now()
}
```

- Now our code has no `hardcoded` dependency anymore
- We need to adapt our tests
  - How to provide a `Clock` in the given state for our test cases?
  - `Test Doubles` is our solution

- To use TestDoubles we need to add `with MockFactory` on our test class (AsyncMockFactory when you work with Future)
- We implement our first test case

```scala
  private val clockStub: Clock = stub[Clock]

  "at 6 AM" should "be Morning" in {
    // Define the result of the call of the method time
    (clockStub.time _).when().returns(LocalTime.of(6, 5))
    TimeUtility.timeOfDay(clockStub) should be("Morning")
  }
```

```text
✅ 6:05AM -> Morning
1:00AM -> Night
1PM -> Afternoon
11PM -> Evening
```

- Implement others
```scala
class TimeUtilityTests
  extends AnyFlatSpec
    with Matchers
    with MockFactory {

  private val clockStub: Clock = stub[Clock]

  "at 6 AM" should "be Morning" in {
    (clockStub.time _).when().returns(LocalTime.of(6, 5))
    TimeUtility.timeOfDay(clockStub) should be("Morning")
  }

  "at 1 PM" should "be Afternoon" in {
    (clockStub.time _).when().returns(LocalTime.of(13, 0))
    TimeUtility.timeOfDay(clockStub) should be("Afternoon")
  }

  "at 2 AM" should "be Night" in {
    (clockStub.time _).when().returns(LocalTime.of(1, 0))
    TimeUtility.timeOfDay(clockStub) should be("Night")
  }

  "at 11 PM" should "be Evening" in {
    (clockStub.time _).when().returns(LocalTime.of(23, 0))
    TimeUtility.timeOfDay(clockStub) should be("Evening")
  }
}
```

- Alternatively we could use `TableDrivenPropertyChecks` as well

```scala
class TimeUtilityTests
  extends AnyFlatSpec
    with Matchers
    with MockFactory
    with TableDrivenPropertyChecks {

  "TimeUtility" should "return a description at any time" in {
    forAll(testCases) {
      (hour, expectedDescription) =>
        val clockStub: Clock = stub[Clock]
        (clockStub.time _).when().returns(LocalTime.of(hour, 0))

        TimeUtility.timeOfDay(clockStub) should be(expectedDescription)
    }
  }
}

object TimeUtilityTests {
  private val testCases =
    Table(
      ("hour", "expectedDescription"),
      (0, "Night"),
      (0, "Night"),
      (4, "Night"),
      (6, "Morning"),
      (9, "Morning"),
      (12, "Afternoon"),
      (17, "Afternoon"),
      (18, "Evening"),
      (23, "Evening")
    )
}
```