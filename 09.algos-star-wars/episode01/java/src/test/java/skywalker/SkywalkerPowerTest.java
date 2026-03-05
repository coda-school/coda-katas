package skywalker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static skywalker.SkywalkerPower.skywalkerPower;
import static skywalker.SkywalkerPower.Jedi;

@DisplayName("Episode 1: La Puissance de Skywalker")
class SkywalkerPowerTest {

    @Test
    @DisplayName("calculates total power of the bloodline")
    void calculatesTotalPowerOfTheBloodline() {
        Jedi tree = new Jedi("Anakin", 100, List.of(
                new Jedi("Luke", 120, List.of(
                        new Jedi("Rey", 100, List.of())
                )),
                new Jedi("Leia", 90, List.of())
        ));

        assertThat(skywalkerPower(tree)).isEqualTo(410);
    }
}
