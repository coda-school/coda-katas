package holocron;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static holocron.HolocronSystem.hqsToDecimal;
import static holocron.HolocronSystem.calculateForceAverage;

@DisplayName("Episode 09: Le Mystere du Systeme Holocron")
class HolocronSystemTest {

    @Nested
    @DisplayName("hqsToDecimal")
    class HqsToDecimalTest {

        @Test
        @DisplayName("converts single symbols")
        void convertsSingleSymbols() {
            assertThat(hqsToDecimal("\u26AB")).isEqualTo(-2);
            assertThat(hqsToDecimal("\u26AA")).isEqualTo(-1);
            assertThat(hqsToDecimal("0")).isEqualTo(0);
            assertThat(hqsToDecimal("\u2B50")).isEqualTo(1);
            assertThat(hqsToDecimal("Y")).isEqualTo(2);
        }

        @Test
        @DisplayName("converts two-digit numbers")
        void convertsTwoDigitNumbers() {
            assertThat(hqsToDecimal("Y0")).isEqualTo(10);
            assertThat(hqsToDecimal("\u2B50\u2B50")).isEqualTo(6);
            assertThat(hqsToDecimal("\u26AA\u26AB")).isEqualTo(-7);
        }

        @Test
        @DisplayName("converts three-digit numbers")
        void convertsThreeDigitNumbers() {
            assertThat(hqsToDecimal("Y\u2B50\u2B50")).isEqualTo(56);
            assertThat(hqsToDecimal("Y\u2B500\u26AA")).isEqualTo(274);
        }

        @Test
        @DisplayName("converts larger numbers")
        void convertsLargerNumbers() {
            assertThat(hqsToDecimal("\u2B500000")).isEqualTo(625);
            assertThat(hqsToDecimal("YYYYY")).isEqualTo(1562);
        }

        @Test
        @DisplayName("handles negative results")
        void handlesNegativeResults() {
            assertThat(hqsToDecimal("\u26AB\u26AB")).isEqualTo(-12);
            assertThat(hqsToDecimal("\u26AA0")).isEqualTo(-5);
        }
    }

    @Nested
    @DisplayName("calculateForceAverage")
    class CalculateForceAverageTest {

        @Test
        @DisplayName("for hqs file")
        void forHqsFile() throws IOException, URISyntaxException {
            var resource = getClass().getClassLoader().getResource("hqs");
            String[] measurements = Files.readString(Path.of(resource.toURI()))
                    .trim()
                    .split("\\r?\\n");

            assertThat(calculateForceAverage(measurements)).isCloseTo(401.1026, within(0.0001));
        }
    }
}
