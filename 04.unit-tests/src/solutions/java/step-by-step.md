# Step-by-step - Test it or Die Trying (35')
## Calculator
- We start by a first simple test case : `9 + 3 = 12`
  - We create a `unit.tests.intro.CalculatorTests` class
  - We use the `3A` pattern to describe it
  - We assert the expected result

```java
@Test
void supportAdd() {
    // Arrange
    var calculator = new Calculator();

    // Act
    var result = calculator.calculate(9, 3, Calculator.ADD);

    // Assert
    assertEquals(12, result);
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
```java
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
```java
@Test
void failWhenOperatorNotSupported() {
    var calculator = new Calculator();
    var exception = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculate(9, 3, "UnsupportedOperator"));
    assertEquals("Not supported operator", exception.getMessage());
}
```

### Refactor the tests
> You should pay the same attention to your tests as to your production code.

- Let's remove duplication
  - assertion code is duplicated
  - we instantiate 1 `Calculator` per test, but we can use the same (no state inside)
- In `junit` for this kind of test we can use `Parameterized tests`
  - We need to add a new dependency for that 

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>${junit.version}</version>
    <scope>test</scope>
</dependency>
```
- We then define a Parameterized test using the dedicated annotation `@ParameterizedTest`
  - We need to supply data to it, we use `@MethodSource`
  - We then adapt the test method as well to take arguments `void supportOperations(int a, int b, String operator, int expectedResult)`
- We can use a library that simplify assertion readability as well called [assertJ](https://assertj.github.io/doc/)

```java
class unit.tests.intro.RefactoredCalculatorTests {
    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @MethodSource("supportedOperatorsTestCases")
    void supportOperations(int a, int b, String operator, int expectedResult) {
        assertThat(calculator.calculate(a, b, operator))
                .isEqualTo(expectedResult);
    }

    @Test
    void failWhenOperatorNotSupported() {
        assertThatThrownBy(() -> calculator.calculate(9, 3, "UnsupportedOperator"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not supported operator");
    }

    private static Stream<Arguments> supportedOperatorsTestCases() {
        return Stream.of(
                Arguments.of(9, 3, ADD, 12),
                Arguments.of(3, 76, MULTIPLY, 228),
                Arguments.of(9, 3, DIVIDE, 3),
                Arguments.of(9, 3, SUBTRACT, 6)
        );
    }
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

```java
public class TimeUtility {
    public String getTimeOfDay() {
        var time = LocalTime.now();

        if (time.getHour() < 6) {
            return "Night";
        } else if (time.getHour() < 12) {
            return "Morning";
        } else if (time.getHour() < 18) {
            return "Afternoon";
        }
        return "Night";
    }
}
```

- Here is the simplest test we can write
  - Which problem will you encounter?
```java
class TimeUtilityTests {
    @Test
    void it_should_be_afternoon() {
        assertThat(new TimeUtility().getTimeOfDay())
                .isEqualTo("Afternoon");
    }
}
```

- This test is not repeatable because the design is coupled to `LocalTime.now()`
    - We need to isolate it to be able to test this unitary
    - A few solutions here :
        - Pass a `LocalTime` as method arg
        - Pass a `Clock` which will provide a `time()`method that we will be able to substitute
        - Pass a function `clock: Unit => LocalTime`

- Identify some examples
```text
6:05AM -> Morning
1:00AM -> Night
1PM -> Afternoon
11PM -> Evening
```        

### Use an IClock interface
- Adapt the `TimeUtility` to inject an `IClock` collaborator
  - Generate your code from usage

```java
public class TimeUtility {
    private final Clock clock;

    public TimeUtility(Clock clock) {
        this.clock = clock;
    }

    public String getTimeOfDay() {
        var time = clock.now();

        if (time.getHour() < 6) {
            return "Night";
        } else if (time.getHour() < 12) {
            return "Morning";
        } else if (time.getHour() < 18) {
            return "Afternoon";
        }
        return "Evening";
    }
}

public interface Clock {
    LocalTime now();
}
```

- Now our code has no `hardcoded` dependency anymore
- We need to adapt our tests
  - How to provide a `Clock` in the given state for our test cases?
  - `Test Doubles` is our solution

- To use TestDoubles can use `mockito`
  - Instantiate a `Clock` mock
  - We implement our first test case

```java
@Test
void it_should_return_Morning_for_6am() {
    var clockMock = mock(Clock.class);
    when(clockMock.now()).thenReturn(LocalTime.of(6, 5));

    assertThat(new TimeUtility(clockMock).getTimeOfDay())
            .isEqualTo("Morning");
}
```

```text
✅ 6:05AM -> Morning
1:00AM -> Night
1PM -> Afternoon
11PM -> Evening
```

- Implement others by using a `Parameterized Test` once again
```java
class TimeUtilityTests {
    @ParameterizedTest
    @MethodSource("timeTestCases")
    void supportOperations(int hour, String expectedDescription) {
        var clockMock = mock(Clock.class);
        when(clockMock.now()).thenReturn(LocalTime.of(hour, 0));

        assertThat(
                new TimeUtility(clockMock)
                        .getTimeOfDay()
        ).isEqualTo(expectedDescription);
    }

    private static Stream<Arguments> timeTestCases() {
        return Stream.of(
                Arguments.of(0, "Night"),
                Arguments.of(0, "Night"),
                Arguments.of(4, "Night"),
                Arguments.of(6, "Morning"),
                Arguments.of(9, "Morning"),
                Arguments.of(12, "Afternoon"),
                Arguments.of(17, "Afternoon"),
                Arguments.of(18, "Evening"),
                Arguments.of(23, "Evening")
        );
    }
}
```