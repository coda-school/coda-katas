# Test it or Die Trying (35')
- The `pom.xml` contains already everything necessary to write / run unit tests
```xml
<properties>
    ...
    <junit.version>5.8.2</junit.version>
    ...
</properties>
 <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>${junit.version}</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>${junit.version}</version>
    <scope>test</scope>
</dependency> 
```
- `junit5` user guide is available [here](https://junit.org/junit5/docs/current/user-guide/)

## Calculator
- Write a few tests on the `Calculator` class
  - What are the `Edge` cases?
  - Write tests on them as well

```java
public class Calculator {
    public static final String ADD = "add";
    public static final String MULTIPLY = "multiply";
    public static final String DIVIDE = "divide";
    public static final String SUBTRACT = "subtract";

    private static final Map<String, BiFunction<Integer, Integer, Integer>> supportedOperators =
            Map.of(
                    ADD, (a, b) -> a + b,
                    MULTIPLY, (a, b) -> a * b,
                    DIVIDE, (a, b) -> a / b,
                    SUBTRACT, (a, b) -> a - b
            );

    public int calculate(int a, int b, String operator) throws IllegalArgumentException {
        if (!supportedOperators.containsKey(operator)) {
            throw new IllegalArgumentException("Not supported operator");
        }
        return supportedOperators.get(operator).apply(a, b);
    }
}
```

> You are not allowed to change production code

Step-by-step solution is available [here](../solutions/java/step-by-step.md)

## TimeUtility
- Write at least one test for it
    - Which problem do you encounter?

```java
public class TimeUtility {
    public String getTimeOfDay() {
        var time = now();

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
```

- You can use `mockito` as `TestDouble` library
  - `mockito` documentation is available [here](https://site.mockito.org/)
  - The dependency is already in the `pom.xml`

```xml
<properties>
    ...
    <mockito.version>4.6.1</mockito.version>
    ...
</properties>
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>${mockito.version}</version>
</dependency>
```

> Never trust a test that you have not seen failed

Step-by-step solution is available [here](../solutions/java/step-by-step.md)
