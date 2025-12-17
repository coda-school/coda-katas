package unit.tests.intro;

import java.util.Map;
import java.util.function.BiFunction;

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