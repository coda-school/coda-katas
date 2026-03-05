package hyperspace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static hyperspace.HyperSpaceNetwork.canReach;

@DisplayName("Episode 10: Les Routes de l'Hyperespace")
class HyperSpaceNetworkTest {

    private final Map<String, List<String>> network = Map.of(
            "Coruscant", List.of("Tatooine", "Naboo"),
            "Tatooine", List.of("Hoth"),
            "Naboo", List.of("Alderaan"),
            "Hoth", List.of("Dagobah"),
            "Alderaan", List.of(),
            "Dagobah", List.of(),
            "Mustafar", List.of("Geonosis"),
            "Geonosis", List.of()
    );

    @Test
    @DisplayName("finds path between connected planets")
    void findsPathBetweenConnectedPlanets() {
        assertThat(canReach(network, "Coruscant", "Dagobah")).isTrue();
        assertThat(canReach(network, "Coruscant", "Alderaan")).isTrue();
    }

    @Test
    @DisplayName("detects when planets are not connected")
    void detectsWhenPlanetsAreNotConnected() {
        assertThat(canReach(network, "Coruscant", "Mustafar")).isFalse();
        assertThat(canReach(network, "Tatooine", "Mustafar")).isFalse();
    }

    @Test
    @DisplayName("handles same start and destination")
    void handlesSameStartAndDestination() {
        assertThat(canReach(network, "Coruscant", "Coruscant")).isTrue();
    }

    @Test
    @DisplayName("handles non-existent planets")
    void handlesNonExistentPlanets() {
        assertThat(canReach(network, "Unknown", "Tatooine")).isFalse();
        assertThat(canReach(network, "Coruscant", "Unknown")).isFalse();
    }

    @Test
    @DisplayName("handles cyclic graphs")
    void handlesCyclicGraphs() {
        Map<String, List<String>> cyclicNetwork = Map.of(
                "A", List.of("B"),
                "B", List.of("C"),
                "C", List.of("A")
        );
        assertThat(canReach(cyclicNetwork, "A", "C")).isTrue();
        assertThat(canReach(cyclicNetwork, "B", "A")).isTrue();
    }
}
