package transmission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static transmission.DroidTransmission.droidTransmission;

@DisplayName("Episode 8: La Transmission Droide")
class DroidTransmissionTest {
    @Test
    @DisplayName("generates first term")
    void generatesFirstTerm() {
        assertThat(droidTransmission(1))
                .isEqualTo("1");
    }

    @Test
    @DisplayName("generates second term")
    void generatesSecondTerm() {
        assertThat(droidTransmission(2))
                .isEqualTo("11");
    }

    @Test
    @DisplayName("generates third term")
    void generatesThirdTerm() {
        assertThat(droidTransmission(3))
                .isEqualTo("21");
    }

    @Test
    @DisplayName("generates fourth term")
    void generatesFourthTerm() {
        assertThat(droidTransmission(4))
                .isEqualTo("1211");
    }

    @Test
    @DisplayName("generates fifth term")
    void generatesFifthTerm() {
        assertThat(droidTransmission(5))
                .isEqualTo("111221");
    }

    @Test
    @DisplayName("generates sixth term")
    void generatesSixthTerm() {
        assertThat(droidTransmission(6))
                .isEqualTo("312211");
    }

    @Test
    @DisplayName("generates seventh term")
    void generatesSeventhTerm() {
        assertThat(droidTransmission(7))
                .isEqualTo("13112221");
    }
}
