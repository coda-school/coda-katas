import TimeUtilityTests.testCases
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.prop.Tables.Table

import java.time.LocalTime

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