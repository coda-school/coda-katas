# Test it or Die Trying (35')
In the `build.sbt` the dependency to write your unit test is already provided: 
```scala
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % "test"
```

- `scalatest` documentation is available [here](https://www.scalatest.org/)
- You can write tests using [different styles](https://www.scalatest.org/user_guide/selecting_a_style)

## Calculator
- Write a few tests on the `Calculator` class
  - What are the `Edge` cases?
  - Write tests on them as well

```scala
class Calculator() {
  def calculate(a: Int, b: Int, operator: String): Try[Int] = {
    supportedOperators.get(operator) match {
      case Some(op) => Success(op(a, b))
      case None => Failure(new IllegalArgumentException("Not supported operator"))
    }
  }
}

object Calculator {
  val add = "add";
  val multiply = "multiply";
  val divide = "divide";
  val subtract = "subtract";

  private val supportedOperators = Map[String, (Int, Int) => Int](
    add -> { (a, b) => a + b },
    multiply -> { (a, b) => a * b },
    divide -> { (a, b) => a / b },
    subtract -> { (a, b) => a - b }
  )
}
```

> You are not allowed to change production code

Step-by-step solution is available [here](../solutions/scala/step-by-step.md)

## TimeUtility
- Write at least one test for it
    - Which problem do you encounter?

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

- `scalamock` documentation is available [here](https://scalamock.org/)
- The dependency is already provided
```scala
libraryDependencies += "org.scalamock" %% "scalamock" % "5.1.0" % Test
```

> Never trust a test that you have not seen failed

Step-by-step solution is available [here](../solutions/scala/step-by-step.md)