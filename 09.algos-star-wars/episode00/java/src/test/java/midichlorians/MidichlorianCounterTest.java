package midichlorians;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static midichlorians.MidichlorianCounter.totalMidichlorians;
import static midichlorians.MidichlorianCounter.Jedi;

@DisplayName("Episode 0: Les Midichloriens")
class MidichlorianCounterTest {

    @Test
    @DisplayName("sums all midichlorians")
    void sumsAllMidichlorians() {
        assertThat(totalMidichlorians(new Jedi[]{
                new Jedi("Luke", 8000),
                new Jedi("Yoda", 12000)
        })).isEqualTo(20000);
    }

    @Test
    @DisplayName("handles empty list")
    void handlesEmptyList() {
        assertThat(totalMidichlorians(new Jedi[]{})).isEqualTo(0);
    }
}
