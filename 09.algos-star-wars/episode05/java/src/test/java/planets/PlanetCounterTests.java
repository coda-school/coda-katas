package planets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static planets.PlanetCounter.countPlanets;

@DisplayName("Episode 5: Le Recensement Galactique")
class PlanetCountTest {
    @Test
    @DisplayName("counts planet occurrences")
    void countsPlanetOccurrences() {
        assertThat(countPlanets(new String[]{"Tatooine", "Hoth", "Tatooine", "Naboo", "Hoth", "Tatooine"}))
                .containsExactlyInAnyOrderEntriesOf(
                        Map.of(
                                "Tatooine", 3,
                                "Hoth", 2,
                                "Naboo", 1
                        ));
    }

    @Test
    @DisplayName("handles empty array")
    void handlesEmptyArray() {
        assertThat(countPlanets(new String[]{})).isEmpty();
    }

    @Test
    @DisplayName("handles single planet repeated")
    void handlesSinglePlanetRepeated() {
        assertThat(countPlanets(new String[]{"Coruscant", "Coruscant", "Coruscant"}))
                .containsExactlyInAnyOrderEntriesOf(Map.of("Coruscant", 3));
    }

    @Test
    @DisplayName("handles all different planets")
    void handlesAllDifferentPlanets() {
        assertThat(countPlanets(new String[]{"Tatooine", "Hoth", "Naboo"}))
                .containsExactlyInAnyOrderEntriesOf(
                        Map.of(
                                "Tatooine", 1,
                                "Hoth", 1,
                                "Naboo", 1
                        )
                );
    }
}