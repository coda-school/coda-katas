package unit.tests.intro;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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