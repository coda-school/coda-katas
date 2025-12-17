# Test it or Die Trying (35')
- The test project `UnitTestsIntro.Tests` already contains `xUnit` package reference 
- `xUnit` documentation is available [here](https://xunit.net/)

## Calculator
- Write a few tests on the `Calculator` class
  - What are the `Edge` cases?
  - Write tests on them as well

```c#
public class Calculator
{
    public const string Add = "add";
    public const string Multiply = "multiply";
    public const string Divide = "divide";
    public const string Subtract = "subtract";

    private static readonly Dictionary<string, Func<int, int, int>> SupportedOperators =
        new()
        {
            {Add, (a, b) => a + b},
            {Multiply, (a, b) => a * b},
            {Divide, (a, b) => a / b},
            {Subtract, (a, b) => a - b}
        };
    public int Calculate(int a, int b, string @operator) =>
        SupportedOperators.ContainsKey(@operator)
            ? SupportedOperators[@operator](a, b)
            : throw new ArgumentException("Not supported operator");
}
```

> You are not allowed to change production code

Step-by-step solution is available [here](../solutions/c%23/step-by-step.md)

## TimeUtility
- Write at least one test for it
    - Which problem do you encounter?

```c#
public class TimeUtility
{
    public string GetTimeOfDay()
    {
        var time = DateTime.Now;
        
        return time.Hour switch
        {
            >= 0 and < 6 => "Night",
            >= 6 and < 12 => "Morning",
            >= 12 and < 18 => "Afternoon",
            _ => "Evening"
        };
    }
}
```

- You can use `moq` as `TestDouble` library
  - `moq` documentation is available [here](https://moq.github.io/moq4/)
  - You need to add the package dependency in your test project

> Never trust a test that you have not seen failed

Step-by-step solution is available [here](../solutions/c%23/step-by-step.md)
